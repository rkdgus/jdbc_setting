package kr.or.dgit.jdbc_setting.jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

public class DBCon {
	private static final DBCon instance = new DBCon();
	private Connection connection;
	
	
	public static DBCon getInstance() {
		return instance;
	}
	
	private DBCon(){
		Properties properties = getProperties("conf.properties");
		System.out.println(properties.getProperty("user"));
		System.out.println(properties.getProperty("pwd"));
		System.out.println(properties.getProperty("url"));
	}
	
	private Properties getProperties(String propertiesPath) {
		Properties properties = new Properties();
		InputStream is = ClassLoader.getSystemResourceAsStream(propertiesPath);
		
		try {
			properties.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return properties;
	}

	public Connection getConnection() {
		return connection;
	}
	
	
}