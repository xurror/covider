package com.admin.module.repository.user;

import org.springframework.transaction.annotation.Transactional;

import com.admin.module.model.user.AgentUser;

@Transactional
public interface AgentUserRepo extends UsersRepository{

}
