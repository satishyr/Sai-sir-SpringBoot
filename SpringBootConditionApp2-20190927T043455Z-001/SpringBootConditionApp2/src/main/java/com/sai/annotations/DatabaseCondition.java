package com.sai.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.context.annotation.Conditional;

import com.sai.conditions.MyDatabaseCondition;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Conditional(value=MyDatabaseCondition.class)
public @interface DatabaseCondition {
      String dbName();
}
