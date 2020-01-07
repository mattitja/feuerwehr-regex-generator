package de.firemergency;


/*
 * Pattern Klartext: (.*):\s(.*)\s*\n*
 * https://regex101.com/
 * */

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddressCodeGenerator {
	public static Map<String, Object> getAddress(String input) {		
		
		Map<String, Object> data = new HashMap<String, Object>();
		
		Pattern pattern = Pattern.compile("(.*):\\s(.*)\\s*\\n*");
		Matcher m = pattern.matcher(input);
		
		while (m.find() && m.groupCount() == 2) {
			data.put("j_" + m.group(1).trim(), m.group(2).trim());
		}
		
		return data;
	}
}
