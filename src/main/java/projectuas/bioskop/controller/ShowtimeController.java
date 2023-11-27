package projectuas.bioskop.controller;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projectuas.bioskop.model.Movie;
import projectuas.bioskop.model.Showtime;
import projectuas.bioskop.service.ShowtimeService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/showtimes")
public class ShowtimeController {
    @Autowired
    private ShowtimeService showtimeService;

    @PostMapping
    public ResponseEntity<Showtime> createShowtime(@RequestBody Map<String, String> payload) {
        LocalDateTime dateTime = LocalDateTime.parse(payload.get("dateTime"));
        ObjectId movieId = new ObjectId(payload.get("movieId"));
        ObjectId studioId = new ObjectId(payload.get("studioId"));

        return new ResponseEntity<Showtime>(showtimeService.createShowtime(
                dateTime,
                movieId,
                studioId
        ), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<ArrayList<Showtime>> getShowtimes() {
        return new ResponseEntity<ArrayList<Showtime>>(showtimeService.allShowtime(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Showtime>> getShowtime(@PathVariable ObjectId id) {
        return new ResponseEntity<Optional<Showtime>>(showtimeService.singleShowtime(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteShowtime(@PathVariable ObjectId id) {
        if (showtimeService.deleteShowtimeById(id)) {
            return new ResponseEntity<>("Data telah dihapus", HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>("Data tidak ditemukan", HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Showtime> updateShowtime(@PathVariable ObjectId id, @RequestBody Showtime updatedShowtime) {
        updatedShowtime.setId(id);

        boolean updated = showtimeService.updateShowtime(updatedShowtime);

        if (updated) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
