package dao.interfaces;

import javax.persistence.EntityManager;

import domain.Requirement;

public interface IRequirementDAO {

	void create(Requirement requirement);

	void setManager(EntityManager manager);

	Long count();

	Requirement findByName(String name);

}
