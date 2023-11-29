package projectuas.bioskop.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "roles")
@Data
@AllArgsConstructor
public class Role {
    @Id
    private ObjectId id;
    private ERole name;

    public Role(ERole name) {
        this.name = name;
    }

    public Role() {

    }
}
