package tn.iit.storeManagement.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.iit.storeManagement.models.Category;
@Repository
public interface CategoryDao  extends JpaRepository<Category,Long> {
}
