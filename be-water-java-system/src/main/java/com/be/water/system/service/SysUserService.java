package com.be.water.system.service;

import com.be.water.framework.common.utils.PageResult;
import com.be.water.framework.mybatis.service.BaseService;
import com.be.water.system.entity.SysUserEntity;
import com.be.water.system.query.SysRoleUserQuery;
import com.be.water.system.query.SysUserQuery;
import com.be.water.system.vo.SysUserBaseVO;
import com.be.water.system.vo.SysUserVO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * 用户管理
 *
 */
public interface SysUserService extends BaseService<SysUserEntity> {

    PageResult<SysUserVO> page(SysUserQuery query);

    void save(SysUserVO vo);

    void update(SysUserVO vo);

    void updateLoginInfo(SysUserBaseVO vo);

    void delete(List<Long> idList);

    SysUserVO getByMobile(String mobile);

    /**
     * 修改密码
     *
     * @param id          用户ID
     * @param newPassword 新密码
     */
    void updatePassword(Long id, String newPassword);

    /**
     * 分配角色，用户列表
     */
    PageResult<SysUserVO> roleUserPage(SysRoleUserQuery query);

    /**
     * 批量导入用户
     *
     * @param file     excel文件
     * @param password 密码
     */
    void importByExcel(MultipartFile file, String password);

    /**
     * 导出用户信息表格
     */
    void export();
}