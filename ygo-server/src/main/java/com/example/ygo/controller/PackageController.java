package com.example.ygo.controller;

import com.example.ygo.entity.Package;
import com.example.ygo.service.BaseService;
import com.example.ygo.service.PackageService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

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
}
