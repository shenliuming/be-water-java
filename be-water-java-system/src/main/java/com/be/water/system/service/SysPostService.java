package com.be.water.system.service;

import com.be.water.framework.common.utils.PageResult;
import com.be.water.framework.mybatis.service.BaseService;
import com.be.water.system.entity.SysPostEntity;
import com.be.water.system.query.SysPostQuery;
import com.be.water.system.vo.SysPostVO;

import java.util.List;

/**
 * 岗位管理
 *
 * @author 阿沐 babamu@126.com
 * <a href="https://be-water.net">MAKU</a>
 */
public interface SysPostService extends BaseService<SysPostEntity> {

    PageResult<SysPostVO> page(SysPostQuery query);

    List<SysPostVO> getList();

    List<String> getNameList(List<Long> idList);

    void save(SysPostVO vo);

    void update(SysPostVO vo);

    void delete(List<Long> idList);
}