package com.RevUp.models;

import java.util.ArrayList;

import com.RevUp.Dao.MovieGenres;


public class MovieDatabase extends MovieGenres {

	public static ArrayList<Movies> moviesArray;
	
	//Parameterized Constructors
	
	public MovieDatabase(ArrayList<Movies> moviesArray) {
		MovieDatabase.moviesArray = moviesArray;
	}

	
	//Methods from Abstract Class
	
	public void viewAllMovies(ArrayList<Movies> moviesArray) {
		

	System.out.println("Fetching all movies.");
	for (Movies movieTitle : moviesArray) {
	System.out.println(movieTitle);
			}
		
	}
	
	
	public void filterMoviesByGenre(Movies movieObj8, ArrayList<Movies> moviesArray) {
		if(movieObj8 != null) {
			if((moviesArray.contains(movieObj8))){
		          System.out.println("Printing out all " + movieObj8 + " found in database.");
		          for (Movies movieGenre : moviesArray) {
		  			if(moviesArray.contains(movieGenre)) {
		  				System.out.println(movieGenre);
		  			}
		          }
		    }else {
		    	System.out.println("The genre you are looking for does not exist in the database yet.");
		    }

		}else {
			System.out.println("Please enter the movie genre and release year again.");
		
		}
		
	}
	
	public void searchDatabase(Movies movieObj2, ArrayList<Movies> moviesArray) {
		
		if(movieObj2 != null) {
			    if((moviesArray.contains(movieObj2))){
			          System.out.println(movieObj2 + " has been found.");
			    }else {
			    	System.out.println("The movie you are looking for does not exist in the database yet.");
			    }

			}else {
				System.out.println("Please enter the movie title, genre, and release year again.");
			}
			
		}





	public void searchDatabaseByTitleGenre(Movies movieObj3, ArrayList<Movies> moviesArray) {
		
		if(movieObj3 != null) {
			if(moviesArray.contains(movieObj3)) {
				System.out.println(movieObj3 + " has been found.");
			}else {
				System.out.println("The movie you are looking for does not exist in the database yet.");
		}
		
		}else {
			System.out.println("Please enter the movie title and genre again.");
		}
		
	}
	
	public void searchDatabaseByTitle(Movies movieObj4, ArrayList<Movies> moviesArray) {
		
		if(movieObj4 != null) {
			if(moviesArray.contains(movieObj4)) {
				System.out.println(movieObj4 + " has been found.");
			}else {
				System.out.println("The movie you are looking for does not exist in the database yet.");
		}
		
		}else {
			System.out.println("Please enter the movie title and genre again.");
		}
		
	}
	
	public void addMovieToDatabase(Movies movieObj5, ArrayList<Movies> moviesArray) {
		
		if(movieObj5 != null) {
			if(moviesArray.contains(movieObj5)) {
		
				System.out.println(movieObj5+ " has been previously added to the database.");
			}else{
				moviesArray.add(movieObj5); 
					System.out.println(movieObj5 + " has been successfully added to the database.");
				}
			
		}else {
			System.out.println("Please enter the movie title and genre again.");
			}
		
	}

	public void removeMovieFromDatabase(Movies movieObj6, ArrayList<Movies> moviesArray) {
		
		if(movieObj6 != null) {
			if(moviesArray.contains(movieObj6)) {
				if(moviesArray.remove(movieObj6)) {
					System.out.println(movieObj6 + " has been successfully removed from the database.");
					System.out.println("The current number of movies in the database is: " + moviesArray.size());
				}

			}else {
				System.out.println(movieObj6+ "does not exist in the database. It may have been previously removed");
		}
		
		}else {
			System.out.println("Please enter the movie title and genre again.");
		}
		
	}


	

	
	
}
