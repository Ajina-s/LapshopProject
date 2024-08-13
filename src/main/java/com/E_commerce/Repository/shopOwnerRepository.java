package com.E_commerce.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.E_commerce.model.shop_owner;
@Repository
public interface shopOwnerRepository  extends JpaRepository<shop_owner,Integer>
{

	Optional<shop_owner> findByEmail(String email);
	Optional<shop_owner> findById(int id);
	//Optional<shop_owner> findByLogin_LoginId(Integer loginId);
	// Optional<shop_owner> findByLoginId(Integer loginId); // Updated to Integer
	 Optional<shop_owner> findByLogin_Id(int loginId);
}
