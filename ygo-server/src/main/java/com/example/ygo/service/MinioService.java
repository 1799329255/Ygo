package com.example.ygo.service;

import com.example.ygo.entity.MultipartFileInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author 林屹峰
 * @version 1.0
 * @className MinioService
 * @description TODO
 * @since 2022/2/18 23:58
 */
public interface MinioService {

    public MultipartFileInfo upload(String bucketName, MultipartFile file);

    public MultipartFileInfo upload(String bucketName,MultipartFile file,String fileName);

    public boolean removeObject(String bucketName, String url);
}
