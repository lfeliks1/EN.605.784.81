package ep.jhu.security;

import ep.jhu.entity.Student;
import ep.jhu.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Optional;

// A UserDetailsService is used to fetch the user details of the user trying to authenticate
// into the application. This is done in the loadUserByUsername method.
// If no such user is found a UsernameNotFoundException is thrown

@Component // Marks this as a component. Now, Spring Boot will handle the creation and management of the MyUserDetailsService Bean
// and you will be able to inject it in other places of your code
public class MyUserDetailsService implements UserDetailsService {

    // Injecting Dependencies
    @Autowired private StudentRepo studentRepo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        // Fetch User from the DB
        Optional<Student> studentRes = studentRepo.findByEmail(email);
        // No user found
        if(studentRes.isEmpty())
            throw new UsernameNotFoundException("Could not findUser with email = " + email);
        // Return a User Details object using the fetched User information
            Student student = studentRes.get();
            return new org.springframework.security.core.userdetails.User(
                email,
                  student.getPassword(),
                Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER"))); // Sets the role of the found user
    }
}
