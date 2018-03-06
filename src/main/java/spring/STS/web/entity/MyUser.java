package spring.STS.web.entity;




import javax.persistence.Entity;

import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import spring.STS.web.validation.annotation.ConfirmPassword;
import spring.STS.web.validation.annotation.UniqueUser;


@Entity
@Table(name = "user")
@Getter @Setter
@NoArgsConstructor
@ConfirmPassword
public class MyUser extends BaseEntity {

	@UniqueUser
	@NotEmpty(message = "Fill it!!")
	private String login;
	@NotEmpty(message = "Fill it!!")
	private String password;
	@NotEmpty(message = "Fill it!!")
	private String confirmPass;
	@NotEmpty(message = "Fill it!!")
	private String email;
	
	private String firstName;
	
	private String lastName;
	
	
	@Override
	public String toString() {
		return "User [login=" + login + ", password=" + password + ", confirmPass=" + confirmPass + ", email=" + email
				+ "]";
	}



	}

	

	


