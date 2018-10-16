package com.mochijump.leveleditor;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
	@Query ("select u.userFirstName, u.userName, u.emailAddress from User u")
	List<User> getAllExceptPassword();

}
