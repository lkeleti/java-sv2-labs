package domain.repository;

import domain.entity.Child;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ChildRepository extends JpaRepository<Child, Long>{

    @Query("SELECT c FROM Child c WHERE c.city = :city")
    List<Child> findByCity(@Param("city") String city);
}
