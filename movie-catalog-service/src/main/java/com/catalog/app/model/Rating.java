package com.catalog.app.model;

public class Rating {

	private String movieId;
	private int rsting;
	
	
	public Rating() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Rating(String movieId, int rsting) {
		super();
		this.movieId = movieId;
		this.rsting = rsting;
	}
	public String getMovieId() {
		return movieId;
	}
	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}
	public int getRsting() {
		return rsting;
	}
	public void setRsting(int rsting) {
		this.rsting = rsting;
	}
	
}
