package projectuas.bioskop.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

@Document(collection = "movies")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Movie {
    @Id
    private ObjectId id;
    private String imdb_id;
    private String title;
    private String description;
    private Integer duration_hour;
    private Integer duration_minute;
    private String release_date;
    private String trailer_link;
    private String poster;
    private ArrayList<String> genres;
    private ArrayList<String> backdrops;
    private ArrayList<Integer> price;
}
