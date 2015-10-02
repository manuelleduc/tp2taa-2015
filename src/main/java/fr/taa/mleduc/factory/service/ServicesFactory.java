package fr.taa.mleduc.factory.service;

import javax.persistence.EntityManager;

import fr.taa.mleduc.factory.dao.DAOFactory;
import fr.taa.mleduc.service.impl.EpicService;
import fr.taa.mleduc.service.impl.RequirementService;
import fr.taa.mleduc.service.interfaces.IEpicService;
import fr.taa.mleduc.service.interfaces.IRequirementService;

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
