package com.sai.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class UATDBCondition implements Condition{

	@Override
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		String value=System.getProperty("enableDB");
	    if(value != null) {
	    	return value.equalsIgnoreCase("UAT");
	    } else {
	    	Environment environment = context.getEnvironment();
	    	String dbName = environment.getProperty("enableDB");
	    	if(dbName != null)
	         return dbName.equalsIgnoreCase("UAT");
	    	else
	    	 return false;
	    }
	}

}
