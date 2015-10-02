package fr.taa.mleduc.dao.interfaces;

import javax.persistence.EntityManager;

import fr.taa.mleduc.domain.UserStory;

public interface IUserStoryDAO {

	void create(UserStory userStory);

	void setManager(EntityManager manager);

	Long countByReleaseId(Long releaseId);

}
