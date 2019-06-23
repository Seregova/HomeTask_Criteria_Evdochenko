package by.tc.task01.main;

import static by.tc.task01.entity.criteria.SearchCriteria.*;

import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.service.ApplianceService;
import by.tc.task01.service.ServiceFactory;
import sun.security.validator.ValidatorException;

import java.util.List;

public class Main {

	public static void main(String[] args) {
		List<Appliance> applianceList;

		ServiceFactory factory = ServiceFactory.getInstance();
		ApplianceService service = factory.getApplianceService();



		//////////////////////////////////////////////////////////////////

		Criteria criteriaOven = new Criteria(Oven.class.getSimpleName());//"Oven"
		criteriaOven.add(Oven.CAPACITY.toString(), 33);

		try {
			applianceList = service.find(criteriaOven);
			PrintApplianceInfo.print(applianceList);
		} catch (ValidatorException e) {
			e.printStackTrace();
		}

		//////////////////////////////////////////////////////////////////

		criteriaOven = new Criteria(Oven.class.getSimpleName());
		criteriaOven.add(Oven.HEIGHT.toString(), 45);
		criteriaOven.add(Oven.DEPTH.toString(), 60);

		System.out.println(criteriaOven);
		try {
			applianceList = service.find(criteriaOven);
			PrintApplianceInfo.print(applianceList);
		} catch (ValidatorException e) {
			e.printStackTrace();
		}


		//////////////////////////////////////////////////////////////////
		
		Criteria criteriaTabletPC = new Criteria(TabletPC.class.getSimpleName());
		criteriaTabletPC.add(TabletPC.COLOR.toString(), "BLUE");
		criteriaTabletPC.add(TabletPC.DISPLAY_INCHES.toString(), 14);
		criteriaTabletPC.add(TabletPC.MEMORY_ROM.toString(), 4);

		System.out.println(criteriaTabletPC);
		try {
			applianceList = service.find(criteriaTabletPC);// find(Object...obj)
			PrintApplianceInfo.print(applianceList);
		} catch (ValidatorException e) {
			e.printStackTrace();
		}
	}
}
