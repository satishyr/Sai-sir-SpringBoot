package com.sai.condition;

import java.util.Map;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;


@ConditionalOnClass
public class MyDatabaseCondition implements Condition{

	@Override
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		String givenDB=context.getEnvironment().getProperty("dbEnv");
		if(givenDB != null) {
        Map<String,Object> map=metadata.getAnnotationAttributes("com.sai.custom.conditional.DBCondition");	
        String actualDB=(String)map.get("dbType");
        return givenDB.equalsIgnoreCase(actualDB);
		}else {
			return false;
		}
	}

}
