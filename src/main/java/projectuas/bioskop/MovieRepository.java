package projectuas.bioskop;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;
import projectuas.bioskop.model.Movie;

@RestController
@Repository
public interface MovieRepository extends MongoRepository<Movie, ObjectId> {

}
