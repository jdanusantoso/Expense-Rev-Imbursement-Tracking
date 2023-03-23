package com.RevUp.models;

public class Movies {
	
	String movieTitle;
	String movieGenre;
	private int releaseYear;
	
	
	//No Args Constructor
	
	public Movies() {
		// TODO Auto-generated constructor stub
	}
	
	//Parameterized Constructor
	
	public Movies(String movieTitle, String movieGenre, int releaseYear){
		
		this.movieTitle = movieTitle;
		this.movieGenre = movieGenre;
		this.releaseYear = releaseYear;
		
	}
	
	public Movies(String movieTitle, String movieGenre){
		
		this.movieTitle = movieTitle;
		this.movieGenre = movieGenre;
		
		
	}
	
	public Movies(String movieTitle){
		
		this.movieTitle = movieTitle;
		
	}
	

	public  String getMovieTitle() {
		return movieTitle;
	}
	
	public void setMovieTitle(String movieTitle) {
		this.movieTitle = movieTitle;
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
		return "Movies [movieTitle=" + movieTitle + ", movieGenre=" + movieGenre + ", releaseYear=" + releaseYear + "]";
	}
	
	//Method Overloading
	
	//Used in order to provide consistent results of 2 objects are equal, they must have equal hashcode
	@Override
	public int hashCode() {
	    final int prime = 31;
	    int result = 1;
	    result = prime * result + ((movieTitle == null) ? 0 : movieTitle.hashCode());
	    return result;
	}

	@Override
	public boolean equals(Object obj) {
	    if (this == obj)
	        return true;
	    if (obj == null)
	        return false;
	    if (getClass() != obj.getClass())
	        return false;
	    Movies movies = (Movies)obj;
	    	if (movieTitle != null && movies.getMovieTitle() != null) {
	    		if (movieTitle.equals(movies.getMovieTitle())) {
	    		     return true;
	    		  }
	    		  return false;
	    	}
	    	if (movieGenre != null && movies.getMovieGenre() != null) {
	    		if (movieGenre.equals(movies.getMovieGenre())) {
	    		     return true;
	    		  }
	    		  return false;
	    	}
	    	if (releaseYear != 0 && movies.getReleaseYear() != 0) {
	    		if (releaseYear == movies.getReleaseYear()) {
	    		     return true;
	    		  }
	    		  return false;
	    	}
	    return false;
	

	
	}


}
