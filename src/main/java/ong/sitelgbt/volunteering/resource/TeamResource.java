package ong.sitelgbt.volunteering.resource;

import lombok.RequiredArgsConstructor;
import ong.sitelgbt.volunteering.model.Team;
import ong.sitelgbt.volunteering.service.TeamService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/teams")
public class TeamResource {

    private final TeamService service;

    @GetMapping
    public List<Team> findAll() {
        return service.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<Team> findById(@PathVariable("id") Long id) {
        final Optional<Team> team = service.findById(id);

        if (!team.isPresent()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(team.get());
    }

    @PostMapping
    public ResponseEntity<String> add(@RequestBody Team team) {
        final Team entity = service.save(team);
        return ResponseEntity.created(URI.create("/teams/" + entity.getId())).build();
    }

    @PutMapping
    public Team update(@RequestBody Team team) {
        return service.save(team);
    }

    @PatchMapping("{id}/disable")
    public ResponseEntity<Team> deactivate(@PathVariable("id") Long id) {
        final Optional<Team> team = service.findById(id);

        if (!team.isPresent()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }

        return ResponseEntity.ok(service.deactivate(team.get()));
    }

    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable("id") Long id) {
        final Optional<Team> team = service.findById(id);

        if (!team.isPresent()) {
            return ResponseEntity.noContent().build();
        }

        service.delete(team.get());

        return ResponseEntity.ok().build();
    }

}
