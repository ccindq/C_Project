package com.cc.project.auth.controller;


import com.cc.project.auth.feign.UserFeignClient;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "Auth API")
public class AggregateController {

    @Autowired
    UserFeignClient userFeignClient;


    @GetMapping(value = "/auth/username", params = "username")
    @ApiOperation(value = "根据用户名查询用户")
    public String findByUsername(String username) {
        return userFeignClient.findByUsername(username);
    }
}
