package projectuas.bioskop.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.cglib.core.Local;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Document(collection = "movies")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Movie {
    @Id
    private ObjectId id;
    private String imdbId;
    private String title;
    private String description;
    private Integer durationHour;
    private Integer durationMinute;
    private String releaseDate;
    private String trailerLink;
    private String poster;
    private ArrayList<String> genres;
    private ArrayList<String> backdrops;
    private ArrayList<Integer> price;
    private LocalDateTime created;
    private LocalDateTime updated;
    @DBRef
    private List<Showtime> showtimes = new ArrayList<>();

    public Movie(
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
            ArrayList<Integer> price,
            LocalDateTime created,
            LocalDateTime updated
    ) {
        this.imdbId = imdbId;
        this.title = title;
        this.description = description;
        this.durationHour = durationHour;
        this.durationMinute = durationMinute;
        this.releaseDate = releaseDate;
        this.trailerLink = trailerLink;
        this.poster = poster;
        this.genres = genres;
        this.backdrops = backdrops;
        this.price = price;
        this.created = created;
        this.updated = updated;
    }
}
