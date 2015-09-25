package service.interfaces;

import javax.persistence.EntityManager;

import dao.interfaces.IEpicDAO;
import domain.Epic;

public interface IEpicService {

	void createEpic(Epic epic);

	void setManager(EntityManager manager);

	void setEpicDAO(IEpicDAO epicDAO);

}
