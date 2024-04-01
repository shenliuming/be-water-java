package com.be.water.system.service;

import com.be.water.framework.common.utils.PageResult;
import com.be.water.framework.mybatis.service.BaseService;
import com.be.water.system.entity.SysRoleEntity;
import com.be.water.system.query.SysRoleQuery;
import com.be.water.system.vo.SysRoleDataScopeVO;
import com.be.water.system.vo.SysRoleVO;

import java.util.List;

/**
 * 角色
 * 
 * @author 阿沐 babamu@126.com
 * <a href="https://be-water.net">MAKU</a>
 */
public interface SysRoleService extends BaseService<SysRoleEntity> {

	PageResult<SysRoleVO> page(SysRoleQuery query);

	List<SysRoleVO> getList(SysRoleQuery query);

	void save(SysRoleVO vo);

	void update(SysRoleVO vo);

	void dataScope(SysRoleDataScopeVO vo);

	void delete(List<Long> idList);
}