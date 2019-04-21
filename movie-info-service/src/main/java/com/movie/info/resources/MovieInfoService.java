package com.movie.info.resources;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movie.info.model.Movie;

@RestController
@RequestMapping("/movieinfo")
public class MovieInfoService {

	@RequestMapping("/{movieId}")
	public Movie getMovieById(@PathVariable("movieId") String movieId) {
		return new Movie(movieId, "Avengers End Game");
	}
	
}
