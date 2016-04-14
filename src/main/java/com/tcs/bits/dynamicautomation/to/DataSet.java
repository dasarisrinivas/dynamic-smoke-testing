package com.tcs.bits.dynamicautomation.to;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("dataset")
public class DataSet {

	private String id;
	private String expectedValue;
	private String objectType;
	private String objectName;
	private String objectValue;
	private String objectAction;
	private String objectIdentification;

	public String getObjectIdentification() {
		return objectIdentification;
	}

	public void setObjectIdentification(String objectIdentification) {
		this.objectIdentification = objectIdentification;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getExpectedvalue() {
		return expectedValue;
	}

	public void setexpectedValue(String tabOrder) {
		this.expectedValue = tabOrder;
	}

	public String getObjectType() {
		return objectType;
	}

	public void setObjectType(String objectType) {
		this.objectType = objectType;
	}

	public String getObjectName() {
		return objectName;
	}

	public void setObjectName(String objectName) {
		this.objectName = objectName;
	}

	public String getObjectValue() {
		return objectValue;
	}

	public void setObjectValue(String objectValue) {
		this.objectValue = objectValue;
	}

	public String getObjectAction() {
		return objectAction;
	}

	public void setObjectAction(String objectAction) {
		this.objectAction = objectAction;
	}

}
