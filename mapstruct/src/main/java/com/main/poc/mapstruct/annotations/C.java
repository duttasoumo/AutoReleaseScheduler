package com.main.poc.mapstruct.annotations;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.OverridesAttribute;
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@A(i = 0)
@B(j = 0)
public @interface C{

	
	@OverridesAttribute(constraint=A.class, name="i")
    int a();
	
	@OverridesAttribute(constraint=B.class, name="j")
    int b();
}
