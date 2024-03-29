package com.neo.service.impl;

import com.neo.dao.UserInfoDao;
import com.neo.entity.UserInfo;
import com.neo.service.UserInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Resource
    private UserInfoDao userInfoDao;
    @Override
    public UserInfo findByUsername(String username) {
        System.out.println("UserInfoServiceImpl.findByUsername()" + username);
        return userInfoDao.findByUsername(username);
    }
}