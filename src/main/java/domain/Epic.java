package domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Epic implements Serializable {

	@Id
	@GeneratedValue
	private Long id;

	@Column
	private String name;

	@Column
	private Long priority;
	
	@OneToMany(mappedBy="epic")
	private List<UserStory> userStories;
	

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Long getPriority() {
		return priority;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void setPriority(Long priority) {
		this.priority = priority;
	}

	@Override
	public String toString() {
		return "Epic [id=" + id + ", name=" + name + ", priority=" + priority + ", userStories=" + userStories + "]";
	}
}
