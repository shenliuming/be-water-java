package net.water.generator.service;

import net.water.generator.common.page.PageResult;
import net.water.generator.common.query.Query;
import net.water.generator.common.service.BaseService;
import net.water.generator.entity.ProjectModifyEntity;

import java.io.IOException;

/**
 * 项目名变更
 *

 */
public interface ProjectModifyService extends BaseService<ProjectModifyEntity> {

    PageResult<ProjectModifyEntity> page(Query query);

    byte[] download(ProjectModifyEntity project) throws IOException;

}