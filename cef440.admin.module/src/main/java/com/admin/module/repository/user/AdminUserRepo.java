package com.admin.module.repository.user;

import org.springframework.transaction.annotation.Transactional;

import com.admin.module.model.user.AdminUser;

@Transactional
public interface AdminUserRepo extends UsersRepository<AdminUser>{

}
