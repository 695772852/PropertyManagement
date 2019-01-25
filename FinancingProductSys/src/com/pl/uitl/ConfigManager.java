package com.pl.uitl;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class  ConfigManager{
	private static ConfigManager configManager;
	private Properties properties ;
	
	private  ConfigManager() {
		String db="db.properties";
		InputStream in = ConfigManager.class.getClassLoader().getResourceAsStream(db);
		properties = new Properties();
		try {
			properties.load(in);
			in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static  ConfigManager getIntance() {
		
		if(configManager==null)
		{
			 configManager = new ConfigManager();
		}
		
		return configManager;
		
	}
	
	public String getProperties(String key) {
		
		
		return properties.getProperty(key);
		
	}

}
