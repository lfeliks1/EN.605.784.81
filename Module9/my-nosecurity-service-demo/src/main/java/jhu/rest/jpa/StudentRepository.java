package jhu.rest.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface StudentRepository extends JpaRepository <Student, Long> {

    List <Student> findByLastName(String last_name);

    @Query("SELECT s FROM Student s WHERE s.credits > :credits")
    List <Student> findByMoreCredits(@Param("credits") int credits);

}