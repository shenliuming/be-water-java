package com.be.water.assistant.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import com.be.water.framework.common.page.PageResult;
import com.be.water.framework.common.utils.Result;
import com.be.water.assistant.convert.UserConvert;
import com.be.water.assistant.entity.UserEntity;
import com.be.water.assistant.service.UserService;
import com.be.water.assistant.query.UserQuery;
import com.be.water.assistant.vo.UserVO;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
* 用户表
*
* @author shenliuming 597478495@qq.com
* @since 1.0.0 2024-10-29
*/
@RestController
@RequestMapping("assistant/user")
@Tag(name="用户表")
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("page")
    @Operation(summary = "分页")
    @PreAuthorize("hasAuthority('assistant:user:page')")
    public Result<PageResult<UserVO>> page(@Valid UserQuery query){
        PageResult<UserVO> page = userService.page(query);

        return Result.ok(page);
    }

    @GetMapping("{id}")
    @Operation(summary = "信息")
    @PreAuthorize("hasAuthority('assistant:user:info')")
    public Result<UserVO> get(@PathVariable("id") Long id){
        UserEntity entity = userService.getById(id);

        return Result.ok(UserConvert.INSTANCE.convert(entity));
    }

    @PostMapping
    @Operation(summary = "保存")
    @PreAuthorize("hasAuthority('assistant:user:save')")
    public Result<String> save(@RequestBody UserVO vo){
        userService.save(vo);

        return Result.ok();
    }

    @PutMapping
    @Operation(summary = "修改")
    @PreAuthorize("hasAuthority('assistant:user:update')")
    public Result<String> update(@RequestBody @Valid UserVO vo){
        userService.update(vo);

        return Result.ok();
    }

    @DeleteMapping
    @Operation(summary = "删除")
    @PreAuthorize("hasAuthority('assistant:user:delete')")
    public Result<String> delete(@RequestBody List<Long> idList){
        userService.delete(idList);

        return Result.ok();
    }
}