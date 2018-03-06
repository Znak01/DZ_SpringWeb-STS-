package spring.STS.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import spring.STS.web.entity.MyUser;




@Repository
public interface UserRepository extends JpaRepository<MyUser, Integer>{

	@Query("SELECT u FROM MyUser u WHERE u.login = :login")
	MyUser findUserByLogin(@Param("login") String model);
	
}
