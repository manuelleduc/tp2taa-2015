package dao.impl;

import javax.persistence.EntityManager;

import dao.interfaces.IEpicDAO;
import domain.Epic;

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
