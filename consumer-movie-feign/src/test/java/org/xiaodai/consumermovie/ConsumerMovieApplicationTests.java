package org.xiaodai.consumermovie;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ConsumerMovieApplicationTests {

    @Test
    public void contextLoads() {
        String paasid = "S1233241412";
        System.out.println(paasid.substring(1,paasid.length()));
    }

}
