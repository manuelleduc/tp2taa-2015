package fr.taa.mleduc.dao.impl;

import javax.persistence.EntityManager;

import fr.taa.mleduc.dao.interfaces.IEpicDAO;
import fr.taa.mleduc.domain.Epic;

public class EpicDAO implements IEpicDAO {

	private EntityManager manager;

	@Override
	public void create(Epic epic) {
		this.manager.persist(epic);

	}

	@Override
	public void setManager(EntityManager manager) {
		this.manager = manager;

	}

}
