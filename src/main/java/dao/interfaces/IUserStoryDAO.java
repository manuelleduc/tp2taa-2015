package dao.interfaces;

import javax.persistence.EntityManager;

import domain.UserStory;

public interface IUserStoryDAO {

	void create(UserStory userStory);

	void setManager(EntityManager manager);

	Long countByReleaseId(Long releaseId);

}
