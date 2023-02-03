package de.firemergency;


/*
 * Pattern Klartext: (.*):\s(.*)\s*\n*
 * https://regex101.com/
 * */

import de.alamos.fe2.external.ExtractorObject;
import de.alamos.fe2.external.enums.EAlarmDataEntries;
import de.alamos.splitting.api.AbstractAlarmExtractorV2;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddressCodeGenerator extends AbstractAlarmExtractorV2 {
	public ExtractorObject extractFromMap(Map<String, String> map) {
		var message = map.get(EAlarmDataEntries.TEXT.getKey());
		var convertedData = convert(message);
		ExtractorObject extractorObject = new ExtractorObject();
		extractorObject.setData(convertedData);
		extractorObject.setComplete(true);
		return extractorObject;
	}

	private static Map<String, String> convert(String message) {
		Map<String, String> data = new HashMap<>();

		Pattern pattern = Pattern.compile("(.*):\\s(.*)\\s*\\n*");
		Matcher m = pattern.matcher(message);

		while (m.find() && m.groupCount() == 2) {
			data.put("j_" + m.group(1).trim(), m.group(2).trim());
		}

		return data;
	}
}
