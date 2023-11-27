package projectuas.bioskop.service;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;
import projectuas.bioskop.model.Movie;
import projectuas.bioskop.model.Studio;
import projectuas.bioskop.repository.MovieRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;

    public Movie createMovie(
            String imdbId,
            String title,
            String description,
            Integer durationHour,
            Integer durationMinute,
            String releaseDate,
            String trailerLink,
            String poster,
            ArrayList<String> genres,
            ArrayList<String> backdrops,
            ArrayList<Integer> price
    ) {
        Movie movie = movieRepository.insert(new Movie(
                imdbId,
                title,
                description,
                durationHour,
                durationMinute,
                releaseDate,
                trailerLink,
                poster,
                genres,
                backdrops,
                price,
                LocalDateTime.now(),
                LocalDateTime.now()
        ));

        return movie;
    }
    public ArrayList<Movie> allMovies() {
        ArrayList<Movie> movies = (ArrayList<Movie>) movieRepository.findAll();
        return movies;
    }

    public Optional<Movie> singleMovie(ObjectId id) {
        return movieRepository.findById(id);
    }

    public boolean deleteMovieById(ObjectId id) {
        Optional<Movie> movie = movieRepository.findById(id);
        if (movie.isPresent()) {
            movieRepository.deleteById(id);
            return true;
        }

        return false;
    }

    public boolean updateMovie(Movie updatedMovie) {
        Optional<Movie> existingMovie = movieRepository.findById(updatedMovie.getId());

        if (existingMovie.isPresent()) {
            Movie movie = existingMovie.get();
            movie.setTitle(updatedMovie.getTitle());
            movie.setDescription(updatedMovie.getDescription());
            movie.setDurationHour(updatedMovie.getDurationHour());
            movie.setDurationMinute(updatedMovie.getDurationMinute());
            movie.setReleaseDate(updatedMovie.getReleaseDate());
            movie.setTrailerLink(updatedMovie.getTrailerLink());
            movie.setPoster(updatedMovie.getPoster());
            movie.setGenres(updatedMovie.getGenres());
            movie.setBackdrops(updatedMovie.getGenres());
            movie.setPrice(updatedMovie.getPrice());

            movieRepository.save(movie);
            return true;
        } else {
            return false;
        }
    }
}
