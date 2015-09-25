package testjpa;

import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import domain.Requirement;
import domain.UserStory;
import factory.service.ServicesFactory;
import service.interfaces.IRequirementService;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RequirementTests extends ResetAfterEachTest {

	private final IRequirementService requirementService = ServicesFactory.getRequirementService(manager);

	@Test
	public void test1() throws Exception {
		final EntityTransaction tx = manager.getTransaction();
		tx.begin();
		try {

			Requirement requirement = new Requirement();
			requirement.setName("hello");
			requirement.setPriority(1L);
			requirementService.createRequirement(requirement);

			long cpt = requirementService.countRequirements();
			Assert.assertEquals(1L, cpt);

		} catch (final Exception e) {
			e.printStackTrace();
		}
		tx.commit();
	}

	@Test(expected = javax.persistence.PersistenceException.class)
	public void test2NameUnicity() throws Exception {
		final EntityTransaction tx = manager.getTransaction();
		try {
			tx.begin();

			Requirement requirement = new Requirement();
			requirement.setName("hello");
			requirement.setPriority(1L);
			requirementService.createRequirement(requirement);

			Requirement rq2 = new Requirement();
			rq2.setName("hello");
			requirement.setPriority(2L);
			requirementService.createRequirement(rq2);

			long cpt = requirementService.countRequirements();
			Assert.assertEquals(1L, cpt);
			tx.commit();
		} catch(PersistenceException pe) {
			tx.rollback();
			throw pe;		}
	}

	@Test
	public void test3CreateUserStory() throws Exception {
		final EntityTransaction tx = manager.getTransaction();
		try {
			tx.begin();

//			Requirement findRequirementByName = requirementService.findRequirementByName("hello");

			long countRequirements = requirementService.countRequirements();
			UserStory userStory = new UserStory();
			userStory.setName("us1");
			userStory.setDescription("user can create a user story");
			userStory.setPriority(1L);
//			userStory.getRequirements().add(findRequirementByName);
			Requirement newReq = new Requirement();
			newReq.setName("hello2");
			newReq.setPriority(2L);
//			manager.flush();
			userStory.getRequirements().add(newReq);
//			manager.merge(userStory);
//			manager.flush();
			requirementService.createRequirement(newReq);
			requirementService.createUserStory(userStory);
			long countRequirements2 = requirementService.countRequirements();
			
			Assert.assertEquals(countRequirements + 1L , countRequirements2);
			
		} finally {
			tx.commit();
		}

	}

}
