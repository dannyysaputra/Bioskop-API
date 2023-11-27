package projectuas.bioskop.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;
import projectuas.bioskop.model.Showtime;

import java.util.UUID;

@RestController
@Repository
public interface ShowtimeRepository extends MongoRepository<Showtime, ObjectId> {
}
