package ong.sitelgbt.volunteering.resource;

import lombok.RequiredArgsConstructor;
import ong.sitelgbt.volunteering.model.Voluntary;
import ong.sitelgbt.volunteering.service.VoluntaryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/volunteers")
public class VoluntaryResource {

    private final VoluntaryService service;

    @GetMapping
    public List<Voluntary> findAll() {
        return service.findAll();
    }

    @GetMapping("{id}")
    public Optional<Voluntary> findById(@PathVariable("id") Long id) {
        return service.findById(id);
    }

    @PostMapping
    public Voluntary add(@RequestBody Voluntary voluntary) {
        return service.save(voluntary);
    }

    @PutMapping
    public Voluntary update(@RequestBody Voluntary voluntary) {
        return service.save(voluntary);
    }

    @PatchMapping("{id}/disable")
    public ResponseEntity<Voluntary> deactivate(@PathVariable("id") Long id) {
        final Optional<Voluntary> register = service.findById(id);

        if (!register.isPresent()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }

        return ResponseEntity.ok(service.deactivate(register.get()));
    }

    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable("id") Long id) {
        final Optional<Voluntary> register = service.findById(id);

        if (!register.isPresent()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }

        service.delete(register.get());

        return ResponseEntity.ok().build();
    }

}
