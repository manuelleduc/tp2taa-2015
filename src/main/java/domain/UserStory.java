package domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class UserStory implements Serializable {

	@Column
	private String description;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "EPIC_ID")
	private Epic epic;

	@Id
	@GeneratedValue
	private Long id;

	@Column
	private String name;

	@Column
	private Long priority;

	@ManyToMany
	  @JoinTable(
	      name="USERSTORY_REQUIREMENT",
	      joinColumns={@JoinColumn(name="USERSTORY_ID", referencedColumnName="ID")},
	      inverseJoinColumns={@JoinColumn(name="REQUIREMENT_ID", referencedColumnName="ID")})
	private List<Requirement> requirements;
	
	@OneToMany(mappedBy="userStory")
	private List<Task> tasks;

	public String getDescription() {
		return description;
	}

	public Epic getEpic() {
		return epic;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Long getPriority() {
		return priority;
	}

	public List<Requirement> getRequirements() {
		if(requirements == null) {
			requirements = new ArrayList<>();
		}
		return requirements;
	}

	public List<Task> getTasks() {
		return tasks;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setEpic(Epic epic) {
		this.epic = epic;
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

	public void setRequirements(List<Requirement> requirements) {
		this.requirements = requirements;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}
}
