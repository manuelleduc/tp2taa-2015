package fr.taa.mleduc.service.interfaces;

import javax.persistence.EntityManager;

import fr.taa.mleduc.dao.interfaces.IEpicDAO;
import fr.taa.mleduc.domain.Epic;

public interface IEpicService {

	void createEpic(Epic epic);

	void setManager(EntityManager manager);

	void setEpicDAO(IEpicDAO epicDAO);

}
