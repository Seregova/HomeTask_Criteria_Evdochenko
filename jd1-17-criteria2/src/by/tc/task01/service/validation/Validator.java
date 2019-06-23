package by.tc.task01.service.validation;

import by.tc.task01.entity.criteria.Criteria;
import static by.tc.task01.entity.criteria.SearchCriteria.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Validator {
	
	public static boolean criteriaValidator(Criteria criteria) {
		String criteriaName = criteria.getGroupSearchName();
		Set<String> paramsTitles = criteria.getCriteria().keySet();

		String[] typesArray = {"Oven", "TabletPC", "Laptop", "Refrigerator", "VacuumCleaner", "Speakers"};
		if (! Arrays.asList(typesArray).contains(criteriaName)) {
			return false;
		}

		Set<String> applianceParams;
		if (criteriaName.equals("Oven")) {
			applianceParams = new HashSet<String>(Arrays.asList(Arrays.toString(Oven.values()).replaceAll("^.|.$", "").split(", ")));
		} else if (criteriaName.equals("TabletPC")){
			applianceParams = new HashSet<String>(Arrays.asList(Arrays.toString(TabletPC.values()).replaceAll("^.|.$", "").split(", ")));
		} else if (criteriaName.equals("Laptop")){
			applianceParams = new HashSet<String>(Arrays.asList(Arrays.toString(Laptop.values()).replaceAll("^.|.$", "").split(", ")));
		} else if (criteriaName.equals("Refrigerator")){
			applianceParams = new HashSet<String>(Arrays.asList(Arrays.toString(Refrigerator.values()).replaceAll("^.|.$", "").split(", ")));
		} else if (criteriaName.equals("VacuumCleaner")){
			applianceParams = new HashSet<String>(Arrays.asList(Arrays.toString(VacuumCleaner.values()).replaceAll("^.|.$", "").split(", ")));
		} else if (criteriaName.equals("Speakers")){
			applianceParams = new HashSet<String>(Arrays.asList(Arrays.toString(Speakers.values()).replaceAll("^.|.$", "").split(", ")));

		} else {
			applianceParams = new HashSet<String>();
		}

		if (applianceParams.containsAll(paramsTitles)) {
			return true;
		} else {
			return false;
		}
	}
}
