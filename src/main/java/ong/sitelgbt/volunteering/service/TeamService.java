package ong.sitelgbt.volunteering.service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import ong.sitelgbt.volunteering.model.Team;
import ong.sitelgbt.volunteering.repository.TeamRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TeamService {

    private final TeamRepository repository;

    public List<Team> findAll() {
        return repository.findAll();
    }

    public Optional<Team> findById(@NonNull final Long id) {
        return repository.findById(id);
    }

    public Team save(@NonNull Team team) {
        return repository.save(team);
    }

    public Team deactivate(@NonNull Team team) {
        team.deactivate();
        return save(team);
    }

    public void delete(@NonNull Team team) {
        repository.delete(team);
    }

}
