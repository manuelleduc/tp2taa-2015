package fr.taa.mleduc.factory.dao;

import javax.persistence.EntityManager;

import fr.taa.mleduc.dao.impl.EpicDAO;
import fr.taa.mleduc.dao.impl.RequirementDAO;
import fr.taa.mleduc.dao.impl.UserStoryDAO;
import fr.taa.mleduc.dao.interfaces.IEpicDAO;
import fr.taa.mleduc.dao.interfaces.IRequirementDAO;
import fr.taa.mleduc.dao.interfaces.IUserStoryDAO;

public class DAOFactory {

	private static IRequirementDAO requirementDAO;
	private static IUserStoryDAO userStoryDAO;
	private static IEpicDAO epicDAO;

	public static IRequirementDAO getRequirementDAO(EntityManager manager) {
		if (requirementDAO == null) {
			requirementDAO = new RequirementDAO();
			requirementDAO.setManager(manager);
		}
		return requirementDAO;
	}

	public static IUserStoryDAO getUserStoryDAO(EntityManager manager) {
		if (userStoryDAO == null) {
			userStoryDAO = new UserStoryDAO();
			userStoryDAO.setManager(manager);
		}

		return userStoryDAO;
	}

	public static IEpicDAO getEpicDAO(EntityManager manager) {
		if(epicDAO == null) {
			epicDAO = new EpicDAO();
			epicDAO.setManager(manager);
		}
		return epicDAO;
	}

}
