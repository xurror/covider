package com.admin.module.repository.user;

import org.springframework.transaction.annotation.Transactional;

import com.admin.module.model.user.NormalUser;
import com.admin.module.repository.user.UsersRepository;

@Transactional
public interface NormalUserRepo extends UsersRepository<NormalUser>{

}



