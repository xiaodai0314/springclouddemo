package org.xiaodai.consumermovie.feign;

import org.springframework.stereotype.Component;
import org.xiaodai.consumermovie.pojo.User;

@Component
public class FeignClientFallback implements UserFeignClient{
    @Override
    public User findById(Long id) {
        User user = new User();
        user.setId(-1L);
        user.setUsername("默认用户");
        return user;
    }
}
