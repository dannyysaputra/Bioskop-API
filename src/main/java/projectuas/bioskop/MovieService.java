package projectuas.bioskop;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projectuas.bioskop.model.Movie;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;
    public ArrayList<Movie> allMovies() {
        ArrayList<Movie> movies = (ArrayList<Movie>) movieRepository.findAll();
        return movies;
    }

    public Optional<Movie> singleMovie(ObjectId id) {
        return movieRepository.findById(id);
    }
}
