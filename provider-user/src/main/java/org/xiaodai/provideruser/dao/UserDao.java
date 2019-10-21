package org.xiaodai.provideruser.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.xiaodai.provideruser.entity.User;

import java.util.List;

@Repository
public interface UserDao extends JpaRepository<User, Long> {

    @Query(value = "select * from user where name = ?1 and username = ?2", nativeQuery = true)
    User querytest(String name, String username);
}
