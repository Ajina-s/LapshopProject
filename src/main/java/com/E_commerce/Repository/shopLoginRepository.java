package com.E_commerce.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.E_commerce.model.Category;
import com.E_commerce.model.shopLog;

@Repository
public interface shopLoginRepository extends JpaRepository <shopLog,Integer>
{
//	  shopLog findByEmail(String email);
	Optional<shopLog> findByEmail(String email);
	 //shopLog findByEmail(String email);

	void save(Category category);
	 //shopLog findByLoginid(String loginid);
}
