package de.firemergency;

import java.util.ArrayList;
import java.util.Map;

import org.junit.Test;

public class AddressCodeGeneratorTest {
	
	@Test
	public void test() {
		String test1 = "10:27 28.06.1505AEinsatzalarm -16355H/Hilfelstg./Amtshilfe) 10:27/Trittau:(Osterkamp)/Lütjenseer Straße(1)//Keller 30 cm unter Wasser";
		String test2 = "17:08 28.07.1514ATest Einheit -17762B/BMA Alarm) 17:08/Reinbek:ETH Entsorgungs-Managemen()/Carl-Zeiss-Straße(12 -14)//";
		String test3 = "00:07 22.07.15 7AEinsatzalarm -94818P/Partyalarm - groß) 00:08/Aumühle:(Joe)/Fasanenweg(7)//Juhu Goggo - die Adresserkennung funktioniert!!!";
		String test4 = "19:00 01.01.1530DProbealarm -94818P/Di.19:00) 19:00/Bad Oldesloe:IRLS()/Mommsenstraße(13)//regelmäßige Geräteprüfung";
		String test5 = "23:51 30.08.1507AEinsatzalarm -18793H/Gasgeruch) 23:51/Aumühle:DHH(Name)/Auf der Koppel(44)//Text steht hier";
		
		ArrayList<String> testCases = new ArrayList<String>();
		testCases.add(test1);
		testCases.add(test2);
		testCases.add(test3);
		testCases.add(test4);
		testCases.add(test5);
		
		for (String test : testCases) {
			Map<String, Object> data = AddressCodeGenerator.getAddress(test);
			System.out.println(data.toString());			
		}		
	}
}
