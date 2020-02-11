package com.sai.conditions;

import java.util.Map;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class MyDatabaseCondition implements Condition{

	@Override
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		Environment env = context.getEnvironment();
		String enableDB = env.getProperty("enableDB");
		if(enableDB != null) {
			Map<String,Object> map=metadata.getAnnotationAttributes("com.sai.annotations.DatabaseCondition");
		    String value=(String)map.get("dbName");
		    return enableDB.equalsIgnoreCase(value);
		}else {
			return false;
		}
	}

}
