package domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name="ReleaseZ")
public class Release implements Serializable{
	
	@Column
	private Date dateD;
	
	@Column
	private Date dateE;
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column
	private String name;

	@OneToMany(mappedBy="release")
	private List<Task> tasks;

	public Date getDateD() {
		return dateD;
	}

	public Date getDateE() {
		return dateE;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public List<Task> getTasks() {
		return tasks;
	}

	public void setDateD(Date dateD) {
		this.dateD = dateD;
	}

	public void setDateE(Date dateE) {
		this.dateE = dateE;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

}
