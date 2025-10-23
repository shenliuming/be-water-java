package com.be.water.cbg.controller;

import com.be.water.cbg.convert.CbgAccountConvert;
import com.be.water.cbg.entity.CbgAccountEntity;
import com.be.water.cbg.query.CbgAccountQuery;
import com.be.water.cbg.service.CbgAccountService;
import com.be.water.cbg.vo.CbgAccountVO;
import com.be.water.framework.common.utils.Result;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
* 藏宝阁阴阳师账号主表
*
* @author linghu ceekayshen@163.com
* @since 1.0.0 2025-10-23
*/
@RestController
@RequestMapping("ddm/account")
@Tag(name="藏宝阁阴阳师账号主表")
@AllArgsConstructor
public class CbgAccountController {
    private final CbgAccountService cbgAccountService;

    @GetMapping("page")
    @Operation(summary = "分页")
    public Result<PageResult<CbgAccountVO>> page(@Valid CbgAccountQuery query){
        PageResult<CbgAccountVO> page = cbgAccountService.page(query);

        return Result.ok(page);
    }

    @GetMapping("{id}")
    @Operation(summary = "信息")
    public Result<CbgAccountVO> get(@PathVariable("id") Long id){
        CbgAccountEntity entity = cbgAccountService.getById(id);

        return Result.ok(CbgAccountConvert.INSTANCE.convert(entity));
    }

    @PostMapping
    @Operation(summary = "保存")
    public Result<String> save(@RequestBody CbgAccountVO vo){
        cbgAccountService.save(vo);

        return Result.ok();
    }

    @PutMapping
    @Operation(summary = "修改")
    public Result<String> update(@RequestBody @Valid CbgAccountVO vo){
        cbgAccountService.update(vo);

        return Result.ok();
    }

    @DeleteMapping
    @Operation(summary = "删除")
    public Result<String> delete(@RequestBody List<Long> idList){
        cbgAccountService.delete(idList);

        return Result.ok();
    }
}