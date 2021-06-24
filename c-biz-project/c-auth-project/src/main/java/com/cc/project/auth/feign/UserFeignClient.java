package com.cc.project.auth.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author 作者 owen
 * @version 创建时间：2017年11月12日 上午22:57:51
 * 调用用户中心中的userdetail对象，用户oauth中的登录
 * 获取的用户与页面输入的密码 进行BCryptPasswordEncoder匹配
 */

@FeignClient(value = "c-user-project")
public interface UserFeignClient {

    /**
     * feign rpc访问远程/users-anon/login接口
     */
    @GetMapping(value = "/users-anon/login", params = "username")
    String findByUsername(@RequestParam("username") String username);

}
