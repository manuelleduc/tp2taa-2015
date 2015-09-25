package domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Entity implementation class for Entity: Requirement
 *
 */
@Entity
@Table(name = "Requirement", uniqueConstraints = @UniqueConstraint(columnNames = "name") )
public class Requirement implements Serializable {

	public Requirement() {
		super();
	}

	@Id
	@GeneratedValue
	private Long id;

	@Column
	private Long priority;

	@Column
	private String name;

	@ManyToMany(mappedBy = "requirements")
	private List<UserStory> userStories;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getPriority() {
		return priority;
	}

	public void setPriority(Long priority) {
		this.priority = priority;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<UserStory> getUserStories() {
		return userStories;
	}

	public void setUserStories(List<UserStory> userStories) {
		this.userStories = userStories;
	}

}
