package com.catalog.app.resources;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.catalog.app.model.Catalog;
import com.catalog.app.model.Movie;
import com.catalog.app.model.Rating;
import com.catalog.app.model.UserRating;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private WebClient.Builder webClientBuilder;
	
	@RequestMapping("/{userId}")
	public List<Catalog> getCatalog(@PathVariable("userId") String userId){
		
		UserRating ratings =  restTemplate.getForObject("http://MOIVIE-RATING-SERVICE/ratingsdata/users/" + userId, UserRating.class);
		
		return ratings.getUserRating().stream().map(rating -> {
			Movie movie = restTemplate.getForObject("http://MOIVIE-INFO-SERVICE/movieinfo/" + rating.getMovieId(), Movie.class);
			
			return new Catalog(movie.getName(), "Desc", rating.getRsting());
		})
		.collect(Collectors.toList());
		
		//return Collections.singletonList(new Catalog("Transformers", "Test", 8));
	}

}



/*
 * Movie movie = webClientBuilder.build() .get()
 * .uri("http://localhost:8082/movieinfo/" + rating.getMovieId()) .retrieve()
 * .bodyToMono(Movie.class) .block();
 */