package com.app;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

// Spring ko bol rahe ki ye bhi ek bean hai
@Component("eobj") // bean ka naam "eobj"
public class EmailConfig {

	// yaha values inject ho rahi hai
	@Value("gmail")
	private String host;

	@Value("852")
	private Integer port;

	@Override
	public String toString() {
		return "EmailConfig [host=" + host + ", port=" + port + "]";
	}
}