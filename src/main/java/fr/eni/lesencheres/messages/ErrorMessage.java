package fr.eni.lesencheres.messages;

import java.util.Locale;
import java.util.ResourceBundle;

public class ErrorMessage {
	private static final ResourceBundle messages = ResourceBundle.getBundle("errorMessage", Locale.getDefault(), Thread.currentThread().getContextClassLoader());


    public static String getMessage(String errorCode) {
        return messages.getString(errorCode);
    }

}
