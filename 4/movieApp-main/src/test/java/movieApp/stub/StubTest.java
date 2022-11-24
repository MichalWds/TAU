package movieApp.stub;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StubTest {

    interface Service {
        List<String> getMovies();
    }

     static class Movie {

        Service service;

        public Movie(Service service) {
            this.service = service;
        }

        public List<String> getMoviesWhichStartsWith_S_letter() {
            List<String> movies = new ArrayList<>();
            for (String movieTitle : service.getMovies()) {
                if (movieTitle.startsWith("S"))
                    movies.add(movieTitle);
            }
            return movies;
        }
    }

}

class StubJavaTest {

    @Test
    public void whenCallServiceIsStubbed() {
        StubTest.Movie service = new StubTest.Movie(new StubService());

        assertEquals(1, service.getMoviesWhichStartsWith_S_letter().size());
        assertEquals("Saw", service.getMoviesWhichStartsWith_S_letter().get(0));
    }

    static class StubService implements StubTest.Service {
        public List<String> getMovies() {
            return Arrays.asList("Toy Story", "Killer", "God Father", "Mechanic", "Saw");
        }
    }
}