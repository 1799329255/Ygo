package com.example.ygo.service;

import com.example.ygo.entity.Package;
import com.example.ygo.entity.PageInfo;

import java.util.List;

/**
 * @author 林屹峰
 * @version 1.0
 * @className PackageService
 * @description TODO
 * @since 2022/2/7 18:51
 */
public interface PackageService extends BaseService<Package,Long>{

    PageInfo<Package> findPackageInfoPage(Package pac,
                                          String order,
                                          Integer pageNum,
                                          Integer pageSize);
    boolean isUsed(Long id);

    int addPackagesByCardId(Long cardId, List<Long> packages);

    int updatePackagesByCardId(Long cardId, List<Long> packages);
}
