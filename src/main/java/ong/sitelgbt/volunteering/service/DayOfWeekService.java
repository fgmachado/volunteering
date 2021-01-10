package ong.sitelgbt.volunteering.service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import ong.sitelgbt.volunteering.model.DayOfWeek;
import ong.sitelgbt.volunteering.repository.DayOfWeekRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DayOfWeekService {

    private final DayOfWeekRepository repository;

    public List<DayOfWeek> findAll() {
        return repository.findAll();
    }

    public DayOfWeek save(@NonNull DayOfWeek dayOfWeek) {
        return repository.save(dayOfWeek);
    }

    public void delete(@NonNull Long id) {
        repository.deleteById(id);
    }

}
