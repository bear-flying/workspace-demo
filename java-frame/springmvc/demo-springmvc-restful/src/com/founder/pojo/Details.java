package com.founder.pojo;

import java.util.Arrays;

public class Details {
	Record[] record;
	
	
	
	@Override
	public String toString() {
		return "Details [record=" + Arrays.toString(record) + "]";
	}

	public Record[] getRecord() {
		return record;
	}

	public void setRecord(Record[] record) {
		this.record = record;
	}
	
	
}
