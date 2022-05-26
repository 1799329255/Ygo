package com.example.ygo.service.Impl;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.StrUtil;
import com.example.ygo.dao.BaseMapper;
import com.example.ygo.dao.CardwithpackageMapper;
import com.example.ygo.dao.PackageMapper;
import com.example.ygo.entity.*;
import com.example.ygo.entity.Package;
import com.example.ygo.service.PackageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

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
    @Resource
    private CardwithpackageMapper cardwithpackageMapper;

    @Override
    public BaseMapper<Package, Long, PackageExample> getBaseMapper() {
        return packageMapper;
    }


    @Override
    public PageInfo<Package> findPackageInfoPage(Package pac, String order, Integer pageNum, Integer pageSize) {
        PackageExample packageExample = new PackageExample()
                .createCriteria()
                .when(StrUtil.isNotBlank(pac.getName()),criteria -> criteria.andNameLike("%" + pac.getName() + "%"))
                .andLogicalDeleted(false)
                .example()
                .orderBy(order)
                .when(pageNum != null && pageSize != null, example -> example.page(pageNum, pageSize));;
        long total = packageMapper.countByExample(packageExample);
        List<Package> packages = packageMapper.findPackageInfoByExample(packageExample);
        return new PageInfo<>(packages,pageNum,pageSize,total);
    }

    @Override
    public List<Package> findAll() {
        PackageExample packageExample = new PackageExample()
                .createCriteria()
                .andLogicalDeleted(false)
                .example();
        return getBaseMapper().selectByExample(packageExample);
    }

    @Override
    public boolean isUsed(Long id) {
        CardwithpackageExample cardwithpackageExample = new CardwithpackageExample()
                .createCriteria()
                .when(id!=null,criteria -> criteria.andPackageIdEqualTo(id))
                .example();
        List<Cardwithpackage> cardwithpackages = cardwithpackageMapper.selectByExample(cardwithpackageExample);
        return CollectionUtil.isNotEmpty(cardwithpackages);
    }

    @Override
    public int addPackagesByCardId(Long cardId, List<Long> packages) {
        List<Cardwithpackage> list = packages.stream().map(pac -> new Cardwithpackage(cardId, pac)).collect(Collectors.toList());
        return cardwithpackageMapper.batchInsert(list);
    }

    @Override
    public int updatePackagesByCardId(Long cardId, List<Long> packages) {
        //先删除该卡牌与所有卡包的联系
        cardwithpackageMapper.deleteByExample(
                new CardwithpackageExample()
                        .createCriteria()
                        .andCardIdEqualTo(cardId)
                        .example()
        );
        if (CollectionUtil.isNotEmpty(packages)){
            //再添加联系
            return addPackagesByCardId(cardId, packages);
        }
        return 0;
    }
}
