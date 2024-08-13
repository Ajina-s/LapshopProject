package com.E_commerce.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.E_commerce.model.User;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> 
{

	Optional<User> findByEmail(String email);
	// User findByEmail(String email);

	//User findByLoginId(String username);
	//Optional<User> findByLoginId(@Param("loginid") int loginid);
}

