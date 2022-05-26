package com.example.ygo.service.Impl;

import cn.hutool.core.util.StrUtil;
import com.example.ygo.common.utils.MinioUtil;
import com.example.ygo.entity.MultipartFileInfo;
import com.example.ygo.service.MinioService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 林屹峰
 * @version 1.0
 * @className MinioServiceImpl
 * @description TODO
 * @since 2022/2/18 23:38
 */
@Service("minio")
public class MinioServiceImpl implements MinioService {

    private final static String baseUrl = "http://127.0.0.1:9000";

    @Resource
    private MinioUtil minioUtil;

    @Override
    public MultipartFileInfo upload(String bucketName, MultipartFile file){
        if (file==null || StrUtil.isBlank(bucketName)){
            return null;
        }
        if (!minioUtil.bucketExists(bucketName)){
            minioUtil.makeBucket(bucketName);
        }
        //获取原始文件名
        String originalFileName = file.getOriginalFilename();
        //重命名随机前缀
        String fileName = new SimpleDateFormat("yyyyMMdd").format(new Date()) + "/" + originalFileName;
        minioUtil.putObject(bucketName,file,fileName);
        String url = minioUtil.getObjectUrl(bucketName, fileName);
        MultipartFileInfo multipartFileInfo = new MultipartFileInfo();
        multipartFileInfo.setFileName(fileName);
        multipartFileInfo.setFileUrl(url);
        multipartFileInfo.setFileType(file.getContentType());
        multipartFileInfo.setFileSize(file.getSize());
        return multipartFileInfo;
    }

    @Override
    public MultipartFileInfo upload(String bucketName, MultipartFile file, String prefix) {
        if (file==null || StrUtil.isBlank(bucketName) || StrUtil.isBlank(prefix)){
            return null;
        }
        if (!minioUtil.bucketExists(bucketName)){
            minioUtil.makeBucket(bucketName);
        }
        //获取原始文件名
        String originalFileName = file.getOriginalFilename();
        //重命名指定前缀
        String fileName = prefix + "/" + originalFileName;
        minioUtil.putObject(bucketName,file,fileName);
        String url = minioUtil.getObjectUrl(bucketName, fileName);
        //去除baseUrl
        url = url.replace(baseUrl,"");
        MultipartFileInfo multipartFileInfo = new MultipartFileInfo();
        multipartFileInfo.setFileName(fileName);
        multipartFileInfo.setFileUrl(url);
        multipartFileInfo.setFileType(file.getContentType());
        multipartFileInfo.setFileSize(file.getSize());
        return multipartFileInfo;
    }

    @Override
    public boolean removeObject(String bucketName, String url) {
        if (StrUtil.isBlank(bucketName) || StrUtil.isBlank(url)){
            return false;
        }
        String objectName = url.replace("/"+bucketName,"");
        return minioUtil.removeObject(bucketName,objectName);
    }
}
