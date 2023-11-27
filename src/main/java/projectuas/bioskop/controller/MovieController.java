package projectuas.bioskop.controller;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projectuas.bioskop.model.Studio;
import projectuas.bioskop.service.MovieService;
import projectuas.bioskop.model.Movie;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/movies")
public class MovieController {
    @Autowired
    private MovieService movieService;

    @PostMapping
    public ResponseEntity<Movie> createMovie(@RequestBody Map<String, Object> payload) {
        Integer durationHour = (Integer) payload.get("durationHour");
        Integer durationMinute = (Integer) payload.get("durationMinute");

        ArrayList<String> genres = (ArrayList<String>) payload.get("genres");
        ArrayList<String> backdrops = (ArrayList<String>) payload.get("backdrops");

        ArrayList<Integer> prices = (ArrayList<Integer>) payload.get("prices");

        return new ResponseEntity<>(movieService.createMovie(
                (String) payload.get("imdbId"),
                (String) payload.get("title"),
                (String) payload.get("description"),
                durationHour,
                durationMinute,
                (String) payload.get("releaseDate"),
                (String) payload.get("trailerLink"),
                (String) payload.get("poster"),
                genres,
                backdrops,
                prices
        ), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<ArrayList<Movie>> getMovies() {
        return new ResponseEntity<ArrayList<Movie>>(movieService.allMovies(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Movie>> getMovie(@PathVariable ObjectId id) {
        return new ResponseEntity<Optional<Movie>>(movieService.singleMovie(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMovie(@PathVariable ObjectId id) {
        if (movieService.deleteMovieById(id)) {
            return new ResponseEntity<>("Data telah dihapus", HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>("Data tidak ditemukan", HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Movie> updateMovie(@PathVariable ObjectId id, @RequestBody Movie updatedMovie) {
        updatedMovie.setId(id);

        boolean updated = movieService.updateMovie(updatedMovie);

        if (updated) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
