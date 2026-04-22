package com.app;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {

	public static void main(String[] args) {

		// Spring container create ho raha hai
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(MyAppConfig.class);

		// Agar @ComponentScan nahi hota to hume manually scan karna padta:
		// ac.scan("com.app");
		// ac.refresh();

		// Bean ko naam se fetch kar rahe hain
		 Object obj1 = ac.getBean("cob"); // MyCacheData
		 Object obj2 = ac.getBean("eobj"); // EmailConfig

		// Ye third bean hai (FormatService)
		Object obj3 = ac.getBean("formatService");

		// Output print
		System.out.println(obj1);
		System.out.println(obj2);
		System.out.println(obj3);

		// Real-time me:
		// alag config class banate hain
		// aur @ComponentScan waha use karte hain
		// tab scan() aur refresh() ki zaroorat nahi padti

		// Ek time pe multiple objects print kar sakte ho — koi issue nahi
	}
}