package com.neo.sevice.impl;

import com.neo.dao.UserInfoDao;
import com.neo.entity.UserInfo;
import com.neo.sevice.UserInfoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Resource
    private UserInfoDao userInfoDao;
    @Override
    public UserInfo findByUsername(String username) {
        System.out.println("UserInfoServiceImpl.findByUsername()");
        return userInfoDao.findByUsername(username);
    }

    @Override
    public Page<UserInfo> findAll(Pageable pageable) {
        return userInfoDao.findAll(pageable);
    }

    @Override
    public List<UserInfo> findAllUserList() {
        return userInfoDao.test();
    }


}