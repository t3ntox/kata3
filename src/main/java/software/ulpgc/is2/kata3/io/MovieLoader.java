package software.ulpgc.is2.kata3.io;

import software.ulpgc.is2.kata3.model.Movie;

import java.util.List;

public interface MovieLoader {
    List<Movie> loadAll();
}
