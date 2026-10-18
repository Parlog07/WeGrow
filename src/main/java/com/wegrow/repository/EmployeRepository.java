
package com.wegrow.repository;

import com.wegrow.entity.Employe;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface EmployeRepository extends JpaRepository<Employe, Long> {

    boolean existsByMatricule(String matricule);

    List<Employe> findByDepartementId(Long departementId);

    long countByDepartementId(Long departementId);

    boolean existsByDepartementId(Long departementId);

}
