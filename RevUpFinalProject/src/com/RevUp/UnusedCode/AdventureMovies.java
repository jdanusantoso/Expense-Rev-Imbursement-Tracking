package com.RevUp.UnusedCode;

import com.RevUp.models.Movies;

public class AdventureMovies extends Movies {

	private String movieGenre;
	private int releaseYear;
	
	public AdventureMovies(String movieTitle, String movieGenre, int releaseYear) {
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
		return "AdventureMovies [movieGenre=" + movieGenre + ", releaseYear=" + releaseYear + "]";
	}

	
}
