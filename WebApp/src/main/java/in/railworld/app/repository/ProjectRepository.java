package in.railworld.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.railworld.app.model.Project;

public interface ProjectRepository extends JpaRepository<Project, Integer> {
    // You can define custom query methods here if needed.
}

