package ong.sitelgbt.volunteering.resource;

import lombok.RequiredArgsConstructor;
import ong.sitelgbt.volunteering.model.Availability;
import ong.sitelgbt.volunteering.service.AvailabilityService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/volunteers/{id}/availabilities")
public class AvailabilityResource {

    private final AvailabilityService service;

    @GetMapping
    public List<Availability> findAll(@PathVariable("id") Long voluntaryId) {
        return service.findAllByVoluntary(voluntaryId);
    }

    @GetMapping("{id}")
    public ResponseEntity<Availability> findById(@PathVariable("id") Long voluntaryId, @PathVariable("availabilityId") Long availabilityId) {
        final Optional<Availability> availability = service.findbyId(availabilityId);

        if (!availability.isPresent()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(availability.get());
    }

    @PostMapping
    public ResponseEntity<String> add(@RequestBody Availability availability) {
        final Availability entity = service.save(availability);
        return ResponseEntity.created(URI.create("/volunteers/" + availability.getVoluntary().getId() + "/availabilities/" + entity.getId())).build();
    }

    @DeleteMapping("{availabilityId}")
    public ResponseEntity delete(@PathVariable("id") Long voluntaryId, @PathVariable("availabilityId") Long availabilityId) {
        final Optional<Availability> availability = service.findbyId(availabilityId);

        if (!availability.isPresent()) {
            return ResponseEntity.noContent().build();
        }

        service.delete(availability.get());

        return ResponseEntity.ok().build();
    }

}
