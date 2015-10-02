package fr.taa.mleduc.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import fr.taa.mleduc.dao.interfaces.IRequirementDAO;
import fr.taa.mleduc.domain.Requirement;

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
		final TypedQuery<Long> createQuery = manager.createQuery("SELECT count(e.id) FROM Requirement e", Long.class);
		return createQuery.getSingleResult();
	}

	@Override
	public Requirement findByName(String name) {
		TypedQuery<Requirement> createQuery = manager.createQuery("SELECT e FROM Requirement e WHERE e.name = ?", Requirement.class);
		createQuery.setParameter(1, name);
		return createQuery.getSingleResult();
	}

}
