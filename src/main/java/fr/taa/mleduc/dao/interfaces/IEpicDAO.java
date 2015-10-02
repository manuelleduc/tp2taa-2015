package fr.taa.mleduc.dao.interfaces;

import javax.persistence.EntityManager;

import fr.taa.mleduc.domain.Epic;

public interface IEpicDAO {

	void create(Epic epic);

	void setManager(EntityManager manager);

}
