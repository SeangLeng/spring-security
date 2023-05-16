package com.security.springsecuritybasic.repository;

import com.security.springsecuritybasic.model.Account;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Repository
@Mapper
public interface UserRepository {
    @Select("select * from accounttb where email like #{email}")
    Account findUserByEmail(String email);
}
