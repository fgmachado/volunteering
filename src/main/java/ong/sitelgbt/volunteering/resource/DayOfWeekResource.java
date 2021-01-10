package ong.sitelgbt.volunteering.resource;

import lombok.RequiredArgsConstructor;
import ong.sitelgbt.volunteering.model.DayOfWeek;
import ong.sitelgbt.volunteering.service.DayOfWeekService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("days-of-week")
public class DayOfWeekResource {

    private final DayOfWeekService service;

    @GetMapping
    public List<DayOfWeek> findAll() {
        return service.findAll();
    }

    @PostMapping
    public DayOfWeek add(@RequestBody DayOfWeek dayOfWeek) {
        return service.save(dayOfWeek);
    }

    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable("id") Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }

}
