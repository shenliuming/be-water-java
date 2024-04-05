package com.be.water.shortchain.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import com.be.water.framework.common.utils.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 新模块测试
 *
 */
@RestController
@RequestMapping("short")
@Tag(name="短链项目")
@AllArgsConstructor
public class ShortChainController {

    @GetMapping()
    @Operation(summary = "测试接口")
    public Result<String> test(){

        return Result.ok("测试数据");
    }
}