package com.RevUp.UnusedCode;

import com.RevUp.models.Movies;

public class WarMovies extends Movies {

	private String movieGenre;
	private int releaseYear;
	
	public WarMovies(String movieTitle, String movieGenre, int releaseYear) {
		super(movieTitle);
		this.movieGenre = movieGenre;
		this.releaseYear = releaseYear;
	}

	public String getMovieGenre() {
		return movieGenre;
	}

	public void setMovieGenre(String movieGenre) {
		this.movieGenre = movieGenre;
	}

	public int getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}

	@Override
	public String toString() {
		return "All time top rated movies [movieGenre=" + movieGenre + ", releaseYear=" + releaseYear + "]";
	}


}