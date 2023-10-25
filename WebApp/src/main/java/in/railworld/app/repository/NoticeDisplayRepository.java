package in.railworld.app.repository;

import in.railworld.app.model.NoticeDisplay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoticeDisplayRepository extends JpaRepository<NoticeDisplay, Long> {
    
}
