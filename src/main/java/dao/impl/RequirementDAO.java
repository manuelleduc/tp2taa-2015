package dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import dao.interfaces.IRequirementDAO;
import domain.Requirement;

public class RequirementDAO implements IRequirementDAO {

	private EntityManager manager;

	public void create(Requirement requirement) {
		manager.persist(requirement);
	}

	public void setManager(EntityManager manager) {
		this.manager = manager;
		
	}

	@Override
	public Long count() {
		Query createQuery = manager.createQuery("SELECT count(e.id) FROM Requirement e");
		Long singleResult = (Long) createQuery.getSingleResult();
		return singleResult;
	}

	@Override
	public Requirement findByName(String name) {
		Query createQuery = manager.createQuery("SELECT e FROM Requirement e WHERE e.name = ?");
		createQuery.setParameter(1, name);
		return (Requirement) createQuery.getSingleResult();
	}

}
