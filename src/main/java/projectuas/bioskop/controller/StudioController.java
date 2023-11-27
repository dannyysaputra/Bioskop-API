package projectuas.bioskop.controller;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projectuas.bioskop.model.Studio;
import projectuas.bioskop.service.StudioService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/studios")
public class StudioController {
    @Autowired
    private StudioService studioService;

    @PostMapping
    public ResponseEntity<Studio> createStudio(@RequestBody Map<String, Object> payload) {
        Integer capacity = (Integer) payload.get("capacity");

        return new ResponseEntity<Studio>(studioService.createStudio(
                (String) payload.get("name"),
                capacity
        ), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<ArrayList<Studio>> getStudios() {
        return new ResponseEntity<ArrayList<Studio>>(studioService.allStudios(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Studio>> getStudio(@PathVariable ObjectId id) {
        return new ResponseEntity<Optional<Studio>>(studioService.singleStudio(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudio(@PathVariable ObjectId id) {
        if (studioService.deleteStudioById(id)) {
            return new ResponseEntity<>("Data telah dihapus", HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>("Data tidak ditemukan", HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Studio> updateStudio(@PathVariable ObjectId id, @RequestBody Studio updatedStudio) {
        updatedStudio.setId(id);

        boolean updated = studioService.updateStudio(updatedStudio);

        if (updated) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
