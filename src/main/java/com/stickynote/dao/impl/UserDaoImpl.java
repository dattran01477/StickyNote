package com.stickynote.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.stickynote.dao.UserDao;
import com.stickynote.entity.User;

@Repository
@Transactional
public class UserDaoImpl extends AbstractDao<Integer, User> implements UserDao {

}
