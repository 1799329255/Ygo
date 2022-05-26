package com.example.ygo.controller;

import com.example.ygo.common.exception.GlobalException;
import com.example.ygo.common.utils.LogUtil;
import com.example.ygo.common.utils.ResponseMsgUtil;
import com.example.ygo.entity.Article;
import com.example.ygo.entity.MultipartFileInfo;
import com.example.ygo.entity.ResponseData;
import com.example.ygo.service.MinioService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author 林屹峰
 * @version 1.0
 * @className UploadController
 * @description TODO
 * @since 2022/2/21 17:46
 */
@Controller
@RequestMapping(value = "/upload")
@Api(value = "上传")
@Slf4j
public class UploadController {

    @Resource
    private MinioService minioService;

    @RequestMapping(value = "/cacheFile", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "缓存文件")
    public ResponseData cacheFile(MultipartFile file) {
        try {
            if (file==null){
                log.error(LogUtil.outLogHead(Thread.currentThread().getStackTrace()[1],"请求参数校验失败"));
                return ResponseMsgUtil.error(GlobalException.REQ_PARAMS_ERROR);
            }
            //指定桶名
            String bucketName = "cache";
            //上传新的文件
            MultipartFileInfo multipartFileInfo = minioService.upload(bucketName, file);
            return ResponseMsgUtil.success(multipartFileInfo);
        } catch (Exception e){
            log.error(LogUtil.outLogHead(Thread.currentThread().getStackTrace()[1],GlobalException.UNKNOWN_ERROR), e);
            return ResponseMsgUtil.error(GlobalException.UNKNOWN_ERROR);
        }
    }
}
