package ong.sitelgbt.volunteering.repository;

import ong.sitelgbt.volunteering.model.Voluntary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoluntaryRepository extends JpaRepository<Voluntary, Long> {
}
