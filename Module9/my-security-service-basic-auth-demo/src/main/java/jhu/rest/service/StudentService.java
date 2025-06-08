package jhu.rest.service;

/*
import org.springframework.data.repository.query.Param;
import jhu.rest.jpa.Student;

// next line should be commented to eliminate using spring security
//import org.springframework.security.core.userdetails.User;
import java.util.List;
import java.util.Optional;

public interface StudentService {

//    String login(String username, String password);
// next line should be commented to eliminate using spring security
//    Optional<User> findByToken(String token);
    Student findById(Long id);
    List <Student> findByUserName(String username);
//    Custom query
//   @Query("SELECT s FROM Student s WHERE s.credits > :credits")
    List <Student> findByMoreCredits(@Param("credits") int credits);

}
*/


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import jhu.rest.jpa.Student;
import jhu.rest.jpa.StudentRepository;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List <Student> findAll() {
        return studentRepository.findAll();
    }

    public Optional<Student> findById(Long id) {
        return studentRepository.findById(id);
    }

    public Student save(Student student) {
        return studentRepository.save(student);
    }

    public void deleteById(Long id) {
        studentRepository.deleteById(id);
    }

    public List <Student> findByLastName(String lastname) {
        return studentRepository.findByLastName(lastname);
    }

    public List <Student> findByMoreCredits(int credits) {
        return studentRepository.findByMoreCredits(credits);
    }

    public Long count ( ) {
        return studentRepository.count();
    }
    
}
