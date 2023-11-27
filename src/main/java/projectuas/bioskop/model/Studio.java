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

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Document(collection = "studios")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Studio {
    @Id
    private ObjectId id;
    private String name;
    private int capacity;
    private LocalDateTime created;
    private LocalDateTime updated;
    @DBRef
    private List<Showtime> showtimes= new ArrayList<>();

    public Studio(String name, int capacity, LocalDateTime created, LocalDateTime updated) {
        this.name = name;
        this.capacity = capacity;
        this.created = created;
        this.updated = updated;
    }
}
