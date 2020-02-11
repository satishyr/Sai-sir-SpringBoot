package com.sai.custom.conditional;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import org.springframework.context.annotation.Conditional;

import com.sai.condition.MyDatabaseCondition;

@Retention(RUNTIME)
@Target(METHOD)
@Conditional(MyDatabaseCondition.class)
public @interface DBCondition {
     String dbType();
}
