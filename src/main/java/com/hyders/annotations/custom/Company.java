package com.hyders.annotations.custom;


import java.lang.annotation.*;

@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Company {
    public String name() default  "Avanza Solutions";
    public String city() default "Karachi";
}
