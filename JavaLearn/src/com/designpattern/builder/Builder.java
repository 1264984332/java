package com.designpattern.builder;

import java.util.HashMap;
import java.util.Map;

public class Builder {

	private static BuilderEntity buliderEntity = new BuilderEntity();

	public BuilderEntity builder() {
		return buliderEntity;
	}

	public Builder putParam(String key, Object object) {
		Map<String, Object> map = new HashMap<>();
		map.put(key, object);
		buliderEntity.setParams(map);
		return this;
	}
	public Builder putFirst(String first){
		buliderEntity.setFirst(first);
		return this;
	}
	public Builder putSecond(String second){
		buliderEntity.setSecond(second);
		return this;
	}
	public static Builder instanceBulider() {
		return new Builder();
	}
}
