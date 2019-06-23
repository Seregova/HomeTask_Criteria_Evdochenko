package by.tc.task01.entity;

import java.util.Map;
import java.util.Set;

public class Appliance {
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Map<String, Object> getParams() {
        return params;
    }

    public void setParams(Map<String, Object> params) {
        this.params = params;
    }

    private Map<String, Object> params;

    @Override
    public String toString(){
        String map = "";
        try {
            Set<String> keys = this.params.keySet();
            for (String key: keys) {
                map = map + " " + key + ":" + this.params.get(key);
            }
        } catch (Exception e) {
        }

        return "Appliance name: " + this.title + " ;Params: " + map;
    }
}
