package org.xiaodai.consumermovie.feign;

import feign.Contract;
import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Feign配置类
 * 注意:该类不可以写@Configuration注解;如果加了注解,那么该类不能放在主应用程序上下文@ComponentScan所扫描的包中
 */
public class FeignConfiguration {

    /**
     * 将契约改为feign原生的默认契约,这样就可以使用feign自导的注解了
     */

    @Bean
    public Contract feignContract() {
        return new feign.Contract.Default();
    }
    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }
}
