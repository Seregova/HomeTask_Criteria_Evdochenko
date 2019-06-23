package by.tc.task01.dao.impl;

import by.tc.task01.dao.ApplianceDAO;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.criteria.Criteria;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class ApplianceDAOImpl implements ApplianceDAO{

	@Override
	public List<Appliance> find(Criteria criteria) {

		ArrayList<Appliance> returningAppliances = new ArrayList<Appliance>();
		ArrayList<Appliance> allAppliances = this.readAllAppliances();

		Map<String, Object> criteriaParams = criteria.getCriteria();
		Set<String> criteriaParamsSet = criteriaParams.keySet();

		for (Appliance appliance : allAppliances) {
			if (!appliance.getTitle().equals(criteria.getGroupSearchName())) {
				continue;
			}
			Map<String, Object> applianceParams = appliance.getParams();
			boolean toAdd = true;
			for (String criteriaParamName: criteriaParamsSet) {
				if (!criteriaParams.get(criteriaParamName).toString().equals(applianceParams.get(criteriaParamName).toString())) {
					toAdd = false;
				}
			}

			if (toAdd) {
				returningAppliances.add(appliance);
			}
		}


		return returningAppliances;
	}
	
	private ArrayList<Appliance> readAllAppliances() {
		ArrayList<Appliance> allAppliances = new ArrayList<Appliance>();
 		InputStream inputStream = ApplianceDAOImpl.class.getClassLoader().getResourceAsStream("appliances_db.txt");
		try{
			BufferedReader br = null;
			br = new BufferedReader(new InputStreamReader(inputStream));
			String line = null;
			while ((line = br.readLine()) != null) {
				//System.out.println("Line entered : " + line);
				line.replaceAll(" ", "");
				if (!line.equals("")) {
					if (this.stringToAppliane(line) != null) {
						allAppliances.add(this.stringToAppliane(line));
					}
				}
			}
		} catch (Exception exception) {
			System.out.println("exception");
			exception.printStackTrace();
		}
		return allAppliances;
	}

	private Appliance stringToAppliane(String line) {
		try {
			Appliance appliance = new Appliance();
			HashMap<String, Object> applParams = new HashMap<>();

			String[] firstSplit = line.replaceAll(" ", "").split(":");
			appliance.setTitle(firstSplit[0]);
			String paramsAsString = firstSplit[1];
			String[] secondSplit = paramsAsString.split(",");
			for (int i = 0; i < secondSplit.length; i++) {
				String keyValue = secondSplit[i];
				String[] thirdSplit = keyValue.split("=");
				applParams.put(thirdSplit[0], thirdSplit[1]);
			}

			appliance.setParams(applParams);
			return appliance;
		} catch (Exception e) {
			return null;
		}
	}

}

