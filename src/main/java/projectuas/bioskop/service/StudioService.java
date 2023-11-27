package projectuas.bioskop.service;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import projectuas.bioskop.model.Showtime;
import projectuas.bioskop.model.Studio;
import projectuas.bioskop.repository.StudioRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class StudioService {
    @Autowired
    private StudioRepository studioRepository;

    @Autowired
    private MongoTemplate mongoTemplate;


    public Studio createStudio(String name, int capacity) {
        Studio studio = studioRepository.insert(new Studio(name, capacity, LocalDateTime.now(), LocalDateTime.now()));
        return studio;
    }

    public ArrayList<Studio> allStudios() {
        ArrayList<Studio> studios = (ArrayList<Studio>) studioRepository.findAll();
        return studios;
    }

    public Optional<Studio> singleStudio(ObjectId id) {
        return studioRepository.findById(id);
    }

    public boolean deleteStudioById(ObjectId id) {
        Optional<Studio> studio = studioRepository.findById(id);
        if (studio.isPresent()) {
            studioRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    public boolean updateStudio(Studio updatedStudio) {
        Optional<Studio> existingStudio = studioRepository.findById(updatedStudio.getId());

        if (existingStudio.isPresent()) {
            Studio studio = existingStudio.get();
            studio.setName(updatedStudio.getName());
            studio.setCapacity(updatedStudio.getCapacity());

            studioRepository.save(studio);
            return true;
        } else {
            return false;
        }
    }
}
