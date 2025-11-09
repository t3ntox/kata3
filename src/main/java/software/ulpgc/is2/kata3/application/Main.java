package software.ulpgc.is2.kata3.application;

import software.ulpgc.is2.kata3.model.Movie;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Movie> movieList = new RemoteMovieLoader().loadAll();
        for (Movie movie: movieList) {
            System.out.println(movie);
        }
    }
}
