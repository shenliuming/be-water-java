package com.be.water.market.controller;

import com.be.water.framework.common.page.PageResult;
import com.be.water.framework.common.utils.Result;
import com.be.water.market.convert.WxUserConvert;
import com.be.water.market.entity.WxUserEntity;
import com.be.water.market.query.WxUserQuery;
import com.be.water.market.service.WxUserService;
import com.be.water.market.vo.WxUserVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
* 微信用户表
*
* @author shenliuming ceekayshen@foxmail.com
* @since 1.0.0 2024-04-14
*/
@RestController
@RequestMapping("water/m_wx_user")
@Tag(name="微信用户表")
@AllArgsConstructor
public class WxUserController {
    private final WxUserService wxUserService;

    @GetMapping("page")
    @Operation(summary = "分页")
//    @PreAuthorize("hasAuthority('water:m_wx_user:page')")
    public Result<PageResult<WxUserVO>> page(@ParameterObject @Valid WxUserQuery query){
        PageResult<WxUserVO> page = wxUserService.page(query);

        return Result.ok(page);
    }

    @GetMapping("{id}")
    @Operation(summary = "信息")
//    @PreAuthorize("hasAuthority('water:m_wx_user:info')")
    public Result<WxUserVO> get(@PathVariable("id") Long id){
        WxUserEntity entity = wxUserService.getById(id);

        return Result.ok(WxUserConvert.INSTANCE.convert(entity));
    }

    @PostMapping
    @Operation(summary = "保存")
//    @PreAuthorize("hasAuthority('water:m_wx_user:save')")
    public Result<String> save(@RequestBody WxUserVO vo){
        wxUserService.save(vo);

        return Result.ok();
    }

    @PutMapping
    @Operation(summary = "修改")
//    @PreAuthorize("hasAuthority('water:m_wx_user:update')")
    public Result<String> update(@RequestBody @Valid WxUserVO vo){
        wxUserService.update(vo);

        return Result.ok();
    }

    @DeleteMapping
    @Operation(summary = "删除")
//    @PreAuthorize("hasAuthority('water:m_wx_user:delete')")
    public Result<String> delete(@RequestBody List<Long> idList){
        wxUserService.delete(idList);

        return Result.ok();
    }
}