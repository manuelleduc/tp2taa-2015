package fr.taa.mleduc.dao.interfaces;

import javax.persistence.EntityManager;

import fr.taa.mleduc.domain.Requirement;

public interface IRequirementDAO {

	void create(Requirement requirement);

	void setManager(EntityManager manager);

	Long count();

	Requirement findByName(String name);

}
