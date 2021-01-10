package ong.sitelgbt.volunteering.resource;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import ong.sitelgbt.volunteering.model.Voluntary;
import ong.sitelgbt.volunteering.service.VoluntaryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/volunteers")
public class VoluntaryResource {

    private final VoluntaryService service;

    @Operation(description = "List all registered volunteers")
    @ApiResponse(responseCode = "200", description = "Returns a list of volunteers")
    @GetMapping
    public List<Voluntary> findAll() {
        return service.findAll();
    }

    @Operation(description = "Get a voluntaty by id")
    @ApiResponse(responseCode = "200", description = "A voluntary")
    @ApiResponse(responseCode = "204", description = "If not found a voluntary")
    @GetMapping("{id}")
    public ResponseEntity<Voluntary> findById(@PathVariable("id") Long id) {
        final Optional<Voluntary> voluntary = service.findById(id);

        if (!voluntary.isPresent()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(voluntary.get());
    }

    @Operation(description = "Add a voluntaty")
    @ApiResponse(responseCode = "201", description = "Returns if a voluntary is created")
    @PostMapping
    public ResponseEntity<String> add(@RequestBody Voluntary voluntary) {
        final Voluntary entity = service.save(voluntary);
        return ResponseEntity.created(URI.create("/volunteers/" + entity.getId())).build();
    }

    @Operation(description = "Update a voluntary")
    @ApiResponse(responseCode = "200", description = "Returns if a voluntary is updated")
    @PutMapping
    public ResponseEntity<Voluntary> update(@RequestBody Voluntary voluntary) {
        return ResponseEntity.ok(service.save(voluntary));
    }

    @Operation(description = "Deactivate a voluntary")
    @ApiResponse(responseCode = "200", description = "If a voluntary is deactivated")
    @ApiResponse(responseCode = "204", description = "If a voluntary is not found")
    @PatchMapping("{id}/disable")
    public ResponseEntity<Voluntary> deactivate(@PathVariable("id") Long id) {
        final Optional<Voluntary> register = service.findById(id);

        if (!register.isPresent()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(service.deactivate(register.get()));
    }

    @Operation(description = "Delete a voluntary")
    @ApiResponse(responseCode = "200", description = "If a voluntary is deleted")
    @ApiResponse(responseCode = "204", description = "If a voluntary is not found")
    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable("id") Long id) {
        final Optional<Voluntary> register = service.findById(id);

        if (!register.isPresent()) {
            return ResponseEntity.noContent().build();
        }

        service.delete(register.get());

        return ResponseEntity.ok().build();
    }

}
