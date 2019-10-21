package org.xiaodai.consumermovie.feign;

import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.xiaodai.consumermovie.pojo.User;

//禁用Hystrix
//@FeignClient(name = "provider-user-nologin", configuration = FeignDisableHystrixConfiguration.class, fallback = FeignClientFallback.class, fallbackFactory = FeignClientFallbackFactory.class)
@FeignClient(name = "provider-user-nologin", configuration = FeignConfiguration.class, fallbackFactory = FeignClientFallbackFactory.class)
public interface UserFeignClient {
    @RequestLine("GET /{id}")
    public User findById(@Param("id") Long id);
}

