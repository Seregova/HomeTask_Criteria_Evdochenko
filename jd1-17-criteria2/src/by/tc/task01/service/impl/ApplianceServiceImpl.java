package by.tc.task01.service.impl;

import by.tc.task01.dao.ApplianceDAO;
import by.tc.task01.dao.DAOFactory;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.service.ApplianceService;
import by.tc.task01.service.validation.Validator;
import sun.security.validator.ValidatorException;

import javax.xml.bind.ValidationException;
import java.util.List;

public class ApplianceServiceImpl implements ApplianceService{

	@Override
	public List<Appliance> find(Criteria criteria) throws ValidatorException {
		if (!Validator.criteriaValidator(criteria)) {
			throw new ValidatorException("Invalid criteria");
		}
		
		DAOFactory factory = DAOFactory.getInstance();
		ApplianceDAO applianceDAO = factory.getApplianceDAO();
		
		List<Appliance> applianceList = applianceDAO.find(criteria);
		
		// you may add your own code here
		
		return applianceList;
	}

}

//you may add your own new classes
