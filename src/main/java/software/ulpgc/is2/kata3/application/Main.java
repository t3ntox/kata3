package software.ulpgc.is2.kata3.application;

import software.ulpgc.is2.kata3.model.Movie;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Movie> movieList = new RemoteMovieLoader().loadAll();
        for (Movie movie: movieList) {
            System.out.println(movie);
        }
        /*  EJERCICIOS STREAM PARTICIPACION EN CLASE
        List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 7, 8, 91, 11, 20, 21, 25, 84, 19);

        List<Integer> e1 (List<Integer> list) {
            return list.stream().filter(x -> x > 20).toList();
        }

        Integer e2 (List<Integer> list) {
            return list.stream().filter(x -> x % 2 == 0).toList().size();
        }

        Integer e3 (List<Integer> list) {
            return list.stream().mapToInt(x -> x).sum();
        }

        List<Integer> e4 (List<Integer> list) {
            return list.stream().filter(x -> x % 2 != 0).mapToInt(x -> x*x).boxed().toList();
        }

        List<Employee> e5 (List<Employee> list) {
            return list.stream().filter(x -> x.salary() > 50000).toList();
        }

        List<String> e6 (List<Car> list) {
            return list.stream().filter(v -> v.color() == Color.red).map(Car::brand).toList();
        }

        */

    }
}
