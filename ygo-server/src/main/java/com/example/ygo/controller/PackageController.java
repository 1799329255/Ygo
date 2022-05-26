package com.example.ygo.controller;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.example.ygo.common.exception.GlobalException;
import com.example.ygo.common.utils.LogUtil;
import com.example.ygo.common.utils.ResponseMsgUtil;
import com.example.ygo.entity.Articlecategory;
import com.example.ygo.entity.Package;
import com.example.ygo.entity.ResponseData;
import com.example.ygo.service.BaseService;
import com.example.ygo.service.PackageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 林屹峰
 * @version 1.0
 * @className PackageController
 * @description TODO
 * @since 2022/2/7 18:59
 */
@Controller
@RequestMapping(value = "/package")
@Api(value = "卡包")
@Slf4j
public class PackageController extends BaseController<Package,Long> {

    @Resource
    private PackageService packageService;

    @Override
    public BaseService<Package, Long> getBaseService() {
        return packageService;
    }

    @RequestMapping(value = "/findPackageInfoPage", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "获取卡包列表详情(分页)")
    public ResponseData findCommentInfoPage(String name,
                                            String order,
                                            Integer pageNum,
                                            Integer pageSize){
        if (pageNum==null || pageSize==null
                || pageNum <= 0 || pageSize <= 0){
            log.error(LogUtil.outLogHead(Thread.currentThread().getStackTrace()[1],"请求参数校验失败"));
            return ResponseMsgUtil.error(GlobalException.REQ_PARAMS_ERROR);
        }

        Package pac = new Package();
        pac.setName(name);
        return ResponseMsgUtil.success(packageService.findPackageInfoPage(pac,order,pageNum,pageSize));
    }

    @Override
    public ResponseData logicalDeleteById(Long id) {
        if (id==null){
            log.error(LogUtil.outLogHead(Thread.currentThread().getStackTrace()[1],"请求参数校验失败"));
            return ResponseMsgUtil.error(GlobalException.REQ_PARAMS_ERROR);
        }
        if (packageService.isUsed(id)){
            log.error(LogUtil.outLogHead(Thread.currentThread().getStackTrace()[1],"该卡包已被使用，不能删除！"));
            return ResponseMsgUtil.error("该卡包已被使用，不能删除！");
        }
        return ResponseMsgUtil.success(packageService.logicalDeleteById(id));
    }

    @Override
    public ResponseData add(Package pac) {
        if (pac==null){
            log.error(LogUtil.outLogHead(Thread.currentThread().getStackTrace()[1],"请求参数校验失败"));
            return ResponseMsgUtil.error(GlobalException.REQ_PARAMS_ERROR);
        }
        if (StrUtil.isBlankIfStr(pac.getName())){
            log.error(LogUtil.outLogHead(Thread.currentThread().getStackTrace()[1],"请求参数校验失败"));
            return ResponseMsgUtil.error(GlobalException.REQ_PARAMS_ERROR);
        }
        pac.andLogicalDeleted(false);
        return ResponseMsgUtil.success(packageService.add(pac));
    }

    @RequestMapping(value = "/addPackage", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "添加该卡牌与卡包的联系")
    public ResponseData addPackage(@RequestBody String reqBody){
        JSONObject jsonObject = JSONObject.parseObject(reqBody);
        Long cardId = jsonObject.getLong("cardId");
        //packages json对象转换为list
        JSONArray jsonArray = jsonObject.getJSONArray("packages");
        String jsonArrayString = JSONObject.toJSONString(jsonArray, SerializerFeature.WriteClassName);
        List<Long> packages = JSONObject.parseArray(jsonArrayString, Long.class);

        if (cardId==null || CollectionUtil.isEmpty(packages)){
            log.error(LogUtil.outLogHead(Thread.currentThread().getStackTrace()[1],"请求参数校验失败"));
            return ResponseMsgUtil.error(GlobalException.REQ_PARAMS_ERROR);
        }
        return ResponseMsgUtil.success(packageService.addPackagesByCardId(cardId,packages));
    }

    @RequestMapping(value = "/updatePackage", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "更新该卡牌与卡包的联系")
    public ResponseData updatePackage(@RequestBody String reqBody){
        JSONObject jsonObject = JSONObject.parseObject(reqBody);
        Long cardId = jsonObject.getLong("cardId");
        //packages json对象转换为list
        JSONArray jsonArray = jsonObject.getJSONArray("packages");
        String jsonArrayString = JSONObject.toJSONString(jsonArray, SerializerFeature.WriteClassName);
        List<Long> packages = JSONObject.parseArray(jsonArrayString, Long.class);

        if (cardId==null){
            log.error(LogUtil.outLogHead(Thread.currentThread().getStackTrace()[1],"请求参数校验失败"));
            return ResponseMsgUtil.error(GlobalException.REQ_PARAMS_ERROR);
        }
        return ResponseMsgUtil.success(packageService.updatePackagesByCardId(cardId,packages));
    }
}
