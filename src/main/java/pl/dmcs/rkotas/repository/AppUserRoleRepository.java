package pl.dmcs.rkotas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.dmcs.rkotas.domain.AppUserRole;
import jakarta.transaction.Transactional;

@Transactional
@Repository
public interface AppUserRoleRepository extends JpaRepository<AppUserRole, Long> {
    AppUserRole findByRole(String role);
}

