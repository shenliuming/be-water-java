package com.be.water.system.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.fhs.trans.service.impl.TransService;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import com.be.water.framework.common.constant.Constant;
import com.be.water.framework.common.excel.ExcelFinishCallBack;
import com.be.water.framework.common.exception.ServerException;
import com.be.water.framework.common.utils.DateUtils;
import com.be.water.framework.common.utils.ExcelUtils;
import com.be.water.framework.common.utils.PageResult;
import com.be.water.framework.mybatis.service.impl.BaseServiceImpl;
import com.be.water.framework.security.cache.TokenStoreCache;
import com.be.water.framework.security.user.SecurityUser;
import com.be.water.framework.security.utils.TokenUtils;
import com.be.water.system.convert.SysUserConvert;
import com.be.water.system.dao.SysUserDao;
import com.be.water.system.entity.SysUserEntity;
import com.be.water.system.enums.SuperAdminEnum;
import com.be.water.system.query.SysRoleUserQuery;
import com.be.water.system.query.SysUserQuery;
import com.be.water.system.service.*;
import com.be.water.system.vo.SysUserBaseVO;
import com.be.water.system.vo.SysUserExcelVO;
import com.be.water.system.vo.SysUserVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用户管理
 *
 */
@Service
@AllArgsConstructor
public class SysUserServiceImpl extends BaseServiceImpl<SysUserDao, SysUserEntity> implements SysUserService {
    private final SysUserRoleService sysUserRoleService;
    private final SysUserPostService sysUserPostService;
    private final SysUserTokenService sysUserTokenService;
    private final SysOrgService sysOrgService;
    private final TokenStoreCache tokenStoreCache;
    private final TransService transService;

    @Override
    public PageResult<SysUserVO> page(SysUserQuery query) {
        // 查询参数
        Map<String, Object> params = getParams(query);

        // 分页查询
        IPage<SysUserEntity> page = getPage(query);
        params.put(Constant.PAGE, page);
        
        // 数据列表
        List<SysUserEntity> list = baseMapper.getList(params);

        return new PageResult<>(SysUserConvert.INSTANCE.convertList(list), page.getTotal());
    }

