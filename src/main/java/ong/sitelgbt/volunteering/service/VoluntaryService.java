package ong.sitelgbt.volunteering.service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import ong.sitelgbt.volunteering.model.Voluntary;
import ong.sitelgbt.volunteering.repository.VoluntaryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VoluntaryService {

    private final VoluntaryRepository repository;

    public List<Voluntary> findAll() {
        return repository.findAll();
    }

    public Optional<Voluntary> findById(@NonNull final Long id) {
        return repository.findById(id);
    }

    public Voluntary save(@NonNull Voluntary voluntary) {
        return repository.save(voluntary);
    }

    public Voluntary deactivate(@NonNull Voluntary voluntary) {
        voluntary.deactivate();
        return save(voluntary);
    }

    public void delete(@NonNull Voluntary voluntary) {
        repository.delete(voluntary);
    }

}
