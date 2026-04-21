package com.app.jatin;

public class Repository {
	private String entity;

	public String getEntity() {
		return entity;
	}

	public void setEntity(String entity) {
		this.entity = entity;
	}

	public Repository() {
		super();
	}

	@Override
	public String toString() {
		return "Repository [entity=" + entity + "]";
	}

}
