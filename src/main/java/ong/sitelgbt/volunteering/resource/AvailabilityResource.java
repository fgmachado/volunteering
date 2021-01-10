package ong.sitelgbt.volunteering.resource;

import lombok.RequiredArgsConstructor;
import ong.sitelgbt.volunteering.model.Availability;
import ong.sitelgbt.volunteering.service.AvailabilityService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public Availability add(@RequestBody Availability availability) {
        return service.save(availability);
    }

    @DeleteMapping("{availabilityId}")
    public ResponseEntity delete(@PathVariable("id") Long voluntaryId, @PathVariable("availabilityId") Long availabilityId) {
        final Optional<Availability> availability = service.findbyId(availabilityId);

        if (!availability.isPresent()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }

        service.delete(availability.get());

        return ResponseEntity.ok().build();
    }

}
