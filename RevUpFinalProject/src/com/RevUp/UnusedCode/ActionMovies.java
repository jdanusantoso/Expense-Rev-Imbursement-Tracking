package com.RevUp.UnusedCode;


public class ActionMovies{

	private String movieGenre;
	private int releaseYear;
	
	public ActionMovies(String movieTitle, String movieGenre, int releaseYear) {
		super();
		
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
		return "ActionMovies [movieGenre=" + movieGenre + ", releaseYear=" + releaseYear + "]";
	}

	

	
}
