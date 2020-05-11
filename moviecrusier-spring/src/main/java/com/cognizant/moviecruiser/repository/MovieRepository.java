package com.cognizant.moviecruiser.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cognizant.moviecruiser.model.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long>{
	@Query("SELECT mt FROM Movie mt WHERE mo_active is true AND mo_date < curdate()")
	List<Movie> findAllForCustomer();
}
