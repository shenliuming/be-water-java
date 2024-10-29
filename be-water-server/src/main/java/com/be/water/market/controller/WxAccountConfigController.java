package com.be.water.market.controller;

import com.be.water.framework.common.page.PageResult;
import com.be.water.framework.common.utils.Result;
import com.be.water.market.convert.WxAccountConfigConvert;
import com.be.water.market.entity.WxAccountConfigEntity;
import com.be.water.market.query.WxAccountConfigQuery;
import com.be.water.market.service.WxAccountConfigService;
import com.be.water.market.vo.WxAccountConfigVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
* 存储微信公众号的基础配置信息
*
* @author shenliuming ceekayshen@foxmail.com
* @since 1.0.0 2024-04-13
*/
@RestController
@RequestMapping("water/m_wx_account_config")
@Tag(name="存储微信公众号的基础配置信息")
@AllArgsConstructor
public class WxAccountConfigController {
    private final WxAccountConfigService wxAccountConfigService;

    @GetMapping("page")
    @Operation(summary = "分页")
//    @PreAuthorize("hasAuthority('water:m_wx_account_config:page')")
    public Result<PageResult<WxAccountConfigVO>> page(@ParameterObject @Valid WxAccountConfigQuery query){
        PageResult<WxAccountConfigVO> page = wxAccountConfigService.page(query);

        return Result.ok(page);
    }

    @GetMapping("{id}")
    @Operation(summary = "信息")
//    @PreAuthorize("hasAuthority('water:m_wx_account_config:info')")
    public Result<WxAccountConfigVO> get(@PathVariable("id") Long id){
        WxAccountConfigEntity entity = wxAccountConfigService.getById(id);

        return Result.ok(WxAccountConfigConvert.INSTANCE.convert(entity));
    }

    @PostMapping
    @Operation(summary = "保存")
//    @PreAuthorize("hasAuthority('water:m_wx_account_config:save')")
    public Result<String> save(@RequestBody WxAccountConfigVO vo){
        wxAccountConfigService.save(vo);

        return Result.ok();
    }

    @PutMapping
    @Operation(summary = "修改")
//    @PreAuthorize("hasAuthority('water:m_wx_account_config:update')")
    public Result<String> update(@RequestBody @Valid WxAccountConfigVO vo){
        wxAccountConfigService.update(vo);

        return Result.ok();
    }

    @DeleteMapping
    @Operation(summary = "删除")
//    @PreAuthorize("hasAuthority('water:m_wx_account_config:delete')")
    public Result<String> delete(@RequestBody List<Long> idList){
        wxAccountConfigService.delete(idList);

        return Result.ok();
    }
}