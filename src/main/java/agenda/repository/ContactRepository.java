package agenda.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import agenda.model.Contact;

public interface ContactRepository extends JpaRepository<Contact, Integer> {

}
