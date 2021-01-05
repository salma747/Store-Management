package tn.iit.storeManagement.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.iit.storeManagement.models.Medication;
@Repository
public interface MedicationDao extends JpaRepository<Medication,Long> {
}
