package com.E_commerce.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.E_commerce.model.Products;
@Repository
public interface productRepository  extends JpaRepository<Products, Integer>{
	 List<Products> findByLoginid(int loginid);
	 List<Products> findByNameContainingIgnoreCase(String name);
	 Optional<Products> findById(Integer id);
	 List<Products> findAll();
	;

	    List<Products> findByProcessorContainingIgnoreCase(String processor);

	    List<Products> findByStorageContainingIgnoreCase(String storage);

	    List<Products> findByCategoryNameContainingIgnoreCase(String category);
}
