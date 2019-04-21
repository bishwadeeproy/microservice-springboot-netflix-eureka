package com.rating.data.resources;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rating.data.model.Rating;
import com.rating.data.model.UserRating;

@RestController
@RequestMapping("/ratingsdata")
public class RatingService {

	@RequestMapping("/{movieId}")
	public Rating getMovieRatig(@PathVariable("movieId") String movieId) {
		return new Rating(movieId, 9);
	}
	
	@RequestMapping("/users/{userId}")
	public UserRating getUserRating(@PathVariable("userId") String userId) {
		
		List<Rating> ratings = Arrays.asList(
				new Rating("123", 8),
				new Rating("1234", 9)
			);
		
		UserRating userRating = new UserRating();
		userRating.setUserRating(ratings);
		
		return userRating;
		
	}
}
