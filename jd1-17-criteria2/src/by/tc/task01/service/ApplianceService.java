package by.tc.task01.service;

import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.criteria.Criteria;
import sun.security.validator.ValidatorException;

import java.util.List;

public interface ApplianceService {	
	
	List<Appliance> find(Criteria criteria) throws ValidatorException;
	
}
