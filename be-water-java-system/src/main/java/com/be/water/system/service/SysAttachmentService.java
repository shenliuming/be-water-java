package com.be.water.system.service;

import com.be.water.framework.common.page.PageResult;
import com.be.water.framework.common.service.BaseService;
import com.be.water.system.entity.SysAttachmentEntity;
import com.be.water.system.query.SysAttachmentQuery;
import com.be.water.system.vo.SysAttachmentVO;

import java.util.List;

/**
 * 附件管理
 *
 */
public interface SysAttachmentService extends BaseService<SysAttachmentEntity> {

    PageResult<SysAttachmentVO> page(SysAttachmentQuery query);

    void save(SysAttachmentVO vo);

    void update(SysAttachmentVO vo);

    void delete(List<Long> idList);
}