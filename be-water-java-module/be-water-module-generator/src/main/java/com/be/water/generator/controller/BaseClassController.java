package com.be.water.generator.controller;

import lombok.AllArgsConstructor;
import com.be.water.generator.common.page.PageResult;
import com.be.water.generator.common.query.Query;
import com.be.water.generator.common.utils.Result;
import com.be.water.generator.entity.BaseClassEntity;
import com.be.water.generator.service.BaseClassService;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

/**
 * 基类管理
 *

 */
@RestController
@RequestMapping("be-water-generator/gen/baseclass")
@AllArgsConstructor
public class BaseClassController {
    private final BaseClassService baseClassService;

    @GetMapping("page")
    public Result<PageResult<BaseClassEntity>> page(Query query) {
        PageResult<BaseClassEntity> page = baseClassService.page(query);

        return Result.ok(page);
    }

    @GetMapping("list")
    public Result<List<BaseClassEntity>> list() {
        List<BaseClassEntity> list = baseClassService.getList();

        return Result.ok(list);
    }

    @GetMapping("{id}")
    public Result<BaseClassEntity> get(@PathVariable("id") Long id) {
        BaseClassEntity data = baseClassService.getById(id);

        return Result.ok(data);
    }

    @PostMapping
    public Result<String> save(@RequestBody BaseClassEntity entity) {
        baseClassService.save(entity);

        return Result.ok();
    }

    @PutMapping
    public Result<String> update(@RequestBody BaseClassEntity entity) {
        baseClassService.updateById(entity);

        return Result.ok();
    }

    @DeleteMapping
    public Result<String> delete(@RequestBody Long[] ids) {
        baseClassService.removeBatchByIds(Arrays.asList(ids));

        return Result.ok();
    }
}