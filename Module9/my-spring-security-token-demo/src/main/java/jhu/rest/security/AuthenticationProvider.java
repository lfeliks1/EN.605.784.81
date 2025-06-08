package jhu.rest.security;

import jhu.rest.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import java.util.Optional;

@Component
public class AuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {

    @Autowired
    StudentService studentService;

    @Override
    protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken) throws AuthenticationException {
           System.out.println("??????? IN AUTH...PROVIDER - additionalAuthenticationChecks !!!!!!!!!!!!!!!!");
    }

    @Override
    protected UserDetails retrieveUser(String userName, UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken) throws AuthenticationException {
           System.out.println("??????? IN AUTH...PROVIDER - retrieveUser !!!!!!!!!!!!!!!!!!!!!!!!!");
        Object token= usernamePasswordAuthenticationToken.getCredentials();  // ATTENTION - IMPORTANT STEP !!!
        return Optional
                .ofNullable(token)
                .map(String::valueOf)
                .flatMap(studentService::findByToken)
                .orElseThrow(() -> new UsernameNotFoundException("Cannot find user with authentication token=" + token));
    }
}
