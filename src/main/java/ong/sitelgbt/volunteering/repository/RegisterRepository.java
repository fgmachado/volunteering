package ong.sitelgbt.volunteering.repository;

import ong.sitelgbt.volunteering.model.Register;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegisterRepository extends JpaRepository<Register, Long> {
}
