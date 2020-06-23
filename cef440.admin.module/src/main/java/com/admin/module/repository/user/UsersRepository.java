
  package com.admin.module.repository.user;
  
  import java.util.List;
  
  import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean; 
  //import org.springframework.stereotype.Repository; 
  import org.springframework.stereotype.Repository;
  
  import com.admin.module.model.user.UserType; 
  import com.admin.module.model.user.Users;
  
  @NoRepositoryBean
  public interface UsersRepository<T extends Users> extends CrudRepository<T, Integer>{
  
	  public T findByUserType(String userType);
  }
  
/*
 * @Repository public interface UsersRepository extends JpaRepository<Users,
 * Integer>{
 * 
 * }
 */