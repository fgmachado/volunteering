package ong.sitelgbt.volunteering.service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import ong.sitelgbt.volunteering.model.Availability;
import ong.sitelgbt.volunteering.repository.AvailabilityRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AvailabilityService {

    private final AvailabilityRepository repository;

    public List<Availability> findAllByVoluntary(@NonNull Long voluntaryId) {
        return repository.findAllByVoluntaryId(voluntaryId);
    }

    public Optional<Availability> findbyId(@NonNull Long id) {
        return repository.findById(id);
    }

    public Availability save(@NonNull Availability availability) {
        return repository.save(availability);
    }

    public void delete(@NonNull Availability availability) {
        repository.delete(availability);
    }

}
