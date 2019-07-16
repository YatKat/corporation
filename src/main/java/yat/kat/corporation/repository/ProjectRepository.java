package yat.kat.corporation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import yat.kat.corporation.model.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {

}
