package com.example.ygo.controller;

import com.example.ygo.common.exception.GlobalException;
import com.example.ygo.common.utils.LogUtil;
import com.example.ygo.common.utils.ResponseMsgUtil;
import com.example.ygo.entity.ResponseData;
import com.example.ygo.service.BaseService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

/**
 * @author 林屹峰
 * @version 1.0
 * @className BaseController
 * @description TODO
 * @since 2022/1/26 13:12
 */
@Slf4j
public abstract class BaseController<Model, PK extends Serializable> {

    public abstract BaseService<Model,PK> getBaseService();

    @RequestMapping(value = "/findById", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "根据ID获得详情")
    public ResponseData findById(@RequestParam(name = "id", required = true)PK id){
        try {
            if (id==null){
                log.error(LogUtil.outLogHead(Thread.currentThread().getStackTrace()[1],"请求参数校验失败"));
                return ResponseMsgUtil.error(GlobalException.REQ_PARAMS_ERROR);
            }
            return ResponseMsgUtil.success(getBaseService().findById(id));
        } catch (Exception e){
            log.error(LogUtil.outLogHead(Thread.currentThread().getStackTrace()[1], GlobalException.UNKNOWN_ERROR), e);
            return ResponseMsgUtil.error(GlobalException.UNKNOWN_ERROR);
        }
    }

    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "获得所有详情")
    public ResponseData findAll(){
        try {
            List<Model> models = getBaseService().findAll();
            return ResponseMsgUtil.success(models);
        } catch (Exception e){
            log.error(LogUtil.outLogHead(Thread.currentThread().getStackTrace()[1],GlobalException.UNKNOWN_ERROR), e);
            return ResponseMsgUtil.error(GlobalException.UNKNOWN_ERROR);
        }
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "添加")
    public ResponseData add(@RequestBody Model model){
        try {
            if (model==null){
                log.error(LogUtil.outLogHead(Thread.currentThread().getStackTrace()[1],"请求参数校验失败"));
                return ResponseMsgUtil.error(GlobalException.REQ_PARAMS_ERROR);
            }
            return ResponseMsgUtil.success(getBaseService().add(model));
        } catch (Exception e){
            log.error(LogUtil.outLogHead(Thread.currentThread().getStackTrace()[1],GlobalException.UNKNOWN_ERROR), e);
            return ResponseMsgUtil.error(GlobalException.UNKNOWN_ERROR);
        }
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "更新")
    public ResponseData update(@RequestBody Model model){
        try {
            if (model==null){
                log.error(LogUtil.outLogHead(Thread.currentThread().getStackTrace()[1],"请求参数校验失败"));
                return ResponseMsgUtil.error(GlobalException.REQ_PARAMS_ERROR);
            }
            return ResponseMsgUtil.success(getBaseService().update(model));
        } catch (Exception e){
            log.error(LogUtil.outLogHead(Thread.currentThread().getStackTrace()[1],GlobalException.UNKNOWN_ERROR), e);
            return ResponseMsgUtil.error(GlobalException.UNKNOWN_ERROR);
        }
    }

    @RequestMapping(value = "/deleteById", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "根据ID删除")
    public ResponseData deleteById(@RequestParam(name = "id", required = true)PK id){
        try {
            if (id==null){
                log.error(LogUtil.outLogHead(Thread.currentThread().getStackTrace()[1],"请求参数校验失败"));
                return ResponseMsgUtil.error(GlobalException.REQ_PARAMS_ERROR);
            }
            return ResponseMsgUtil.success(getBaseService().deleteById(id));
        } catch (Exception e){
            log.error(LogUtil.outLogHead(Thread.currentThread().getStackTrace()[1], GlobalException.UNKNOWN_ERROR), e);
            return ResponseMsgUtil.error(GlobalException.UNKNOWN_ERROR);
        }
    }

    @RequestMapping(value = "/logicalDeleteById", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "根据ID逻辑删除")
    public ResponseData logicalDeleteById(@RequestParam(name = "id", required = true)PK id){
        try {
            if (id==null){
                log.error(LogUtil.outLogHead(Thread.currentThread().getStackTrace()[1],"请求参数校验失败"));
                return ResponseMsgUtil.error(GlobalException.REQ_PARAMS_ERROR);
            }
            return ResponseMsgUtil.success(getBaseService().logicalDeleteById(id));
        } catch (Exception e){
            log.error(LogUtil.outLogHead(Thread.currentThread().getStackTrace()[1], GlobalException.UNKNOWN_ERROR), e);
            return ResponseMsgUtil.error(GlobalException.UNKNOWN_ERROR);
        }
    }
}
