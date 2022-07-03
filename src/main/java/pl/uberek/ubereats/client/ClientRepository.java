package pl.uberek.ubereats.client;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    List<Client> findByIsPremiumTrue();

    Optional<Client> findFirstNameAndLastNameAndAddressById(Long id);

}
