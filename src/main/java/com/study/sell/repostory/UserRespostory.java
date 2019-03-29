package com.study.sell.repostory;

import com.study.sell.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Auther : 冷科
 * @Date : 2019/3/9 23:02
 */
@Repository
public interface UserRespostory extends JpaRepository<User, String> {
    public User findByUserName(String userName);
}
