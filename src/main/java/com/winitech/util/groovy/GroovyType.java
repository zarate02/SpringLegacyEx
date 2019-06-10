package com.winitech.util.groovy;

/****************
그루비 호출 타입
*****************/
public enum GroovyType {
	JOB("job"),
	SECURITY("security"),
	WEB("web"),
	SERVICE("service");

    final private String name;
	
	private GroovyType(String name) {
        this.name = name;
    }
	
	String getName() {
        return name;
    }
}