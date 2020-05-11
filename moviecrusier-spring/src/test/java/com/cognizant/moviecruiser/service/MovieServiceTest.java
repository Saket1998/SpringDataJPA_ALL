package com.cognizant.moviecruiser.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cognizant.moviecruiser.model.Movie;
import com.cognizant.moviecruiser.util.DateUtil;

public class MovieServiceTest {
	private static final Logger LOGGER = LoggerFactory.getLogger(MovieServiceTest.class);
	private static MovieService movieService;
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
		movieService = context.getBean(MovieService.class);
		LOGGER.info("Inside main");
	//	testGetMovieAdmin();
//		testGetMovieCustomer();
		testEditMovie();
	//	testGetMovie();
	}

	private static void testGetMovie() {
		LOGGER.info("start");
		LOGGER.debug("Items{}", movieService.getMovie(2));
		LOGGER.info("end");
	}

	private static void testEditMovie() {
		LOGGER.info("start");
		Movie movie = new Movie(2L, "Batman", "$2,518,812,988", true, DateUtil.convertToDate("29/12/2017"), "Superhero", false);
		movieService.modifyMovie(movie);
		LOGGER.debug("Items{}", movieService.getMovieListAdmin());
		LOGGER.info("end");
	}

	private static void testGetMovieCustomer() {
		LOGGER.info("start");
		LOGGER.debug("Items{}", movieService.getMovieListCustomer());
		LOGGER.info("end");
	}

	private static void testGetMovieAdmin() {
		LOGGER.info("start");
		LOGGER.debug("Items{}", movieService.getMovieListAdmin());
		LOGGER.info("end");
	}
}
