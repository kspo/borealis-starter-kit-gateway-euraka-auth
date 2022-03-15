package ksp.borealis.authservice.repository;

import java.util.Optional;

import ksp.borealis.authservice.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RoleRepo extends JpaRepository<Role, Long> {

	Optional<Role> findById(Long id);

	Role findByNameIgnoreCase(String name);

}
