package com.cognizant.truyum.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cognizant.truyum.model.MenuItem;

@Repository
public interface MenuItemRepository extends JpaRepository<MenuItem, Long> {
	@Query("SELECT mt FROM MenuItem mt WHERE me_active is true AND me_date_of_launch < curdate()")
	List<MenuItem> findAllForCustomer();
}
