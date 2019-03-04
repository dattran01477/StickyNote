package com.stickynote.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.stickynote.dao.RoleDao;
import com.stickynote.entity.Role;

@Repository
@Transactional
public class RoleDaoImpl extends AbstractDao<Integer, Role> implements RoleDao {


}
