package com.be.water.generator.service;

import com.be.water.generator.common.page.PageResult;
import com.be.water.generator.common.query.Query;
import com.be.water.generator.common.service.BaseService;
import com.be.water.generator.entity.ProjectModifyEntity;

import java.io.IOException;

/**
 * 项目名变更
 *

 */
public interface ProjectModifyService extends BaseService<ProjectModifyEntity> {

    PageResult<ProjectModifyEntity> page(Query query);

    byte[] download(ProjectModifyEntity project) throws IOException;

}