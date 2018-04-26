package com.neo.dao;

import com.neo.entity.UserInfo;
import org.apache.catalina.User;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserInfoDao extends JpaRepository<UserInfo,Long>
        ,JpaSpecificationExecutor<UserInfo> {
    /**通过username查找用户信息;*/
    public UserInfo findByUsername(String username);

    @Override
    Page<UserInfo> findAll(Pageable pageable);

    @Override
    Page<UserInfo> findAll(Specification<UserInfo> specification, Pageable pageable);
    @Query(value = "select  name from UserInfo ")
    List<UserInfo> test();

}