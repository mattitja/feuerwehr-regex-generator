package de.firemergency;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * Pattern Klartext: (\d{2}:\d{2})\s(\d{2}\.\d{2}\.\d{2})(.{3})(.*)\s-(\d{5})([A-Z])\/(.*)\)\s(\d{2}:\d{2})\/(.*):(.*)\((.*)\)\/(.*)\s*\((.*)\)\/{2}(.*)
 * https://regex101.com/
 * */

public class AddressCodeGenerator {
	public static Map<String, Object> getAddress(String input) {		
		
		Map<String, Object> data = new HashMap<String, Object>();
		
		Pattern pattern = Pattern.compile("(\\d{2}:\\d{2})\\s(\\d{2}\\.\\d{2}\\.\\d{2})(.{3})(.*)\\s-(\\d{5})([A-Z])\\/(.*)\\)\\s(\\d{2}:\\d{2})\\/(.*):(.*)\\((.*)\\)\\/(.*)\\s*\\((.*)\\)\\/{2}(.*)");
		Matcher m = pattern.matcher(input);		
		
		if (m.find()) {			
			String alarmzeit = m.group(1);
			String alarmdatum = m.group(2);
			String ric = m.group(3);
			String alarmtyp = m.group(4);
			String einsatznummer = m.group(5);
			String einsatzkuerzel = m.group(6);
			String keyword = m.group(7);
			String einsatzzeit = m.group(8);
			String city = m.group(9);
			String building = m.group(10);
			String anrufer = m.group(11);
			String street = m.group(12);
			String house = m.group(13);
			String alarmtext = m.group(14);	
			String locationDest = street + " " + house + ", " + city; 			
		
			data.put("alarmzeit", alarmzeit);
			data.put("alarmdatum", alarmdatum);
			data.put("ric", ric);
			data.put("alarmtyp", alarmtyp);
			data.put("einsatznummer", einsatznummer);
			data.put("einsatzkuerzel", einsatzkuerzel);
			data.put("keyword", keyword);
			data.put("einsatzzeit", einsatzzeit);
			data.put("city", city);
			data.put("building", building);
			data.put("anrufer", anrufer);
			data.put("street", street);
			data.put("house", house);
			data.put("alarmtext", alarmtext);
			data.put("location_dest", locationDest);		  
		}
		
		return data;
	}
	
}
