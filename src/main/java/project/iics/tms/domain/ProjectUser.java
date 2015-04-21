package project.iics.tms.domain;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Transient;
import javax.transaction.Transactional;



@Entity
@NamedQueries({
	@NamedQuery(
			name = "findUserByUserName",
			query = "from ProjectUser where user_name like :user_name"
					),
	@NamedQuery(
			name = "findRegisteredUser",
			query = "from ProjectUser where user_name like :user_name AND password like :password"
					)
})

/*
 * name = "findUserByPassword",
query = "from ProjectUser where password like :password"
 * 
 * */
public class ProjectUser {
	
		/**
		 * The Project User entity defines a 
		 * user of the task management system
		 */
	
		private Long id;		
		private String First_Name;
		private String Middle_Name;
		private String Last_Name;
		private String User_Name;
		private String Password;
		private String Confirmpassword;
		private String Gender;
		private String DOB;
		
		
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		@Column
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		
		
		@Column(name = "dob")
		public String getDOB() {
			return DOB;
		}
		public void setDOB(String dOB) {
			DOB = dOB;
		}
		
		
		@Column(name = "first_name")
		public String getFirst_Name() {
			return First_Name;
		}
		public void setFirst_Name(String first_Name) {
			First_Name = first_Name;
		}

		
		
		@Column(name = "last_name")
		public String getLast_Name() {
			return Last_Name;
		}
		
		public void setLast_Name(String last_Name) {
			Last_Name = last_Name;
		}
		
		
		@Column(name = "middle_names")
		public String getMiddle_Name() {
			return Middle_Name;
		}
		public void setMiddle_Name(String middle_Name) {
			Middle_Name = middle_Name;
		}
		
		
		
		@Column(name = "user_name")
		public String getUser_Name() {
			return User_Name;
		}
		public void setUser_Name(String user_Name) {
			User_Name = user_Name;
		}
		
		
		
		@Column(name = "password")
		public String getPassword() {
			return Password;
		}
		public void setPassword(String password) {
			Password = password;
		}
				
		
		@Column(name = "confirm_password")
		public String getConfirmpassword() {
			return Confirmpassword;
		}
		public void setConfirmpassword(String confirmpassword) {
			Confirmpassword = confirmpassword;
		}
		
		@Column(name = "gender")
		public String getGender() {
			return Gender;
		}
		public void setGender(String gender) {
			Gender = gender;
		}
		
		@Transient
		public String getFullName() {
			String fullName = Last_Name + ", " + First_Name;
			if (! (Middle_Name == null || "".equals(Middle_Name.trim()))) {
			fullName += " " + Middle_Name + ".";
			}
			return fullName;
		}
		
				
		public String toString() {
			return "[ProjectUser: id=" + id
			+ ", firstName=" + First_Name
			+ ", middleNames=" + Middle_Name
			+ ", lastName=" + Last_Name
			+ ", userName=" + User_Name
			+ ", password=" + Password
			+ ", gender=" + Gender
			+ ", date of birth=" + DOB
			+ "]";
		}

}