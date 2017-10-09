package com.designpattern.builder;

import java.util.HashMap;
import java.util.Map;

public class BuilderEntity {

	private String first;
	private String second;
	private Map<String, Object> params = new HashMap<>();

	public BuilderEntity(String first, String second, Map<String, Object> params) {
		this.first = first;
		this.second = second;
		this.params = params;
	}

	public String getFirst() {
		return first;
	}

	public void setFirst(String first) {
		this.first = first;
	}

	public String getSecond() {
		return second;
	}

	public void setSecond(String second) {
		this.second = second;
	}

	public Map<String, Object> getParams() {
		return params;
	}

	public void setParams(Map<String, Object> params) {
		this.params = params;
	}

}
