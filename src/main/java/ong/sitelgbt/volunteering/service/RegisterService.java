package ong.sitelgbt.volunteering.service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import ong.sitelgbt.volunteering.model.Register;
import ong.sitelgbt.volunteering.repository.RegisterRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RegisterService {

    private final RegisterRepository repository;

    public List<Register> findAll() {
        return repository.findAll();
    }

    public Optional<Register> findById(@NonNull final Long id) {
        return repository.findById(id);
    }

    public Register save(@NonNull Register register) {
        return repository.save(register);
    }

    public Register deactivate(@NonNull Register register) {
        register.deactivate();
        return save(register);
    }

    public void delete(@NonNull Register register) {
        repository.delete(register);
    }

}
