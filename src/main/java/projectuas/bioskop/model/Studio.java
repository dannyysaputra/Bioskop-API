package projectuas.bioskop.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

@Document(collection = "studios")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Studio {
    @Id
    private ObjectId id;
    private String name;
    private int capacity;
    private ArrayList<Movie> movies;
    private ArrayList<Showtime> showtimes;
}
