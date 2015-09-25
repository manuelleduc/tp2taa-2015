package factory.service;

import javax.persistence.EntityManager;

import factory.dao.DAOFactory;
import service.impl.RequirementService;
import service.impl.EpicService;
import service.interfaces.IRequirementService;
import service.interfaces.IEpicService;

public class ServicesFactory {
	private static IRequirementService requirementService;
	private static IEpicService userStoryService;

	public static IRequirementService getRequirementService(EntityManager manager) {
		if (requirementService == null) {
			requirementService = new RequirementService();
			requirementService.setManager(manager);
			requirementService.setRequirementDAO(DAOFactory.getRequirementDAO(manager));
			requirementService.setUserStoryDAO(DAOFactory.getUserStoryDAO(manager));
		}
		return requirementService;
	}

	public static IEpicService getEpicService(EntityManager manager) {
		if (userStoryService == null) {
			userStoryService = new EpicService();
			userStoryService.setManager(manager);
			userStoryService.setEpicDAO(DAOFactory.getEpicDAO(manager));
		}
		return userStoryService;
	}
}
