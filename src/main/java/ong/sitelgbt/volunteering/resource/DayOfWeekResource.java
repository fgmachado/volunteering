package ong.sitelgbt.volunteering.resource;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import ong.sitelgbt.volunteering.model.DayOfWeek;
import ong.sitelgbt.volunteering.service.DayOfWeekService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("days-of-week")
public class DayOfWeekResource {

    private final DayOfWeekService service;

    @Operation(description = "List all days of week")
    @ApiResponse(responseCode = "200", description = "List all days of week")
    @GetMapping
    public List<DayOfWeek> findAll() {
        return service.findAll();
    }

    @Operation(description = "Get a day of week")
    @ApiResponse(responseCode = "200", description = "Day of week")
    @ApiResponse(responseCode = "204", description = "Day of week not found")
    @GetMapping("{id}")
    public ResponseEntity<DayOfWeek> findById(@PathVariable("id") Long id) {
        final Optional<DayOfWeek> dayOfWeek = service.findById(id);

        if (!dayOfWeek.isPresent()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(dayOfWeek.get());
    }

    @Operation(description = "Add a day of week")
    @ApiResponse(responseCode = "201", description = "Added")
    @PostMapping
    public ResponseEntity<String> add(@RequestBody DayOfWeek dayOfWeek) {
        final DayOfWeek entity = service.save(dayOfWeek);
        return ResponseEntity.created(URI.create("/days-of-week/" + entity.getId())).build();
    }

    @Operation(description = "Delete a day of week")
    @ApiResponse(responseCode = "200", description = "Deleted")
    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable("id") Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }

}
