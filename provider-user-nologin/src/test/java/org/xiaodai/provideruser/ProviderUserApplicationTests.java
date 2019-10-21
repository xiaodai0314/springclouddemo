package org.xiaodai.provideruser;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.xiaodai.provideruser.dao.UserDao;
import org.xiaodai.provideruser.entity.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProviderUserApplicationTests {

    @Autowired
    private UserDao userDao;
    @Test
    public void contextLoads() {
        User user = userDao.querytest("zhangsan", "account1");
        System.out.println(user.toString());
    }

}
