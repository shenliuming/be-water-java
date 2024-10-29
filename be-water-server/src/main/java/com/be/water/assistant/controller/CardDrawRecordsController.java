package com.be.water.assistant.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import com.be.water.framework.common.page.PageResult;
import com.be.water.framework.common.utils.Result;
import com.be.water.assistant.convert.CardDrawRecordsConvert;
import com.be.water.assistant.entity.CardDrawRecordsEntity;
import com.be.water.assistant.service.CardDrawRecordsService;
import com.be.water.assistant.query.CardDrawRecordsQuery;
import com.be.water.assistant.vo.CardDrawRecordsVO;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
* 卡牌抽取记录
*
* @author shenliuming 597478495@qq.com
* @since 1.0.0 2024-10-29
*/
@RestController
@RequestMapping("assistant/records")
@Tag(name="卡牌抽取记录")
@AllArgsConstructor
public class CardDrawRecordsController {
    private final CardDrawRecordsService cardDrawRecordsService;

    @GetMapping("page")
    @Operation(summary = "分页")
    @PreAuthorize("hasAuthority('assistant:records:page')")
    public Result<PageResult<CardDrawRecordsVO>> page(@Valid CardDrawRecordsQuery query){
        PageResult<CardDrawRecordsVO> page = cardDrawRecordsService.page(query);

        return Result.ok(page);
    }

    @GetMapping("{id}")
    @Operation(summary = "信息")
    @PreAuthorize("hasAuthority('assistant:records:info')")
    public Result<CardDrawRecordsVO> get(@PathVariable("id") Long id){
        CardDrawRecordsEntity entity = cardDrawRecordsService.getById(id);

        return Result.ok(CardDrawRecordsConvert.INSTANCE.convert(entity));
    }

    @PostMapping
    @Operation(summary = "保存")
    @PreAuthorize("hasAuthority('assistant:records:save')")
    public Result<String> save(@RequestBody CardDrawRecordsVO vo){
        cardDrawRecordsService.save(vo);

        return Result.ok();
    }

    @PutMapping
    @Operation(summary = "修改")
    @PreAuthorize("hasAuthority('assistant:records:update')")
    public Result<String> update(@RequestBody @Valid CardDrawRecordsVO vo){
        cardDrawRecordsService.update(vo);

        return Result.ok();
    }

    @DeleteMapping
    @Operation(summary = "删除")
    @PreAuthorize("hasAuthority('assistant:records:delete')")
    public Result<String> delete(@RequestBody List<Long> idList){
        cardDrawRecordsService.delete(idList);

        return Result.ok();
    }
}