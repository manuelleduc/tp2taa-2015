package fr.taa.mleduc.service.interfaces;

import javax.persistence.EntityManager;

import fr.taa.mleduc.dao.interfaces.IRequirementDAO;
import fr.taa.mleduc.dao.interfaces.IUserStoryDAO;
import fr.taa.mleduc.domain.Requirement;
import fr.taa.mleduc.domain.UserStory;

public interface IRequirementService {

	void setManager(EntityManager manager);
	
	void setRequirementDAO(IRequirementDAO requirementDAO);

	void createRequirement(Requirement requirement);

	Long countRequirements();

	Requirement findRequirementByName(String name);

	void createUserStory(UserStory userStory);

	void setUserStoryDAO(IUserStoryDAO userStoryDAO);

	Long countUserStories(Long releaseId);

}
