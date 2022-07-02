package pl.uberek.ubereats.client;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.uberek.ubereats.client.dtos.ClientAddressDto;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    List<Client> findByIsPremiumTrue();

    //Client with ip {ip} and his address
    @Query(value = "SELECT new pl.uberek.ubereats.client.dtos.ClientAddressDto(c.first_name, c.last_name, a.city, a.street)" +
            " FROM Clients AS c " +
            " INNER JOIN Address AS a ON c.address_id = a.id " +
            " WHERE c.id = :id ",
            nativeQuery = true)
    Optional<ClientAddressDto> getClientAndHisAddress(@Param("id") Long id);

}
