package com.example.ygo.controller;

import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSONObject;
import com.example.ygo.common.exception.GlobalException;
import com.example.ygo.common.utils.JwtTokenUtil;
import com.example.ygo.common.utils.LogUtil;
import com.example.ygo.common.utils.ResponseMsgUtil;
import com.example.ygo.entity.ResponseData;
import com.example.ygo.entity.User;
import com.example.ygo.service.BaseService;
import com.example.ygo.service.RoleService;
import com.example.ygo.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 林屹峰
 * @version 1.0
 * @className UserController
 * @description TODO
 * @since 2022/1/30 23:17
 */
@Controller
@RequestMapping(value = "/user")
@Api(value = "用户")
@Slf4j
public class UserController extends BaseController<User,Long>{

    @Resource
    private UserService userService;
    @Resource
    private UserDetailsService userDetailsService;
    @Resource
    private PasswordEncoder passwordEncoder;
    @Resource
    private JwtTokenUtil jwtTokenUtil;
    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @Override
    public BaseService<User, Long> getBaseService() {
        return userService;
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "注册")
    public ResponseData register(@RequestBody String reqBody, HttpServletRequest request) {
        //匹配验证码
        JSONObject jsonObject = JSONObject.parseObject(reqBody);
        String code = jsonObject.getString("code");
        String emailCode = (String) request.getSession().getAttribute("emailCode");
        if(StrUtil.isBlankIfStr(code) || !code.equalsIgnoreCase(emailCode)){
            log.error(LogUtil.outLogHead(Thread.currentThread().getStackTrace()[1],"邮箱验证码错误，请重新输入"));
            return ResponseMsgUtil.error("邮箱验证码错误，请重新输入");
        }
        //注册
        String username = jsonObject.getString("username");
        String password = jsonObject.getString("password");
        String email = jsonObject.getString("email");

        if (userService.findByName(username)!=null){
            log.error(LogUtil.outLogHead(Thread.currentThread().getStackTrace()[1],"用户名已存在，请重新输入"));
            return ResponseMsgUtil.error("用户名已存在，请重新输入");
        }
        if (userService.findByEmail(email)!=null){
            log.error(LogUtil.outLogHead(Thread.currentThread().getStackTrace()[1],"该邮箱已注册，请重新输入"));
            return ResponseMsgUtil.error("该邮箱已注册，请重新输入");
        }
        User user = new User();
        user.setName(username);
        user.setPassword(passwordEncoder.encode(password));
        user.setEmail(email);
        user.setSex(0);
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());
        user.setStatus(1);
        return ResponseMsgUtil.success(userService.addUser(user));
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "登录")
    public ResponseData login(@RequestBody String reqBody, HttpServletRequest request){
        try {
            //匹配验证码
            JSONObject jsonObject = JSONObject.parseObject(reqBody);
            String code = jsonObject.getString("code");
            String captcha = (String) request.getSession().getAttribute("captcha");
            if(StrUtil.isBlankIfStr(code) || !code.equalsIgnoreCase(captcha)){
                log.error(LogUtil.outLogHead(Thread.currentThread().getStackTrace()[1],
                        new ResponseData("1007","验证码错误，请重新输入")));
                return ResponseMsgUtil.error(GlobalException.CODE_ERROR);
            }
            //登录
            String username = jsonObject.getString("username");
            String password = jsonObject.getString("password");
            User user = (User) userDetailsService.loadUserByUsername(username);
            if (user==null || !passwordEncoder.matches(password,user.getPassword())){
                log.error(LogUtil.outLogHead(Thread.currentThread().getStackTrace()[1],
                        new ResponseData("1005","用户名或密码错误")));
                return ResponseMsgUtil.error(GlobalException.USER_LOGIN_ERROR);
            }
            if (!user.isEnabled()){
                log.error(LogUtil.outLogHead(Thread.currentThread().getStackTrace()[1],
                        new ResponseData("1006","账号被禁用，请联系管理员")));
                return ResponseMsgUtil.error(GlobalException.USER_NOT_ENABLED_ERROR);
            }
            //更新用户(密码设为null)
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user,
                    null,user.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            //返回token
            String token = jwtTokenUtil.createToken(user);
            Map<String, Object> tokenMap = new HashMap<>();
            tokenMap.put("tokenHead",tokenHead);
            tokenMap.put("token",token);
            return ResponseMsgUtil.success(tokenMap);
        } catch (Exception e){
            log.error(LogUtil.outLogHead(Thread.currentThread().getStackTrace()[1],GlobalException.UNKNOWN_ERROR), e);
            return ResponseMsgUtil.error(GlobalException.UNKNOWN_ERROR);
        }
    }

    @RequestMapping(value = "/getUserInfo", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "获得当前登录用户详情")
    public ResponseData getUserInfo(){
        try {
            User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            if (user==null){
                log.error(LogUtil.outLogHead(Thread.currentThread().getStackTrace()[1],
                        new ResponseData("401","账号未登录或已过期")));
                return ResponseMsgUtil.error(GlobalException.NOT_LOGIN_ERROR);
            }
            user = userService.getUserInfo(user.getId());
            user.setPassword(null);
            return ResponseMsgUtil.success(user);
        } catch (Exception e){
            log.error(LogUtil.outLogHead(Thread.currentThread().getStackTrace()[1],GlobalException.UNKNOWN_ERROR), e);
            return ResponseMsgUtil.error(GlobalException.UNKNOWN_ERROR);
        }
    }

    @Override
    public ResponseData add(@RequestBody User user){
        try {
            if (userService.isRepeat(user)) {
                log.error(LogUtil.outLogHead(Thread.currentThread().getStackTrace()[1],"用户已存在，请重新输入"));
                return ResponseMsgUtil.error("用户已存在，请重新输入");
            }
            user.setId(null);
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            user.setCreateTime(new Date());
            user.setUpdateTime(new Date());
            user.setStatus(1);
            return ResponseMsgUtil.success(getBaseService().add(user));
        } catch (Exception e){
            log.error(LogUtil.outLogHead(Thread.currentThread().getStackTrace()[1],GlobalException.UNKNOWN_ERROR), e);
            return ResponseMsgUtil.error(GlobalException.UNKNOWN_ERROR);
        }
    }

    @Override
    public ResponseData update(@RequestBody User user) {
        try {
            if (user.getId()==null){
                log.error(LogUtil.outLogHead(Thread.currentThread().getStackTrace()[1],"请求参数校验失败"));
                return ResponseMsgUtil.error(GlobalException.REQ_PARAMS_ERROR);
            }
            User oldUser = userService.findById(user.getId());
            if (oldUser==null){
                log.error(LogUtil.outLogHead(Thread.currentThread().getStackTrace()[1],"该用户不存在，请重新输入"));
                return ResponseMsgUtil.error("该用户不存在，请重新输入");
            }
            if (userService.isRepeat(user)) {
                log.error(LogUtil.outLogHead(Thread.currentThread().getStackTrace()[1],"用户已存在，请重新输入"));
                return ResponseMsgUtil.error("用户已存在，请重新输入");
            }
            oldUser.setName(user.getName());
            oldUser.setAge(user.getAge());
            oldUser.setPic(user.getPic());
            oldUser.setSex(user.getSex());
            oldUser.setAddress(user.getAddress());
            oldUser.setUpdateTime(new Date());
            return ResponseMsgUtil.success(getBaseService().update(oldUser));
        } catch (Exception e){
            log.error(LogUtil.outLogHead(Thread.currentThread().getStackTrace()[1],GlobalException.UNKNOWN_ERROR), e);
            return ResponseMsgUtil.error(GlobalException.UNKNOWN_ERROR);
        }
    }

    @RequestMapping(value = "/updatePassword", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "修改密码")
    public ResponseData updatePassword(Long id,String password,String code,HttpServletRequest request) {
        try {
            if (id==null || StrUtil.isBlank(password)){
                log.error(LogUtil.outLogHead(Thread.currentThread().getStackTrace()[1],"请求参数校验失败"));
                return ResponseMsgUtil.error(GlobalException.REQ_PARAMS_ERROR);
            }
            //匹配验证码
            String emailCode = (String) request.getSession().getAttribute("emailCode");
            if(StrUtil.isBlankIfStr(code) || !code.equalsIgnoreCase(emailCode)){
                log.error(LogUtil.outLogHead(Thread.currentThread().getStackTrace()[1],"邮箱验证码错误，请重新输入"));
                return ResponseMsgUtil.error("邮箱验证码错误，请重新输入");
            }
            User user = userService.findById(id);
            if (user==null) {
                log.error(LogUtil.outLogHead(Thread.currentThread().getStackTrace()[1],"该用户不存在，请重新输入"));
                return ResponseMsgUtil.error("该用户不存在，请重新输入");
            }
            user.setPassword(passwordEncoder.encode(password));
            user.setUpdateTime(new Date());
            return ResponseMsgUtil.success(userService.update(user));
        } catch (Exception e){
            log.error(LogUtil.outLogHead(Thread.currentThread().getStackTrace()[1],GlobalException.UNKNOWN_ERROR), e);
            return ResponseMsgUtil.error(GlobalException.UNKNOWN_ERROR);
        }
    }

    @RequestMapping(value = "/updatePhone", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "修改手机")
    public ResponseData updatePhone(Long id,Long phone,String code,HttpServletRequest request) {
        try {
            if (id==null || phone==null){
                log.error(LogUtil.outLogHead(Thread.currentThread().getStackTrace()[1],"请求参数校验失败"));
                return ResponseMsgUtil.error(GlobalException.REQ_PARAMS_ERROR);
            }
            //匹配验证码
            String emailCode = (String) request.getSession().getAttribute("emailCode");
            if(StrUtil.isBlankIfStr(code) || !code.equalsIgnoreCase(emailCode)){
                log.error(LogUtil.outLogHead(Thread.currentThread().getStackTrace()[1],"邮箱验证码错误，请重新输入"));
                return ResponseMsgUtil.error("邮箱验证码错误，请重新输入");
            }
            User user = userService.findById(id);
            if (user==null) {
                log.error(LogUtil.outLogHead(Thread.currentThread().getStackTrace()[1],"该用户不存在，请重新输入"));
                return ResponseMsgUtil.error("该用户不存在，请重新输入");
            }
            if (userService.findByPhone(phone)!=null){
                log.error(LogUtil.outLogHead(Thread.currentThread().getStackTrace()[1],"该手机已注册，请重新输入"));
                return ResponseMsgUtil.error("该手机已注册，请重新输入");
            }
            user.setPhone(phone);
            user.setUpdateTime(new Date());
            return ResponseMsgUtil.success(userService.update(user));
        } catch (Exception e){
            log.error(LogUtil.outLogHead(Thread.currentThread().getStackTrace()[1],GlobalException.UNKNOWN_ERROR), e);
            return ResponseMsgUtil.error(GlobalException.UNKNOWN_ERROR);
        }
    }

    @RequestMapping(value = "/updateEmail", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "修改邮箱")
    public ResponseData updateEmail(Long id,String email,String code,HttpServletRequest request) {
        try {
            if (id==null || StrUtil.isBlank(email)){
                log.error(LogUtil.outLogHead(Thread.currentThread().getStackTrace()[1],"请求参数校验失败"));
                return ResponseMsgUtil.error(GlobalException.REQ_PARAMS_ERROR);
            }
            //匹配验证码
            String emailCode = (String) request.getSession().getAttribute("emailCode");
            if(StrUtil.isBlankIfStr(code) || !code.equalsIgnoreCase(emailCode)){
                log.error(LogUtil.outLogHead(Thread.currentThread().getStackTrace()[1],"邮箱验证码错误，请重新输入"));
                return ResponseMsgUtil.error("邮箱验证码错误，请重新输入");
            }
            User user = userService.findById(id);
            if (user==null) {
                log.error(LogUtil.outLogHead(Thread.currentThread().getStackTrace()[1],"该用户不存在，请重新输入"));
                return ResponseMsgUtil.error("该用户不存在，请重新输入");
            }
            if (userService.findByEmail(email)!=null){
                log.error(LogUtil.outLogHead(Thread.currentThread().getStackTrace()[1],"该邮箱已注册，请重新输入"));
                return ResponseMsgUtil.error("该邮箱已注册，请重新输入");
            }
            user.setEmail(email);
            user.setUpdateTime(new Date());
            return ResponseMsgUtil.success(userService.update(user));
        } catch (Exception e){
            log.error(LogUtil.outLogHead(Thread.currentThread().getStackTrace()[1],GlobalException.UNKNOWN_ERROR), e);
            return ResponseMsgUtil.error(GlobalException.UNKNOWN_ERROR);
        }
    }

    @RequestMapping(value = "/findFansByUserId", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "根据Id获得其粉丝列表")
    public ResponseData findFansByUserId(Long id){
        try {
            if (id==null){
                log.error(LogUtil.outLogHead(Thread.currentThread().getStackTrace()[1],"请求参数校验失败"));
                return ResponseMsgUtil.error(GlobalException.REQ_PARAMS_ERROR);
            }
            return ResponseMsgUtil.success(userService.findFansByUserId(id));
        } catch (Exception e){
            log.error(LogUtil.outLogHead(Thread.currentThread().getStackTrace()[1],GlobalException.UNKNOWN_ERROR), e);
            return ResponseMsgUtil.error(GlobalException.UNKNOWN_ERROR);
        }
    }

    @RequestMapping(value = "/findFansPageByUserId", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "根据Id获得其粉丝列表(分页)")
    public ResponseData findFansPageByUserId(Long id,Integer pageNum,Integer pageSize){
        try {
            if (id==null || pageNum==null || pageSize==null
                    || pageNum <= 0 || pageSize <= 0){
                log.error(LogUtil.outLogHead(Thread.currentThread().getStackTrace()[1],"请求参数校验失败"));
                return ResponseMsgUtil.error(GlobalException.REQ_PARAMS_ERROR);
            }

            return ResponseMsgUtil.success(userService.findFansPageByUserId(id,pageNum,pageSize));
        } catch (Exception e){
            log.error(LogUtil.outLogHead(Thread.currentThread().getStackTrace()[1],GlobalException.UNKNOWN_ERROR), e);
            return ResponseMsgUtil.error(GlobalException.UNKNOWN_ERROR);
        }
    }

    @RequestMapping(value = "/findFollowsByUserId", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "根据Id获得其关注列表")
    public ResponseData findFollowsByUserId(Long id){
        try {
            if (id==null){
                log.error(LogUtil.outLogHead(Thread.currentThread().getStackTrace()[1],"请求参数校验失败"));
                return ResponseMsgUtil.error(GlobalException.REQ_PARAMS_ERROR);
            }
            return ResponseMsgUtil.success(userService.findFollowsByUserId(id));
        } catch (Exception e){
            log.error(LogUtil.outLogHead(Thread.currentThread().getStackTrace()[1],GlobalException.UNKNOWN_ERROR), e);
            return ResponseMsgUtil.error(GlobalException.UNKNOWN_ERROR);
        }
    }

    @RequestMapping(value = "/findFollowsPageByUserId", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "根据Id获得其关注列表(分页)")
    public ResponseData findFollowsPageByUserId(Long id,Integer pageNum,Integer pageSize){
        try {
            if (id==null || pageNum==null || pageSize==null
                    || pageNum <= 0 || pageSize <= 0){
                log.error(LogUtil.outLogHead(Thread.currentThread().getStackTrace()[1],"请求参数校验失败"));
                return ResponseMsgUtil.error(GlobalException.REQ_PARAMS_ERROR);
            }
            return ResponseMsgUtil.success(userService.findFollowsPageByUserId(id,pageNum,pageSize));
        } catch (Exception e){
            log.error(LogUtil.outLogHead(Thread.currentThread().getStackTrace()[1],GlobalException.UNKNOWN_ERROR), e);
            return ResponseMsgUtil.error(GlobalException.UNKNOWN_ERROR);
        }
    }

}
