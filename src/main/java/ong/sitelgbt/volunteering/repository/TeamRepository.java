package ong.sitelgbt.volunteering.repository;

import ong.sitelgbt.volunteering.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {
}
