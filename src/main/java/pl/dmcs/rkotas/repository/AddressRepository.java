package pl.dmcs.rkotas.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.dmcs.rkotas.domain.Address;

@Transactional
@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
    Address findById(long id);
}
