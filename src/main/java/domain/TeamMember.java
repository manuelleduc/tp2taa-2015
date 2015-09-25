package domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * Entity implementation class for Entity: Requirement
 *
 */
@Entity
public class TeamMember implements Serializable {

	@Id
	@GeneratedValue
	private Long id;

	@Column
	private String name;

	@Column
	private String surname;

	@Column
	private String role;

	@OneToMany(mappedBy = "teamMember")
	private List<Task> tasks;

	public TeamMember() {
		super();
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getRole() {
		return role;
	}

	public String getSurname() {
		return surname;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

}
