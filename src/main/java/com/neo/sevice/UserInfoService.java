package com.neo.sevice;

import com.neo.entity.UserInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserInfoService {
    /**通过username查找用户信息;*/
    UserInfo findByUsername(String username);
    Page<UserInfo> findAll(Pageable pageable);
    /**自定义查询**/
    List<UserInfo> findAllUserList();
}