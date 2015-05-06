package project.iics.tms.services.security;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import project.iics.tms.domain.ProjectUser;
import project.iics.tms.domain.UserRole;
import project.iics.tms.repository.ProjectUserDao;


@Service("userDetailsService")
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	ProjectUserDao projectUserService;
	
	@Transactional
	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		
		// TODO Auto-generated method stub
		System.out.println("**************"+username);

		project.iics.tms.domain.ProjectUser projectUser  = projectUserService.findByUserName(username).get(0);
		
		List<GrantedAuthority> authorities = buildUserAuthority(projectUser.getUserRoles());
	
		return buildUserForAuthentication(projectUser, authorities);
		
	}

	// Converts com.mkyong.users.model.User user to
	// org.springframework.security.core.userdetails.User
	private User buildUserForAuthentication(ProjectUser projectUser,List<GrantedAuthority> authorities) {
	
		return new User(projectUser.getUser_Name(), projectUser.getPassword(),projectUser.getEnabled(), true, true, true, authorities);
	}
	/*private User buildUserForAuthentication(String projectUser) {
		Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority("ROLE_System_Administrator"));
		
		return new User(projectUser, "cancer", true, true, true, true, authorities);
	}*/
	private List<GrantedAuthority> buildUserAuthority(Set<UserRole> userRoles) {
	
		Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();
	
		// Build user's authorities
		for (UserRole userRole : userRoles) {
		setAuths.add(new SimpleGrantedAuthority(userRole.getRole()));
		}
		
		List<GrantedAuthority> Result = new ArrayList<GrantedAuthority>(setAuths);
		
		return Result;
	}
		


   
}
