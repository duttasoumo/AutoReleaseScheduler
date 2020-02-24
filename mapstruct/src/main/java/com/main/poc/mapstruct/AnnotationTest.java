package com.main.poc.mapstruct;

import java.lang.annotation.Annotation;

import com.main.poc.mapstruct.annotations.A;
import com.main.poc.mapstruct.annotations.C;
@C(a = 6, b = 9)
public class AnnotationTest {

	public static void main(String[] args) {
		AnnotationTest t = new AnnotationTest();
		Annotation[] annotations = t.getClass().getAnnotations();
		System.out.println(annotations);
		C annotation = t.getClass().getAnnotation(C.class);
		System.out.println("\nC: "+annotation.a()+annotation.b());
		A annotationA = t.getClass().getAnnotation(A.class);
		System.out.println("\nA: "+annotationA.i());
//		System.out.println(annotationsByType.a() + "   " + annotationsByType.b());
//		
//		A bla = t.getClass().getAnnotationsByType(A.class)[0];
//		System.out.println(bla.i() );
	}

}
