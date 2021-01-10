package ong.sitelgbt.volunteering.resource;

import lombok.RequiredArgsConstructor;
import ong.sitelgbt.volunteering.model.Register;
import ong.sitelgbt.volunteering.service.RegisterService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/registrations")
public class RegisterResource {

    private final RegisterService service;

    @GetMapping
    public List<Register> findAll() {
        return service.findAll();
    }

    @GetMapping("{id}")
    public Optional<Register> findById(@PathVariable("id") Long id) {
        return service.findById(id);
    }

    @PostMapping
    public Register add(@RequestBody Register register) {
        return service.save(register);
    }

    @PutMapping
    public Register update(@RequestBody Register register) {
        return service.save(register);
    }

    @PatchMapping("{id}/disable")
    public ResponseEntity<Register> deactivate(@PathVariable("id") Long id) {
        final Optional<Register> register = service.findById(id);

        if (register.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }

        return ResponseEntity.ok(service.deactivate(register.get()));
    }

    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable("id") Long id) {
        final Optional<Register> register = service.findById(id);

        if (register.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }

        service.delete(register.get());

        return ResponseEntity.ok().build();
    }

}
