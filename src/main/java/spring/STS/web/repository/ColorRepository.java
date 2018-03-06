package spring.STS.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import spring.STS.web.entity.MyColor;

@Repository
public interface ColorRepository extends JpaRepository<MyColor, Integer> {

}
