package com.revature.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.revature.models.PSize;

@Repository
public interface PSizeRepository extends CrudRepository<PSize, Integer>{
	List<PSize> findByPsizeName (String psizeName);
}
