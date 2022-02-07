package com.example.ygo.service.Impl;

import com.example.ygo.dao.BaseMapper;
import com.example.ygo.dao.PackageMapper;
import com.example.ygo.entity.Package;
import com.example.ygo.entity.PackageExample;
import com.example.ygo.service.PackageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author 林屹峰
 * @version 1.0
 * @className PackageServiceImpl
 * @description TODO
 * @since 2022/2/7 18:52
 */
@Service("package")
public class PackageServiceImpl extends BaseServiceImpl<Package,Long, PackageExample> implements PackageService {

    @Resource
    private PackageMapper packageMapper;

    @Override
    public BaseMapper<Package, Long, PackageExample> getBaseMapper() {
        return packageMapper;
    }
}
