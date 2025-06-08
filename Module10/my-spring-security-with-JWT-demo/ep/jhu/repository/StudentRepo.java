package ep.jhu.repository;

import ep.jhu.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

// Defines a repository which provides an API or a list of helpful functions
// that helps us to work with the User entity
//public interface StudentRepo extends JpaRepository<User, Long> {
    public interface StudentRepo extends JpaRepository<Student, Long> {
    // Defines a custom method to find a User using the email attribute
    public Optional<Student> findByEmail(String email);
}
