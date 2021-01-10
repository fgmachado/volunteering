package ong.sitelgbt.volunteering.repository;

import ong.sitelgbt.volunteering.model.Availability;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AvailabilityRepository extends JpaRepository<Availability, Long> {

    List<Availability> findAllByVoluntaryId(Long voluntaryId);

}
