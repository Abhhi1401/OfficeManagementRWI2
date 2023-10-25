package in.railworld.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import in.railworld.app.model.Applicant;

public interface ApplicantRepository extends JpaRepository<Applicant, Long> {
	Optional<Applicant> findByEmail(String email);

}
