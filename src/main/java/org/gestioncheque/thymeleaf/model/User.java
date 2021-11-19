package org.gestioncheque.thymeleaf.model;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
 
@Entity
@Table(name = "user", schema = "public")
public class User implements Serializable {
 
	private static final long serialVersionUID = 1L;
 
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
 
	@Column(name = "first_name", length = 75)
	private String firstName;
 
	@Column(name = "last_name", length = 80)
	private String lastName;
 
	@Column(name = "username", length = 65)
	private String username;
 
	@Column(name = "password", length = 64)
	private String password;
 
	@Column(name = "email", unique = true, length = 115)
	private String email;
	
	@Column(name = "codeEmp", unique = true, length = 115)
	private  String codeEmp;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "role_id")
	private Role role;
 
	public User() {
 
	}
	
 
	public User(String firstName, String lastName, String username, String password, String email, String codeEmp,
			Role role) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.email = email;
		this.codeEmp = codeEmp;
		this.role = role;
	}


	public Long getId() {
		return id;
	}
 
	public void setId(Long id) {
		this.id = id;
	}
 
	public String getFirstName() {
		return firstName;
	}
 
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
 
	public String getLastName() {
		return lastName;
	}
 
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
 
	public String getUsername() {
		return username;
	}
 
	public void setUsername(String username) {
		this.username = username;
	}
 
	public String getPassword() {
		return password;
	}
 
	public void setPassword(String password) {
		this.password = password;
	}
 
	public Role getRole() {
		return role;
	}
 
	public void setRole(Role role) {
		this.role = role;
	}
 
	public String getEmail() {
		return email;
	}
 
	public void setEmail(String email) {
		this.email = email;
	}
	public  String getCodeEmp() {
		return codeEmp;
	}

	public void setCodeEmp(String codeEmp) {
		this.codeEmp = codeEmp;
	}
 
}