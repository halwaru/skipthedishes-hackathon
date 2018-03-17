package ca.skip.hackathon.business.rules;

import java.util.HashMap;
import java.util.Map;

import ca.skip.hackathon.dao.AbstractDAO;
import ca.skip.hackathon.entity.AbstractEntity;

public abstract class AbstractBusinessRules {

    private static final Map<Class<AbstractDAO<AbstractEntity>>, AbstractDAO<AbstractEntity>> DAO_MAP = new HashMap<>();

    @SuppressWarnings("unchecked")
    public <D extends AbstractDAO<?>> D getDAO(Class<D> clazz) {
        try {
            return (D) DAO_MAP.getOrDefault(clazz, (AbstractDAO<AbstractEntity>) clazz.newInstance());
        } catch (InstantiationException | IllegalAccessException e) {
            // Something is very very wrong, because I have a DAO that I can't
            // instantiate
            return null;
        }
    }

}
