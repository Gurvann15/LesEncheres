package fr.eni.lesencheres.dal;

import java.io.IOException;
import java.util.Properties;

public class Settings {
	private static Properties properties;
	// La classe properties permet de gérer des paramètres de type clé/valeur

	// Bloc d'initialisation static
	static {
		properties = new Properties();
		try {
			properties.load(Settings.class.getResourceAsStream("settings.properties"));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	public static String getPropertiesUser(){
		return properties.getProperty("user");
	}

	public static String getPropertiesPass(){
		return properties.getProperty("pass");
	}

	public static String getPropertiesPath(){
		return properties.getProperty("path");
	}
	public static String getPropertiesDriver(){
		return properties.getProperty("driver");
	}
}
