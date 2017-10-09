package com.designpattern.builder;

import java.util.HashMap;
import java.util.Map;

public class Bulider {

	private BuilderEntity bulider;

	public Object builder() {
		return bulider;
	}
	public Bulider putParam(String key,Object object){
		Map<String, Object> map = new HashMap<>();
		map.put(key, object);
		bulider.setParams(map);
		return this;
	}
}
