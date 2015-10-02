package fr.taa.mleduc.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

/**
 * Entity implementation class for Entity: Requirement
 *
 */
@Entity
public class Task implements Serializable {

	@Id
	@GeneratedValue
	private Long id;
	
	@Column
	private String name;

	@Column
	private Long initialEstimation;

	@Column
	private Long consumed;

	@Column
	private Long currentEstimation;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TEAMMEMBER_ID")
	private TeamMember teamMember;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "RELEASE_ID")
	private Release release;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USERSTORY_ID")
	private UserStory userStory;

	public Task() {
		super();
	}

	public Long getConsumed() {
		return consumed;
	}

	public Long getCurrentEstimation() {
		return currentEstimation;
	}

	public Long getId() {
		return id;
	}

	public Long getInitialEstimation() {
		return initialEstimation;
	}

	public String getName() {
		return name;
	}

	public TeamMember getTeamMember() {
		return teamMember;
	}

	public void setConsumed(Long consumed) {
		this.consumed = consumed;
	}

	public void setCurrentEstimation(Long currentEstimation) {
		this.currentEstimation = currentEstimation;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setInitialEstimation(Long initialEstimation) {
		this.initialEstimation = initialEstimation;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setTeamMember(TeamMember teamMember) {
		this.teamMember = teamMember;
	}

	public Release getRelease() {
		return release;
	}

	public void setRelease(Release release) {
		this.release = release;
	}

	public UserStory getUserStory() {
		return userStory;
	}

	public void setUserStory(UserStory userStory) {
		this.userStory = userStory;
	}

	

}
