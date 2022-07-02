package pl.uberek.ubereats.client;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    List<Client> findByIsPremiumTrue();

    //list Client with ip {ip} and his address

}
