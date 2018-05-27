package com.litara.test.resource;
import java.util.ResourceBundle;
public class MessageManager {
	private final static ResourceBundle resourceBundle = ResourceBundle.getBundle("com.litara.test.properties.messages");
	private MessageManager() { }
	public static String getProperty(String key) {
		return resourceBundle.getString(key);
	}
}
