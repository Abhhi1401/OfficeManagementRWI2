package in.railworld.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.railworld.app.model.Person;

public interface PersonRepository extends JpaRepository<Person, Integer>{

}
