package lk.ijse.spring.repo;


import lk.ijse.spring.entity.TechLead;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TechLeadRepo extends JpaRepository<TechLead, String > {
}
