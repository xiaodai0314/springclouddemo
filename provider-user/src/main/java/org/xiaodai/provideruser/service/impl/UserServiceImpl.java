package org.xiaodai.provideruser.service.impl;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xiaodai.provideruser.dao.UserDao;
import org.xiaodai.provideruser.entity.User;
import org.xiaodai.provideruser.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    @Autowired
    private UserDao userDao;

    @Override
    public User findOne(Long id) {
        logger.info("进入到Uservice");
        return userDao.findOne(id);
    }
}
