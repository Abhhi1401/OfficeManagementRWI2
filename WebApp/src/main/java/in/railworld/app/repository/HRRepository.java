package in.railworld.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.railworld.app.model.HR;



public interface HRRepository extends JpaRepository<HR, Long> {

}
