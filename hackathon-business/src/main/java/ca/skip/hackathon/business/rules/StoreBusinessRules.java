package ca.skip.hackathon.business.rules;

import java.util.Optional;
import java.util.Set;

import ca.skip.hackathon.business.rules.exception.BusinessRulesException;
import ca.skip.hackathon.dao.StoreDAO;
import ca.skip.hackathon.entity.Store;

public class StoreBusinessRules extends AbstractBusinessRules {

    public Store get(int id) throws BusinessRulesException {
        final Optional<Store> store = getDAO(StoreDAO.class).get(id);
        if (store.isPresent()) {
            return store.get();
        }
        throw new BusinessRulesException("ID not found");
    }

    public Set<Store> listAll() {
        return getDAO(StoreDAO.class).listAll();
    }

    public Set<Store> search(String searchText) {
        return getDAO(StoreDAO.class).basicSearch(searchText);
    }

    public Set<Store> findByCousine(int cousineId) {
        return getDAO(StoreDAO.class).cousineSearch(cousineId);
    }

}
