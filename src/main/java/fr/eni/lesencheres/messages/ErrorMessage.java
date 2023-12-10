package fr.eni.lesencheres.messages;

import java.util.ResourceBundle;

public class ErrorMessage {
	private static final ResourceBundle messages = ResourceBundle.getBundle("error-message.properties");

    public static String getMessage(String errorCode) {
        return messages.getString(errorCode);
    }

}
