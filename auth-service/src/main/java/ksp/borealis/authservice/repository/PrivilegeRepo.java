package ksp.borealis.authservice.repository;

import java.util.List;
import java.util.Optional;

import ksp.borealis.authservice.entity.Privilege;
import org.springframework.data.jpa.repository.JpaRepository;



public interface PrivilegeRepo extends JpaRepository<Privilege, Long> {
	Optional<Privilege> findById(Long id);

	Privilege findByNameIgnoreCase(String name);

	List<Privilege> findAllByName(String name);

	void deleteById(Long id);
	
}
