package ep.jhu.controllers;

import ep.jhu.entity.Student;
import ep.jhu.models.LoginCredentials;
import ep.jhu.repository.StudentRepo;
import ep.jhu.security.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@RestController // Marks the class a rest controller
@RequestMapping("/api/auth") // Requests made to /api/auth/anything will be handles by this class
public class AuthController {

    // Injecting Dependencies
    @Autowired private StudentRepo studentRepo;
    @Autowired private JWTUtil jwtUtil;
    @Autowired private AuthenticationManager authManager;
    @Autowired private PasswordEncoder passwordEncoder;

    // Defining the function to handle the POST route for registering a user
    @PostMapping("/register")
        public Map<String, Object> registerHandler(@RequestBody Student student){
        // Encoding Password using Bcrypt
        String encodedPass = passwordEncoder.encode(student.getPassword());

        // Setting the encoded password
        student.setPassword(encodedPass);

        // Persisting the User Entity to H2 Database
        student = studentRepo.save(student);

        // Generating JWT
        String token = jwtUtil.generateToken(student.getEmail());

        // Responding with JWT
        return Collections.singletonMap("jwt-token", token);
    }

    // Defining the function to handle the POST route for logging in a user
    @PostMapping("/login")
    public Map<String, Object> loginHandler(@RequestBody LoginCredentials body){
        try {
            // Creating the Authentication Token which will contain the credentials for authenticating
            // This token is used as input to the authentication process
            UsernamePasswordAuthenticationToken authInputToken =
                    new UsernamePasswordAuthenticationToken(body.getEmail(), body.getPassword());

            // Authenticating the Login Credentials
            authManager.authenticate(authInputToken);

            // If this point is reached it means Authentication was successful
            // Generate the JWT
            String token = jwtUtil.generateToken(body.getEmail());

            // Respond with the JWT
            return Collections.singletonMap("jwt-token", token);
        }catch (AuthenticationException authExc){
            // Auhentication Failed
            throw new RuntimeException("Invalid Login Credentials");
        }
    }


}
