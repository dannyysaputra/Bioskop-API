package projectuas.bioskop.service;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import projectuas.bioskop.model.Movie;
import projectuas.bioskop.model.Showtime;
import projectuas.bioskop.model.Studio;
import projectuas.bioskop.repository.MovieRepository;
import projectuas.bioskop.repository.ShowtimeRepository;
import projectuas.bioskop.repository.StudioRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class ShowtimeService {
    @Autowired
    private ShowtimeRepository showtimeRepository;

    @Autowired
    private StudioRepository studioRepository;

    @Autowired
    private MovieRepository movieRepository;

    public Showtime createShowtime(LocalDateTime dateTime, ObjectId movieId, ObjectId studioId) {
        Showtime showtime = new Showtime(dateTime, movieId, studioId);
        showtimeRepository.insert(showtime);

        Movie movie = movieRepository.findById(movieId).orElse(null);
        if (movie != null) {
            movie.getShowtimes().add(showtime);
            movieRepository.save(movie);
        }

        Studio studio = studioRepository.findById(studioId).orElse(null);
        if (studio != null) {
            studio.getShowtimes().add(showtime);
            studioRepository.save(studio);
        }

        return showtime;
    }

    public ArrayList<Showtime> allShowtime() {
        ArrayList<Showtime> showtimes = (ArrayList<Showtime>) showtimeRepository.findAll();
        return  showtimes;
    }

    public Optional<Showtime> singleShowtime(ObjectId id) {
        return showtimeRepository.findById(id);
    }
}
