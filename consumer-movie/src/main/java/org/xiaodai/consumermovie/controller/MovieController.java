package org.xiaodai.consumermovie.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.xiaodai.consumermovie.feign.UserFeignClient;
import org.xiaodai.consumermovie.pojo.User;

import java.util.List;

@RestController
public class MovieController {
/*
    @Autowired
    private RestTemplate restTemplate;
*/
    @SuppressWarnings("all")
    @Autowired
    private UserFeignClient userFeignClient;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Value("${user.userServiceUrl}")
    private String userServiceUrl;

    /**
     * 老式方法调用
     * @param id
     * @return
     */
   /* @GetMapping("/userid/{id}")
    public User findByUserId(@PathVariable Long id) {
        System.out.println(userServiceUrl);
        return this.restTemplate.getForObject(userServiceUrl + id, User.class);
    }
*/
    /**
     * Feign方法调用
     * @param id
     * @return
     */
    @GetMapping("/user/{id}")
    public User findById(@PathVariable Long id) {
        return this.userFeignClient.findById(id);
    }
    @GetMapping("/user-instance")
    public List<ServiceInstance> showInfo() {
        return this.discoveryClient.getInstances("provider-user");
    }
}
