package com.be.water.shortchain.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import com.be.water.framework.common.page.PageResult;
import com.be.water.framework.common.utils.Result;
import com.be.water.shortchain.convert.ShortLinkConvert;
import com.be.water.shortchain.entity.ShortLinkEntity;
import com.be.water.shortchain.service.ShortLinkService;
import com.be.water.shortchain.query.ShortLinkQuery;
import com.be.water.shortchain.vo.ShortLinkVO;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

/**
* 营销短链表
*
* @author shenliuming ceekayshen@foxmail.com
* @since 1.0.0 2024-04-05
*/
@RestController
@RequestMapping("shortchain/m_short_links")
@Tag(name="营销短链表")
@AllArgsConstructor
public class ShortLinkController {
    private final ShortLinkService shortLinkService;

    @GetMapping("page")
    @Operation(summary = "分页")
    @PreAuthorize("hasAuthority('shortchain:m_short_links:page')")
    public Result<PageResult<ShortLinkVO>> page(@ParameterObject @Valid ShortLinkQuery query){
        PageResult<ShortLinkVO> page = shortLinkService.page(query);

        return Result.ok(page);
    }

    @GetMapping("{id}")
    @Operation(summary = "信息")
    @PreAuthorize("hasAuthority('shortchain:m_short_links:info')")
    public Result<ShortLinkVO> get(@PathVariable("id") Long id){
        ShortLinkEntity entity = shortLinkService.getById(id);

        return Result.ok(ShortLinkConvert.INSTANCE.convert(entity));
    }

    @PostMapping
    @Operation(summary = "保存")
    @PreAuthorize("hasAuthority('shortchain:m_short_links:save')")
    public Result<String> save(@RequestBody ShortLinkVO vo){
        shortLinkService.save(vo);

        return Result.ok();
    }

    @PutMapping
    @Operation(summary = "修改")
    @PreAuthorize("hasAuthority('shortchain:m_short_links:update')")
    public Result<String> update(@RequestBody @Valid ShortLinkVO vo){
        shortLinkService.update(vo);

        return Result.ok();
    }

    @DeleteMapping
    @Operation(summary = "删除")
    @PreAuthorize("hasAuthority('shortchain:m_short_links:delete')")
    public Result<String> delete(@RequestBody List<Long> idList){
        shortLinkService.delete(idList);

        return Result.ok();
    }
}