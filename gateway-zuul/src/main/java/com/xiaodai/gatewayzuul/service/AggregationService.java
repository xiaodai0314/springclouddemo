package com.xiaodai.gatewayzuul.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.xiaodai.gatewayzuul.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import rx.Observable;

@Service
public class AggregationService {
    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "fallback")
    public Observable<User> getUserById(Long id) {
        //创建一个观察者
        return Observable.create(observer -> {
            //请求用户微服务的/{id}
            User user = restTemplate.getForObject("http://provider-user-nologin/{id}", User.class, id);
            observer.onNext(user);
            observer.onCompleted();
        });
    }

    @HystrixCommand(fallbackMethod = "fallback")
    public Observable<User> getMovieUserById(Long id) {
        //创建一个观察者
        return Observable.create(observer -> {
            //请求电影微服务的/{id}
            User user = restTemplate.getForObject("http://consume-movie/user/{id}", User.class, id);
            observer.onNext(user);
            observer.onCompleted();
        });
    }

    public User fallback(Long id) {
        User user = new User();
        user.setId(-3L);
        return user;
    }
}
