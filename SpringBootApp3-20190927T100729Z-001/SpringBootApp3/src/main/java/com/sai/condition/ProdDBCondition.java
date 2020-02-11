package com.sai.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class ProdDBCondition implements Condition{
	
	@Override
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		String value=System.getProperty("enableDB");
	    if(value != null) {
	    	return value.equalsIgnoreCase("PROD");
	    } else {
	    	Environment environment = context.getEnvironment();
	    	String dbName = environment.getProperty("enableDB");
	    	if(dbName != null)
	         return dbName.equalsIgnoreCase("PROD");
	    	else
	    	 return false;
	    }
	}

}
