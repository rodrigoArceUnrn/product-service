package ar.edu.unrn.productservice.security.repository;


import ar.edu.unrn.productservice.security.entity.Role;
import ar.edu.unrn.productservice.security.enums.RolName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RolRepository extends JpaRepository<Role,Integer> {

    Optional<Role> findByName(RolName rolName);
}
