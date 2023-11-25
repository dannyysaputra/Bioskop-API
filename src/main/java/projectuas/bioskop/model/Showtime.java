package projectuas.bioskop.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.time.LocalDateTime;

@Document(collection = "showtime")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Showtime {
    @Id
    private ObjectId id;
    private LocalDateTime date_time;
    @DocumentReference
    private String movie_id;
    @DocumentReference
    private String studio_id;
}
