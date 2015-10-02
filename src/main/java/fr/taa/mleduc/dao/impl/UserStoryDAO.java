package fr.taa.mleduc.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.Metamodel;

import fr.taa.mleduc.dao.interfaces.IUserStoryDAO;
import fr.taa.mleduc.domain.Release;
import fr.taa.mleduc.domain.Task;
import fr.taa.mleduc.domain.UserStory;

public class UserStoryDAO implements IUserStoryDAO {

	private EntityManager manager;

	@Override
	public void create(UserStory userStory) {
		manager.persist(userStory);
	}

	@Override
	public void setManager(EntityManager manager) {
		this.manager = manager;

	}

	@Override
	public Long countByReleaseId(Long releaseId) {
		CriteriaBuilder qb = manager.getCriteriaBuilder();
		CriteriaQuery<Long> cq = qb.createQuery(Long.class);
		Root<UserStory> from = cq.from(UserStory.class);
		Join<Task, Release> join2 = from.join("tasks").join("release");
		
		cq.select(qb.count(from));
		cq.where(qb.equal(join2.get("id"), releaseId));
		TypedQuery<Long> createQuery = manager.createQuery(cq);
		return createQuery.getSingleResult();
	}

}
