package com.be.water.system.service;

import com.be.water.framework.common.page.PageResult;
import com.be.water.framework.common.service.BaseService;
import com.be.water.system.entity.SysRoleEntity;
import com.be.water.system.query.SysRoleQuery;
import com.be.water.system.vo.SysRoleDataScopeVO;
import com.be.water.system.vo.SysRoleVO;

import java.util.List;

/**
 * 角色
 * 
 */
public interface SysRoleService extends BaseService<SysRoleEntity> {

	PageResult<SysRoleVO> page(SysRoleQuery query);

	List<SysRoleVO> getList(SysRoleQuery query);

	void save(SysRoleVO vo);

	void update(SysRoleVO vo);

	void dataScope(SysRoleDataScopeVO vo);

	void delete(List<Long> idList);
}