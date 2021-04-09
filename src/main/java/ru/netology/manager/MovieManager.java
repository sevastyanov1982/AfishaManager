package ru.netology.manager;

import ru.netology.domain.Movie;


public class MovieManager {
    private Movie[] movies = new Movie[0];
    private int numMovies = 10; /// количество фильмов

    public MovieManager() {

    }

    public MovieManager(int numMovies) {
        this.numMovies = numMovies;
    }


    public void add(Movie movie) {
        int length = movies.length + 1;
        Movie[] tmp = new Movie[length];
        for (int i = 0; i < movies.length; i++) {
            tmp[i] = movies[i];
        }
        tmp[tmp.length - 1] = movie;
        movies = tmp;

    }

    public Movie[] getAll() {
        Movie[] result = new Movie[movies.length];
        for (int i = 0; i < result.length; i++) {
            int index = movies.length - i - 1;
            result[i] = movies[index];
        }
        return result;

    }
    public Movie[] getLastMovie() {
        int length = numMovies;
        if (length > movies.length) {
            length = movies.length;
        }

        Movie[] result = new Movie[length];

        for (int i = 0; i < length; i++) {
            int index = movies.length - i - 1;
            result[i] = movies[index];
        }
        return result;
    }

}