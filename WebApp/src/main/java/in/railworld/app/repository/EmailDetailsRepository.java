package in.railworld.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.railworld.app.model.EmailDetails;

public interface EmailDetailsRepository extends JpaRepository<EmailDetails, Long> {
    // Add any custom query methods if needed
}

