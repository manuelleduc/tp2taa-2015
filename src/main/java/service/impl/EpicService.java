package service.impl;

import javax.persistence.EntityManager;

import dao.interfaces.IEpicDAO;
import domain.Epic;
import service.interfaces.IEpicService;

public class EpicService implements IEpicService {

	private EntityManager manager;
	private IEpicDAO epicDAO;

	@Override
	public void createEpic(Epic epic) {
		this.epicDAO.create(epic);
	}

	@Override
	public void setManager(EntityManager manager) {
		this.manager = manager;

	}

	@Override
	public void setEpicDAO(IEpicDAO epicDAO) {
		this.epicDAO = epicDAO;

	}

}
