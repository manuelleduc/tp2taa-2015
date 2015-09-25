package service.interfaces;

import javax.persistence.EntityManager;

import dao.interfaces.IRequirementDAO;
import dao.interfaces.IUserStoryDAO;
import domain.Requirement;
import domain.UserStory;

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
