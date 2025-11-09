package software.ulpgc.is2.kata3.application;

import software.ulpgc.is2.kata3.io.MovieLoader;
import software.ulpgc.is2.kata3.model.Movie;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.GZIPInputStream;

public class RemoteMovieLoader implements MovieLoader {
    private static final String url = "https://datasets.imdbws.com/title.basics.tsv.gz";

    @Override
    public List<Movie> loadAll() {
        try {
            return loadFrom(new URL(url));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private List<Movie> loadFrom(URL url) throws IOException {
        return loadFrom(url.openConnection());
    }

    private List<Movie> loadFrom(URLConnection urlConnection) throws IOException {
        try (InputStream inputStream = unzip(urlConnection.getInputStream())) {
            return loadFrom(inputStream);
        }
    }

    private List<Movie> loadFrom(InputStream inputStream) throws IOException {
        return loadFrom(toReader(inputStream));
    }

    private List<Movie> loadFrom(BufferedReader reader) throws IOException {
        List<Movie> list = new ArrayList<>();
        reader.readLine();
        while (true) {
            String line = reader.readLine();
            if (line == null) break;
            list.add(toMovie(line));
        }
        return list;
    }

    private Movie toMovie(String line) {
        return toMovie(line.split("\\t"));
    }

    private Movie toMovie(String[] split) {
        return new Movie(split[1], toInt(split[7]));
    }

    private int toInt(String s) {
        if (s.equals("\\N")) return -1;
        return Integer.parseInt(s);
    }

    private BufferedReader toReader(InputStream inputStream) {
        return new BufferedReader(new InputStreamReader(inputStream));
    }

    private InputStream unzip(InputStream inputStream) throws IOException {
        return new GZIPInputStream(new BufferedInputStream(inputStream));
    }
}
