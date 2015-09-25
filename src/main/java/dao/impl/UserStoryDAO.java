package dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.Metamodel;

import dao.interfaces.IUserStoryDAO;
import domain.Release;
import domain.Task;
import domain.UserStory;

public class UserStoryDAO implements IUserStoryDAO {

    private EntityManager manager;

    @Override
    public void create(final UserStory userStory) {
        manager.persist(userStory);
    }

    @Override
    public void setManager(final EntityManager manager) {
        this.manager = manager;

    }

    @Override
    public Long countByReleaseId(final Long releaseId) {
        final CriteriaBuilder qb = manager.getCriteriaBuilder();
        final CriteriaQuery<Long> cq = qb.createQuery(Long.class);
        final Root<UserStory> from = cq.from(UserStory.class);
        final Join<Task, Release> join2 = from.join("tasks").join("release");

        cq.select(qb.count(from));
        cq.where(qb.equal(join2.get("id"), releaseId));
        return manager.createQuery(cq).getSingleResult();
    }

}
