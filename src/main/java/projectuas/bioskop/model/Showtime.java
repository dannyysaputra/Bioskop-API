package projectuas.bioskop.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.time.LocalDateTime;
import java.util.UUID;

@Document(collection = "showtime")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Showtime {
    @Id
    private ObjectId id;
    private LocalDateTime dateTime;
    private ObjectId movieId;
    private ObjectId studioId;

    public Showtime(LocalDateTime dateTime, ObjectId movieId, ObjectId studioId) {
        this.dateTime = dateTime;
        this.movieId = movieId;
        this.studioId = studioId;
    }
}
