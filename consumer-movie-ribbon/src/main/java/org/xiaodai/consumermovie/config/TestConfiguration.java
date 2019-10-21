package org.xiaodai.consumermovie.config;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Configuration;

@Configuration
@RibbonClient(name = "provider-user-nologin", configuration = RibbonConfiguration.class )
public class TestConfiguration {
}
