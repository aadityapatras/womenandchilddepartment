package womenandchilddepartment.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import womenandchilddepartment.model.Admin;
import womenandchilddepartment.model.User;

import java.util.Optional;

public interface AdminRepo extends JpaRepository<Admin, Integer> {

    boolean existsByEmail(String email);
    Optional<Admin> findByEmail(String email);
}
