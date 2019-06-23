package by.tc.task01.entity.criteria;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Criteria {

	private String groupSearchName;

	public Map<String, Object> getCriteria() {
		return criteria;
	}

	private Map<String, Object> criteria = new HashMap<String, Object>();

	public Criteria(String groupSearchName) {
		this.groupSearchName = groupSearchName;
	}
	
	public String getGroupSearchName() {
		return groupSearchName;
	}

	public void add(String searchCriteria, Object value) {
		criteria.put(searchCriteria, value);
	}

	@Override
	public String toString(){
		String map = "";
		Set<String> keys = this.criteria.keySet();
		for (String key: keys) {
			map = map + " " + key + ":" + this.criteria.get(key);
		}
		return "Criteria name: " + this.groupSearchName + map;
	}

}
