package dao.interfaces;

import javax.persistence.EntityManager;

import domain.Epic;

public interface IEpicDAO {

	void create(Epic epic);

	void setManager(EntityManager manager);

}
