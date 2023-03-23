package com.RevUp;

import java.util.ArrayList;
import java.util.Scanner;

import com.RevUp.Exceptions.InputMismatchException;
import com.RevUp.Exceptions.InvalidReleaseYearInputException;
import com.RevUp.models.MovieDatabase;
import com.RevUp.models.Movies;

public class Driver {
	
	public static void main(String[] args) {
		
		//Creating ArrayList
		ArrayList<Movies>moviesArray = new ArrayList<Movies>();
		
		//Create new movie objects
		Movies movie1 = new Movies("ambulance", "action", 2022 );
		Movies movie2 = new Movies("the batman", "action", 2022 );
		Movies movie3 = new Movies("the lost city", "action", 2022 );
		Movies movie4 = new Movies("everything everywhere all at once", "action", 2022 );
		Movies movie5 = new Movies("the contractor", "action", 2022 );
		Movies movie6 = new Movies("the northman", "action", 2022 );
		Movies movie7 = new Movies("doctor strange and the multiverse of madness", "action", 2022 );
		Movies movie8 = new Movies("the roundup", "action", 2022 );
		Movies movie9 = new Movies("top gun: maverick", "action", 2022 );
		Movies movie10 = new Movies("jurassic world: dominion", "action", 2022 );
		Movies movie11 = new Movies("operation fortune: ruse de guerre", "action", 2022 );
		
		
		Movies movie12 = new Movies("uncharted", "adventure", 2022 );
		Movies movie13 = new Movies("free guy", "adventure", 2021 );
		Movies movie14 = new Movies("moonfall", "adventure", 2022 );
		Movies movie15 = new Movies("dune", "adventure", 2021 );
		Movies movie16 = new Movies("ghostbusters afterlife", "adventure", 2021 );
		Movies movie17 = new Movies("spiderman no way home", "adventure", 2021 );
		Movies movie18 = new Movies("morbius", "adventure", 2022 );
		Movies movie19 = new Movies("no time to die", "adventure", 2021 );
		Movies movie20 = new Movies("the secrets of dumbledore", "adventure", 2022 );
		Movies movie21 = new Movies("the bad guys", "adventure", 2022 );
		Movies movie22 = new Movies("eternals", "adventure", 2021 );
		
		Movies movie23 = new Movies("jackass forever", "comedy", 2022 );
		Movies movie24 = new Movies("marry me", "comedy", 2021 );
		Movies movie25 = new Movies("i want you back", "comedy", 2022 );
		Movies movie26 = new Movies("dog", "comedy", 2021 );
		Movies movie27 = new Movies("turning red", "comedy", 2021 );
		Movies movie28 = new Movies("the unbearable weight of massive talent", "comedy", 2021 );
		Movies movie29 = new Movies("senior year", "comedy", 2022 );
		Movies movie30 = new Movies("chip 'n dale: rescue rangers", "comedy", 2021 );
		Movies movie31 = new Movies("a perfect pairing", "comedy", 2022 );
		Movies movie32 = new Movies("the bob's burgers movie", "comedy", 2022 );
		Movies movie33 = new Movies("fire island", "comedy", 2021 );
		
		Movies movie34 = new Movies("luckiest girl alive", "drama", 2022 );
		Movies movie35 = new Movies("amsterdam", "drama", 2022 );
		Movies movie36 = new Movies("mr. harrigan's phone", "drama", 2022 );
		Movies movie37 = new Movies("blonde", "drama", 2022 );
		Movies movie38 = new Movies("grimcutty", "drama", 2022 );
		Movies movie39 = new Movies("the woman king", "drama", 2022 );
		Movies movie40 = new Movies("triangle of sadness", "drama", 2022 );
		Movies movie41 = new Movies("the banshees of inisherin", "drama", 2022 );
		Movies movie42 = new Movies("significant other", "drama", 2022 );
		Movies movie43 = new Movies("the greatest beer run ever", "drama", 2022 );
		Movies movie44 = new Movies("where the crawdads sing", "drama", 2021 );
		
		Movies movie45 = new Movies("halloween ends", "horror", 2022 );
		Movies movie46 = new Movies("x", "horror", 2022 );
		Movies movie47 = new Movies("watcher", "horror", 2022 );
		Movies movie48 = new Movies("midsommar", "horror", 2019 );
		Movies movie49 = new Movies("dashcam", "horror", 2021 );
		Movies movie50 = new Movies("hereditary", "horror", 2018 );
		Movies movie51 = new Movies("halloween", "horror", 2018 );
		Movies movie52 = new Movies("nope", "horror", 2021 );
		Movies movie53 = new Movies("jeepers creepers reborn", "horror", 2022 );
		Movies movie54 = new Movies("hellraiser", "horror", 2022 );
		Movies movie55 = new Movies("doctor sleep", "horror", 2019 );
		
		Movies movie56 = new Movies("a star is born", "romance", 2018 );
		Movies movie57 = new Movies("call me by your name", "romance", 2017 );
		Movies movie58 = new Movies("bros", "romance", 2022 );
		Movies movie59 = new Movies("the vow", "romance", 2012 );
		Movies movie60 = new Movies("la la land", "romance", 2016 );
		Movies movie61 = new Movies("crazy rich asians", "romance", 2018 );
		Movies movie62 = new Movies("emma", "romance", 2020 );
		Movies movie63 = new Movies("after", "romance", 2022 );
		Movies movie64 = new Movies("her", "romance", 2013 );
		Movies movie65 = new Movies("persuasion", "romance", 2022 );
		Movies movie66 = new Movies("father of the bride", "romance", 2022 );
		
		Movies movie67 = new Movies("interstellar", "scifi", 2014 );
		Movies movie68 = new Movies("blade runner 2049", "scifi", 2017 );
		Movies movie69 = new Movies("arrival", "scifi", 2016 );
		Movies movie70 = new Movies("annihalation", "scifi", 2016 );
		Movies movie71 = new Movies("spiderhead", "scifi", 2022 );
		Movies movie72 = new Movies("life", "scifi", 2017 );
		Movies movie73 = new Movies("prey", "scifi", 2022 );
		Movies movie74 = new Movies("tenet", "scifi", 2020 );
		Movies movie75 = new Movies("the invisible man", "scifi", 2020 );
		Movies movie76 = new Movies("the blackout", "scifi", 2019 );
		Movies movie77 = new Movies("ex machina", "scifi", 2014 );
		
		Movies movie78 = new Movies("1917", "war", 2019 );
		Movies movie79 = new Movies("operation mincemeat", "war", 2021 );
		Movies movie80 = new Movies("midway", "war", 2019 );
		Movies movie81 = new Movies("the king", "war", 2019 );
		Movies movie82 = new Movies("dunkirk", "war", 2017 );
		Movies movie83 = new Movies("hacksaw ridge", "war", 2016 );
		Movies movie84 = new Movies("13 hours: the secret soldiers of benghazi", "war", 2016 );
		Movies movie85 = new Movies("fury", "war", 2014 );
		Movies movie86 = new Movies("war dogs", "war", 2016 );
		Movies movie87 = new Movies("12 strong", "war", 2018 );
		Movies movie88 = new Movies("a call to spy", "war", 2019 );
		
		//Add each movie instance 
		moviesArray.add(movie1);
		moviesArray.add(movie2);
		moviesArray.add(movie3);
		moviesArray.add(movie4);
		moviesArray.add(movie5);
		moviesArray.add(movie6);
		moviesArray.add(movie7);
		moviesArray.add(movie8);
		moviesArray.add(movie9);
		moviesArray.add(movie10);
		moviesArray.add(movie11);
		moviesArray.add(movie12);
		moviesArray.add(movie13);
		moviesArray.add(movie14);
		moviesArray.add(movie15);
		moviesArray.add(movie16);
		moviesArray.add(movie17);
		moviesArray.add(movie18);
		moviesArray.add(movie19);
		moviesArray.add(movie20);
		moviesArray.add(movie21);
		moviesArray.add(movie22);
		moviesArray.add(movie23);
		moviesArray.add(movie24);
		moviesArray.add(movie25);
		moviesArray.add(movie26);
		moviesArray.add(movie27);
		moviesArray.add(movie28);
		moviesArray.add(movie29);
		moviesArray.add(movie30);
		moviesArray.add(movie31);
		moviesArray.add(movie32);
		moviesArray.add(movie33);
		moviesArray.add(movie34);
		moviesArray.add(movie35);
		moviesArray.add(movie36);
		moviesArray.add(movie37);
		moviesArray.add(movie38);
		moviesArray.add(movie39);
		moviesArray.add(movie40);
		moviesArray.add(movie41);
		moviesArray.add(movie42);
		moviesArray.add(movie43);
		moviesArray.add(movie44);
		moviesArray.add(movie45);
		moviesArray.add(movie46);
		moviesArray.add(movie47);
		moviesArray.add(movie48);
		moviesArray.add(movie49);
		moviesArray.add(movie50);
		moviesArray.add(movie51);
		moviesArray.add(movie52);
		moviesArray.add(movie53);
		moviesArray.add(movie54);
		moviesArray.add(movie55);
		moviesArray.add(movie56);
		moviesArray.add(movie57);
		moviesArray.add(movie58);
		moviesArray.add(movie59);
		moviesArray.add(movie60);
		moviesArray.add(movie61);
		moviesArray.add(movie62);
		moviesArray.add(movie63);
		moviesArray.add(movie64);
		moviesArray.add(movie65);
		moviesArray.add(movie66);
		moviesArray.add(movie67);
		moviesArray.add(movie68);
		moviesArray.add(movie69);
		moviesArray.add(movie70);
		moviesArray.add(movie71);
		moviesArray.add(movie72);
		moviesArray.add(movie73);
		moviesArray.add(movie74);
		moviesArray.add(movie75);
		moviesArray.add(movie76);
		moviesArray.add(movie77);
		moviesArray.add(movie78);
		moviesArray.add(movie79);
		moviesArray.add(movie80);
		moviesArray.add(movie81);
		moviesArray.add(movie82);
		moviesArray.add(movie83);
		moviesArray.add(movie84);
		moviesArray.add(movie85);
		moviesArray.add(movie86);
		moviesArray.add(movie87);
		moviesArray.add(movie88);
		
		//While Loop and Switch Statement
		
boolean completed = false;
		
		Scanner input = new Scanner(System.in);
	
		while(!completed) {
			
			
			System.out.println("Welcome to the revup movie database site. What movie are you wanting"
							 + "to do today?");
			
			
			System.out.println("Press 1 to view all the movies in the database. Press 2 to search for a movie in the database. \n"
							 + "Press 3 to search for a movie in the database by movie title and genre. \n"
							 + "Press 4 to search for a movie in the database by title. Press 5 to add a movie into the database. \n"
							 + "Press 6 to remove a movie from the database.");
			
		
		
		int responses = input.nextInt();

		
		switch(responses) {
		
		case 1: 
				
			MovieDatabase mdb1 = new MovieDatabase(moviesArray);
			mdb1.viewAllMovies(moviesArray);
		
			break;
		
		case 2: 
			Movies movieObj2 = new Movies();
			System.out.println("Enter movie title.");
			String movieTitle = input.next() + input.nextLine().toLowerCase();
			movieObj2.setMovieTitle(movieTitle);
			try {
				System.out.println("Enter movie genre.");
				String movieGenre = input.next() + input.nextLine().toLowerCase();
				char[] genre = movieGenre.toCharArray();
				for (char g : genre) {
					if (Character.isDigit(g)) {
						throw new InputMismatchException();
					}
			}
				movieObj2.setMovieGenre(movieGenre);
				
			}catch(InputMismatchException e){
				e.printStackTrace();
				//jump back to beginning of while loop
				continue;
				
			}
			
			try {
				System.out.println("Enter the year the movie was released.");
				int releaseYear = input.nextInt();
				if (releaseYear < 2013) {
					throw new InvalidReleaseYearInputException();
				}
				movieObj2.setReleaseYear(releaseYear);
					
			}catch(InvalidReleaseYearInputException e){
				e.printStackTrace();
				continue;
			}
			
			MovieDatabase mdb2 = new MovieDatabase(moviesArray);
			mdb2.searchDatabase(movieObj2, moviesArray);
			
			break;
			
		case 3: 
			Movies movieObj3 = new Movies();
			System.out.println("Enter movie title.");
			movieTitle = input.next() + input.nextLine().toLowerCase();
			movieObj3.setMovieTitle(movieTitle);
			try {
				System.out.println("Enter movie genre.");
				String movieGenre = input.next() + input.nextLine().toLowerCase();
				
				char[] genre = movieGenre.toCharArray();
				for (char g : genre) {
					if (Character.isDigit(g)) {
						throw new InputMismatchException();
					}
				movieObj3.setMovieGenre(movieGenre);
				}
				}catch(InputMismatchException e){
					e.printStackTrace();
					continue;
					
				}
			
			MovieDatabase mdb3 = new MovieDatabase(moviesArray);
			mdb3.searchDatabaseByTitleGenre(movieObj3, moviesArray);
			
			break;
			
		case 4: 
			Movies movieObj4 = new Movies();
			System.out.println("Enter movie title.");
			movieTitle = input.next() + input.nextLine().toLowerCase();
			movieObj4.setMovieTitle(movieTitle);
			System.out.println(movieObj4);
			MovieDatabase mdb4 = new MovieDatabase(moviesArray);
			mdb4.searchDatabaseByTitle(movieObj4, moviesArray);
			
			break;
			
		case 5: 
			Movies movieObj5 = new Movies();
			System.out.println("Enter the movie title you want to add to the database.");
			movieTitle = input.next() + input.nextLine().toLowerCase();
			movieObj5.setMovieTitle(movieTitle);
			try {
				System.out.println("Enter the movie's genre.");
				String movieGenre = input.next() + input.nextLine().toLowerCase();
				
				char[] genre = movieGenre.toCharArray();
				for (char g : genre) {
					if (Character.isDigit(g)) {
						throw new InputMismatchException();
					}
				movieObj5.setMovieGenre(movieGenre);
				}
				}catch(InputMismatchException e){
					e.printStackTrace();
					continue;
					
				}
			
			try {
				System.out.println("Enter the year the movie was released.");
				int releaseYear = input.nextInt();
				if (releaseYear < 2013) {
					throw new InvalidReleaseYearInputException();
				}
				movieObj5.setReleaseYear(releaseYear);
					
			}catch(InvalidReleaseYearInputException e){
				e.printStackTrace();
				continue;
			}
			
			MovieDatabase mdb5 = new MovieDatabase(moviesArray);
			mdb5.addMovieToDatabase(movieObj5, moviesArray);
			
			break;
			
		case 6: 
			Movies movieObj6 = new Movies();
			System.out.println("Enter movie title you want to remove from database.");
			movieTitle = input.next() + input.nextLine().toLowerCase();
			movieObj6.setMovieTitle(movieTitle);
			try {
				System.out.println("Enter the movie's genre.");
				String movieGenre = input.next() + input.nextLine().toLowerCase();
				
				char[] genre = movieGenre.toCharArray();
				for (char g : genre) {
					if (Character.isDigit(g)) {
						throw new InputMismatchException();
					}
				movieObj6.setMovieGenre(movieGenre);
				}
				}catch(InputMismatchException e){
					e.printStackTrace();
					continue;
					
				}
			
			System.out.println("Enter the year the movie was released.");
			int releaseYear = input.nextInt();
			movieObj6.setReleaseYear(releaseYear);
			System.out.println(movieObj6);
			MovieDatabase mdb6 = new MovieDatabase(moviesArray);
			mdb6.removeMovieFromDatabase(movieObj6, moviesArray);
			
			break;
			
			
			
			
		default: 
			System.out.println("You do not have a valid response. Please type in a number.");
			 
		}
		
		
		System.out.println("Are you done? Y / N");
		//Input not working due to the first input.next() unless it combined.
		String finished = input.next() + input.nextLine();
		//Resets to menu
		if (finished.equals("Y")) {
		completed = true;
		input.close();
		
		}
		
		
		}	
	
		
	
	}

	
		
		

}
