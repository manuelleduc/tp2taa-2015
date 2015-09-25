package factory.dao;

import javax.persistence.EntityManager;

import dao.impl.EpicDAO;
import dao.impl.RequirementDAO;
import dao.impl.UserStoryDAO;
import dao.interfaces.IEpicDAO;
import dao.interfaces.IRequirementDAO;
import dao.interfaces.IUserStoryDAO;

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
