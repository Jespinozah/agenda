package agenda.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import agenda.model.Client;
public interface ClientRepository extends JpaRepository<Client, Integer>{

}
