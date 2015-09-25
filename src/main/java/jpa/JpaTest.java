package jpa;

import java.sql.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import domain.Epic;
import domain.Release;
import domain.Task;
import domain.TeamMember;
import domain.UserStory;
import factory.service.ServicesFactory;
import service.interfaces.IEpicService;
import service.interfaces.IRequirementService;

public class JpaTest {

	/**
	 * @param args
	 */
	public static void main(final String[] args) {
		final EntityManagerFactory factory = Persistence.createEntityManagerFactory("istic");
		final EntityManager manager = factory.createEntityManager();

		final EntityTransaction tx = manager.getTransaction();
		tx.begin();
		try {
			final IRequirementService requirementService = ServicesFactory.getRequirementService(manager);
			final IEpicService epicService = ServicesFactory.getEpicService(manager);
			
			Long releaseId = 1L;
			Long countUserStories = requirementService.countUserStories(releaseId);
			System.out.println(countUserStories);
			
//			Task entity = new Task();
//			entity.setConsumed(0L);
//			entity.setCurrentEstimation(3L);
//			entity.setInitialEstimation(3L);
//			entity.setName("t1");
//			manager.persist(entity);
			
			
			
//			Release entity = new Release();
//			entity.setName("hello");
//			manager.persist(entity);
			
		TeamMember entity = new TeamMember();
		entity.setName("mleduc");
		manager.persist(entity);
		
		UserStory entity2 = new UserStory();
		entity2.setName("ok");
		Epic epic = new Epic();
		epic.setName("okok");
		entity2.setEpic(epic);
		manager.persist(epic);
		manager.persist(entity2);
			
			

			tx.commit();
		} catch (final Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
		manager.close();
		factory.close();
	}

}
