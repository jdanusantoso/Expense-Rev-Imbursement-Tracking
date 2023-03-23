package com.RevUp.Dao;

import java.util.ArrayList;

import com.RevUp.models.Movies;

public abstract class MovieGenres {
	public abstract void viewAllMovies(ArrayList<Movies> moviesArray);
		
	public abstract void searchDatabase(Movies movie, ArrayList<Movies> moviesArray);

	public abstract void searchDatabaseByTitleGenre(Movies movie, ArrayList<Movies> moviesArray);

	public abstract void searchDatabaseByTitle(Movies movie, ArrayList<Movies> moviesArray);
	
	public abstract void addMovieToDatabase(Movies movie, ArrayList<Movies> moviesArray);
	
	public abstract void removeMovieFromDatabase(Movies movie, ArrayList<Movies> moviesArray);


}

	
