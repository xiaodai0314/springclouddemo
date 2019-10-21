package org.xiaodai.provideruser.config;

import com.netflix.discovery.DiscoveryClient;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

public class EurekaConfig {

    @Bean
    public DiscoveryClient.DiscoveryClientOptionalArgs discoveryClientOptionalArgs() {
//        List<ClientFilter> additionalFilters = new ArrayList<>();
        return null;
    }
}
