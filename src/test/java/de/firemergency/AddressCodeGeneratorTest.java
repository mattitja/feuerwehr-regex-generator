package de.firemergency;

import de.firemergency.AddressCodeGenerator;
import org.junit.Assert;
import org.junit.Test;

import java.util.Map;

public class AddressCodeGeneratorTest {

	@Test
	public void test1() {
		String testData = "STICHWORT: FEU 00 \n"
						  + "\n"
						  + " \n"
						  + "\n"
						  + "MELDEBILD: Wohnungsbrand MFH\n"
						  + "\n"
						  + " \n"
						  + "\n"
						  + "INFO1: Hier steht der Infotext\n"
						  + "\n"
						  + " \n"
						  + "\n"
						  + "INFO2:  \n"
						  + "\n"
						  + " \n"
						  + "\n"
						  + "ORT: Ahrensburg (OD)\n"
						  + "\n"
						  + " \n"
						  + "\n"
						  + "ORTSTEIL: Ahrensburg\n"
						  + "\n"
						  + " \n"
						  + "\n"
						  + "STRASSE: Am Weinberg 2\n"
						  + "\n"
						  + " \n"
						  + "\n"
						  + "EINSATZOBJEKT: FF Ahrensburg (OD60.01)\n"
						  + "\n"
						  + " \n"
						  + "\n"
						  + "BMA-NR: 625\n"
						  + "\n"
						  + " \n"
						  + "\n"
						  + "UNTEROBJEKT: \n"
						  + "\n"
						  + " \n"
						  + "\n"
						  + "SEGMENTINFO: \n"
						  + "\n"
						  + " \n"
						  + "\n"
						  + "KOORDINATEN: 53,67916040 10,24439916\n"
						  + "\n"
						  + " \n"
						  + "\n"
						  + "ALARMIERTE FAHRZEUGE: Fl OD 00-01-01,FF Ahrensburg (OD60),Fl OD 60-25-01,Fl OD 60-32-01,Fl OD 60-43-01,Fl OD 60-47-01,Fl OD 60-48-01,Fl OD 60-51-01,Fl OD 60-57-01,Fl OD 60-65-01,FF Wulfsdorf (OD61),Fl OD 61-45-01,FF Ahrensfelde (OD62),Fl OD 62-45-01\n"
						  + "\n"
						  + " \n"
						  + "\n"
						  + "WACHEN IM EINSATZ: FF Ahrensburg (OD60),FF Ahrensfelde (OD62),FF Wulfsdorf (OD61),KFV Stormarn (OD)\n"
						  + "\n"
						  + " \n"
						  + "\n"
						  + "ALARMIERTE RICS: XXXXX-A\n"
						  + "\n"
						  + " \n"
						  + "\n"
						  + "UNTERADRESSE: A\n"
						  + "\n"
						  + " \n"
						  + "\n"
						  + "EINSATZNUMMER: 1190606234\n"
						  + "\n"
						  + " \n"
						  + "\n"
						  + "SONDERRECHTE: ja";

		Map<String, Object> data = AddressCodeGenerator.getAddress(testData);
		System.out.println(data.toString());

		Assert.assertEquals(18, data.size());
	}
}
