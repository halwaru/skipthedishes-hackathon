package ca.skip.hackathon.rest.controller;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ca.skip.hackathon.business.rules.CousineBusinessRules;
import ca.skip.hackathon.entity.Cousine;
import ca.skip.hackathon.rest.dto.CousineDTO;

@RestController
public class CousineRestController extends AbstractRestController {

    @ResponseBody
    @RequestMapping(value = "/Cousine", method = RequestMethod.GET)
    public ResponseEntity<Set<CousineDTO>> listCousines() {
        final Set<Cousine> cousines = getBR(CousineBusinessRules.class).listAll();
        return new ResponseEntity<>(cousines.stream().map(CousineDTO::new).collect(Collectors.toSet()), HttpStatus.OK);
    }

    @ResponseBody
    @RequestMapping(value = "/Cousine/search/{searchText}", method = RequestMethod.GET)
    public ResponseEntity<Set<CousineDTO>> searchCousines(@PathVariable String searchText) {
        final Set<Cousine> cousines = getBR(CousineBusinessRules.class).search(searchText);
        return new ResponseEntity<>(cousines.stream().map(CousineDTO::new).collect(Collectors.toSet()), HttpStatus.OK);
    }

}
