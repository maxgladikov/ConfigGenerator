package utils;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegEx {
	public static Boolean find(String patt,String match) {
		Pattern pattern = Pattern.compile(patt, Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(match);
		return matcher.find();
	}
	public static String getIP(String ipString) {
		String IPADDRESS_PATTERN = 
		        "(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)";

		Pattern pattern = Pattern.compile(IPADDRESS_PATTERN);
		Matcher matcher = pattern.matcher(ipString);
		if (matcher.find()) {
		    return matcher.group();
		} else{
		    return "0.0.0.0";
		}
	}

}
