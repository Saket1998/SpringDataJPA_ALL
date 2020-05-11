package com.cognizant.moviecruiser.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.moviecruiser.model.Movie;
import com.cognizant.moviecruiser.repository.MovieRepository;

@Service("movieService")
public class MovieService{

	@Autowired
	private MovieRepository movieRepository;

	@Transactional
	public List<Movie> getMovieListAdmin() {
		return movieRepository.findAll();
	}

	@Transactional
	public List<Movie> getMovieListCustomer() {
		return movieRepository.findAllForCustomer();
	}

	@Transactional
	public void modifyMovie(Movie movie) {
		movieRepository.save(movie);
	}

	@Transactional
	public Movie getMovie(long movieId) {
		return movieRepository.getOne(movieId);
	}
	
	
}
