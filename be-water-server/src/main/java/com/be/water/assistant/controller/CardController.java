package com.be.water.assistant.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import com.be.water.framework.common.page.PageResult;
import com.be.water.framework.common.utils.Result;
import com.be.water.assistant.convert.CardConvert;
import com.be.water.assistant.entity.CardEntity;
import com.be.water.assistant.service.CardService;
import com.be.water.assistant.query.CardQuery;
import com.be.water.assistant.vo.CardVO;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
* 卡牌信息表
*
* @author shenliuming 597478495@qq.com
* @since 1.0.0 2024-10-29
*/
@RestController
@RequestMapping("assistant/card")
@Tag(name="卡牌信息表")
@AllArgsConstructor
public class CardController {
    private final CardService cardService;

    @GetMapping("page")
    @Operation(summary = "分页")
    @PreAuthorize("hasAuthority('assistant:card:page')")
    public Result<PageResult<CardVO>> page(@Valid CardQuery query){
        PageResult<CardVO> page = cardService.page(query);

        return Result.ok(page);
    }

    @GetMapping("{id}")
    @Operation(summary = "信息")
    @PreAuthorize("hasAuthority('assistant:card:info')")
    public Result<CardVO> get(@PathVariable("id") Long id){
        CardEntity entity = cardService.getById(id);

        return Result.ok(CardConvert.INSTANCE.convert(entity));
    }

    @PostMapping
    @Operation(summary = "保存")
    @PreAuthorize("hasAuthority('assistant:card:save')")
    public Result<String> save(@RequestBody CardVO vo){
        cardService.save(vo);

        return Result.ok();
    }

    @PutMapping
    @Operation(summary = "修改")
    @PreAuthorize("hasAuthority('assistant:card:update')")
    public Result<String> update(@RequestBody @Valid CardVO vo){
        cardService.update(vo);

        return Result.ok();
    }

    @DeleteMapping
    @Operation(summary = "删除")
    @PreAuthorize("hasAuthority('assistant:card:delete')")
    public Result<String> delete(@RequestBody List<Long> idList){
        cardService.delete(idList);

        return Result.ok();
    }
}