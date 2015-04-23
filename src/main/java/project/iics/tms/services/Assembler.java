package project.iics.tms.services;

import java.util.ArrayList;
import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import project.iics.tms.domain.ProjectUser;

@Service("assembler")
public class Assembler {

    @Transactional
    public User buildUserFromEntity(ProjectUser projectUser) {

        String username = projectUser.getUser_Name();
        String password = projectUser.getPassword();
        boolean enabled = true;

        Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));

        return new User(username, password, enabled, enabled, enabled, enabled, authorities);

       /* As you can see I simply add a SimpleGrantedAuthority hardcoded to
        *  the user: ROLE_USER. What you could do is create an entity holding 
        *  UserRoles and load them from the database.*/    
        
    }
}