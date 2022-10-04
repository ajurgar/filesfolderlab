package filesfolderhomework.filesfolderlab.repository;

import filesfolderhomework.filesfolderlab.models.File;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileRepository extends JpaRepository<File, Long> {
}
