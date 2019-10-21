package org.xiaodai.consumermovie.feign;

import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.xiaodai.consumermovie.pojo.User;

@Component
public class FeignClientFallbackFactory implements FallbackFactory<UserFeignClient> {
    private static Logger LOGGER = LoggerFactory.getLogger(FeignClientFallbackFactory.class);

    @Override
    public UserFeignClient create(Throwable cause) {
        return new UserFeignClient() {
            @Override
            public User findById(Long id) {
                FeignClientFallbackFactory.LOGGER.info("fallback; raason was:", cause);
                User user = new User();
                user.setUsername("默认用户");
                if (cause instanceof IllegalArgumentException) {
                    user.setId(-1L);
                } else {
                    user.setId(-2L);
                }
                return user;
            }
        };
    }
}
