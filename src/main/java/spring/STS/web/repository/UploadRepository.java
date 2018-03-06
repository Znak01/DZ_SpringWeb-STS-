package spring.STS.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import spring.STS.web.entity.UploadFile;

@Repository
public interface UploadRepository extends JpaRepository<UploadFile, Integer> {

}
