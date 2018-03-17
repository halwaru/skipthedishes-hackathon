package ca.skip.hackathon.rest.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import ca.skip.hackathon.business.rules.AbstractBusinessRules;
import ca.skip.hackathon.business.rules.exception.BusinessRulesException;

@RequestMapping(value = "/api/v1", headers = "Accept="
        + MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class AbstractRestController {

    private static final Map<Class<AbstractBusinessRules>, AbstractBusinessRules> RULES_MAP = new HashMap<>();

    @SuppressWarnings("unchecked")
    public <BR extends AbstractBusinessRules> BR getBR(Class<BR> clazz) {
        try {
            return (BR) RULES_MAP.getOrDefault(clazz, (AbstractBusinessRules) clazz.newInstance());
        } catch (InstantiationException | IllegalAccessException e) {
            // Something is very very wrong, because I have a Business Rules
            // that I can't instantiate
            return null;
        }
    }

    @ExceptionHandler
    public ResponseEntity<Object> handle(BusinessRulesException exception) {
        return new ResponseEntity<>(exception.getLocalizedMessage(), HttpStatus.BAD_REQUEST);
    }

}
