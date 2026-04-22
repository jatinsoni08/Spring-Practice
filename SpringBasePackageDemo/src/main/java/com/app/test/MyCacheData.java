package com.app.test;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

// @Component ka matlab: Spring is class ka object (bean) khud banayega
@Component("cob") // bean ka naam "cob"
public class MyCacheData {

	// @Value se direct value inject ho rahi hai
	@Value("redis")
	private String provider;

	// toString method output show karne ke liye
	@Override
	public String toString() {
		return "MyCacheData [provider=" + provider + "]";
	}
}