package eu.nethazard.yt;
/**
 * @author mdPlusPlus
 * @since 2014-08-31
 */

import java.net.MalformedURLException;
import java.net.URL;

public class YTMediaUtil {
	
	public static String cleanTitle(String title){
		//TODO regex
		//TODO out-source to config

		//Clean regex: "^[a-zA-Z0-9Ä-Üä-ü\ß]+$"
		//Bad signs regex: "[^a-zA-Z0-9Ä-Üä-ü\ß]"
		
		String cleanTitle = title;
		
		// StringBuilder allowedCharsBuilder = new StringBuilder();
		// allowedCharsBuilder.append("0123456789");
		// allowedCharsBuilder.append("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
		// allowedCharsBuilder.append("abcdefghijklmnopqrstuvwxyz");
		// allowedCharsBuilder.append("ÄÖÜ");
		// allowedCharsBuilder.append("äöü");
		// allowedCharsBuilder.append("ß");
		// String allowedChars = allowedCharsBuilder.toString();
		
		// for(int i = 0; i < cleanTitle.length(); i++){
		// 	char currentChar = cleanTitle.charAt(i);
		// 	if(!allowedChars.contains(String.valueOf(currentChar))){
		// 		cleanTitle = cleanTitle.replace(currentChar, '_');
		// 	}
		// }

		cleanTitle.replace("[^a-zA-Z0-9Ä-Üä-ü\ß]", "_");

		if (!cleanTitle.matches("^[a-zA-Z0-9Ä-Üä-ü\ß]+$")) {
			//something bad happened
		}
		
		return cleanTitle;
	}
	
	public static boolean isYouTubeURL(String str){
		boolean result = false;
		
		boolean isValidURL = true;
		try {
			new URL(str);
		}
		catch (MalformedURLException e) {
			isValidURL = false;
		}
		
		if(isValidURL){ //TODO add embed-URLs
			if(	   str.startsWith("https://www.youtube.com/watch?v=")
				|| str.startsWith("http://www.youtube.com/watch?v=") 
				|| str.startsWith("www.youtube.com/watch?v=")
				|| str.startsWith("youtube.com/watch?v=")){
				result = true;
			}
		}
		
		return result;
	}
	
	public static String convertSeconds(int secs){
		return String.format(
			"%02d:%02d:%02d",
			secs / 3600,
			(secs % 3600) / 60,
			secs % 60);
	}
}