    private Map<String, Object> getParams(SysUserQuery query) {
        Map<String, Object> params = new HashMap<>();
        params.put("username", query.getUsername());
        params.put("mobile", query.getMobile());
        params.put("gender", query.getGender());

        // 数据权限
        params.put(Constant.DATA_SCOPE, getDataScope("t1", null));

        // 机构过滤
        if (query.getOrgId() != null) {
            // 查询子机构ID列表，包含本机构
            List<Long> orgList = sysOrgService.getSubOrgIdList(query.getOrgId());
            params.put("orgList", orgList);
        }

        return params;
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(SysUserVO vo) {
        SysUserEntity entity = SysUserConvert.INSTANCE.convert(vo);
        entity.setSuperAdmin(SuperAdminEnum.NO.getValue());

        // 判断用户名是否存在
        SysUserEntity user = baseMapper.getByUsername(entity.getUsername());
        if (user != null) {
            throw new ServerException("用户名已经存在");
        }

        // 判断手机号是否存在
        user = baseMapper.getByMobile(entity.getMobile());
        if (user != null) {
            throw new ServerException("手机号已经存在");
        }

        // 保存用户
        baseMapper.insert(entity);

        // 保存用户角色关系
        sysUserRoleService.saveOrUpdate(entity.getId(), vo.getRoleIdList());

        // 更新用户岗位关系
        sysUserPostService.saveOrUpdate(entity.getId(), vo.getPostIdList());
    }

    @Override
    public void update(SysUserVO vo) {
        SysUserEntity entity = SysUserConvert.INSTANCE.convert(vo);

        // 判断用户名是否存在
        SysUserEntity user = baseMapper.getByUsername(entity.getUsername());
        if (user != null && !user.getId().equals(entity.getId())) {
            throw new ServerException("用户名已经存在");
        }

        // 判断手机号是否存在
        user = baseMapper.getByMobile(entity.getMobile());
        if (user != null && !user.getId().equals(entity.getId())) {
            throw new ServerException("手机号已经存在");
        }

        // 更新用户
        updateById(entity);

        // 更新用户角色关系
        sysUserRoleService.saveOrUpdate(entity.getId(), vo.getRoleIdList());

        // 更新用户岗位关系
        sysUserPostService.saveOrUpdate(entity.getId(), vo.getPostIdList());

        // 更新用户缓存权限
        sysUserTokenService.updateCacheAuthByUserId(entity.getId());
    }

    @Override
    public void updateLoginInfo(SysUserBaseVO vo) {
        SysUserEntity entity = SysUserConvert.INSTANCE.convert(vo);
        // 设置登录用户ID
        entity.setId(SecurityUser.getUserId());

        // 判断手机号是否存在
        SysUserEntity user = baseMapper.getByMobile(entity.getMobile());
        if (user != null && !user.getId().equals(entity.getId())) {
            throw new ServerException("手机号已经存在");
        }

        // 更新用户
        updateById(entity);

        // 删除用户缓存
        tokenStoreCache.deleteUser(TokenUtils.getAccessToken());
    }

    @Override
    public void delete(List<Long> idList) {
        // 删除用户
        removeByIds(idList);

        // 删除用户角色关系
        sysUserRoleService.deleteByUserIdList(idList);

        // 删除用户岗位关系
        sysUserPostService.deleteByUserIdList(idList);
    }

    @Override
    public SysUserVO getByMobile(String mobile) {
        SysUserEntity user = baseMapper.getByMobile(mobile);

        return SysUserConvert.INSTANCE.convert(user);
    }

    @Override
    public void updatePassword(Long id, String newPassword) {
        // 修改密码
        SysUserEntity user = getById(id);
        user.setPassword(newPassword);

        updateById(user);
    }

    @Override
    public PageResult<SysUserVO> roleUserPage(SysRoleUserQuery query) {
        // 查询参数
        Map<String, Object> params = getParams(query);
        params.put("roleId", query.getRoleId());

        // 分页查询
        IPage<SysUserEntity> page = getPage(query);
        params.put(Constant.PAGE, page);

        // 数据列表
        List<SysUserEntity> list = baseMapper.getRoleUserList(params);

        return new PageResult<>(SysUserConvert.INSTANCE.convertList(list), page.getTotal());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void importByExcel(MultipartFile file, String password) {

        ExcelUtils.readAnalysis(file, SysUserExcelVO.class, new ExcelFinishCallBack<SysUserExcelVO>() {
            @Override
            public void doAfterAllAnalysed(List<SysUserExcelVO> result) {
                saveUser(result);
            }

            @Override
            public void doSaveBatch(List<SysUserExcelVO> result) {
                saveUser(result);
            }

            private void saveUser(List<SysUserExcelVO> result) {
                ExcelUtils.parseDict(result);
                List<SysUserEntity> sysUserEntities = SysUserConvert.INSTANCE.convertListEntity(result);
                sysUserEntities.forEach(user -> user.setPassword(password));
                saveBatch(sysUserEntities);
            }
        });

    }

    @Override
    @SneakyThrows
    public void export() {
        List<SysUserEntity> list = list(Wrappers.lambdaQuery(SysUserEntity.class).eq(SysUserEntity::getSuperAdmin, SuperAdminEnum.NO.getValue()));
        List<SysUserExcelVO> userExcelVOS = SysUserConvert.INSTANCE.convert2List(list);
        transService.transBatch(userExcelVOS);
        // 写到浏览器打开
        ExcelUtils.excelExport(SysUserExcelVO.class, "system_user_excel" + DateUtils.format(new Date()), null, userExcelVOS);
    }

}