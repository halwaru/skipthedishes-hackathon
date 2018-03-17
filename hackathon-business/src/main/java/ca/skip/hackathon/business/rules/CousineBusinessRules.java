package ca.skip.hackathon.business.rules;

import java.util.Set;

import ca.skip.hackathon.dao.CousineDAO;
import ca.skip.hackathon.entity.Cousine;

public class CousineBusinessRules extends AbstractBusinessRules {

    public Set<Cousine> listAll() {
        return getDAO(CousineDAO.class).listAll();
    }

    public Set<Cousine> search(String searchText) {
        return getDAO(CousineDAO.class).basicSearch(searchText);
    }

}
