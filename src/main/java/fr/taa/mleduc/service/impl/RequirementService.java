package fr.taa.mleduc.service.impl;

import javax.persistence.EntityManager;

import fr.taa.mleduc.dao.interfaces.IRequirementDAO;
import fr.taa.mleduc.dao.interfaces.IUserStoryDAO;
import fr.taa.mleduc.domain.Requirement;
import fr.taa.mleduc.domain.UserStory;
import fr.taa.mleduc.service.interfaces.IRequirementService;

public class RequirementService implements IRequirementService {
	private EntityManager manager;
	private IRequirementDAO requirementDAO;
	private IUserStoryDAO userStoryDAO;

	public EntityManager getManager() {
		return manager;
	}

	public void setManager(EntityManager manager) {
		this.manager = manager;
	}

	public void createRequirement(Requirement requirement) {
		if (requirement.getId() != null) {
			throw new IllegalArgumentException("id must not be defined at creation time");
		}
		
		requirementDAO.create(requirement);

	}

	public void setRequirementDAO(IRequirementDAO requirementDAO) {
		this.requirementDAO = requirementDAO;

	}

	@Override
	public Long countRequirements() {
		return requirementDAO.count();
	}

	@Override
	public Requirement findRequirementByName(String name) {
		return requirementDAO.findByName(name);
		
	}

	@Override
	public void createUserStory(UserStory userStory) {
		userStoryDAO.create(userStory);
		
	}

	@Override
	public void setUserStoryDAO(IUserStoryDAO userStoryDAO) {
		this.userStoryDAO = userStoryDAO;
		
	}

	@Override
	public Long countUserStories(Long releaseId) {
		return this.userStoryDAO.countByReleaseId(releaseId);
		
	}

}
