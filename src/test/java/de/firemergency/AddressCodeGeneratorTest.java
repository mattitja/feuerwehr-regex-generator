package de.firemergency;

import de.alamos.fe2.external.ExtractorObject;
import de.alamos.fe2.external.enums.EAlarmDataEntries;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddressCodeGeneratorTest {

	private final String TEST_DATA_1 = "STICHWORT: FEU 00 \n"
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

	private final String TEST_DATA_2 = "STICHWORT: FEU 00 R1\n"
									   + "\n"
									   + "MELDEBILD: Zimmerbrand <3.OG\n"
									   + "\n"
									   + "INFO: 3 OG / 1 Person im Zimmer / Flur verraucht / Dr Jannek Abholen\n"
									   + "\n"
									   + "ORT: Aumühle (RZ)\n"
									   + "\n"
									   + "ORTSTEIL: Aumühle\n"
									   + "\n"
									   + "STRASSE: Mühlenweg 1\n"
									   + "\n"
									   + "EINSATZOBJEKT: Augustinum Seniorenresidenz\n"
									   + "\n"
									   + "BMA-NR: \n"
									   + "\n"
									   + "UNTEROBJEKT: \n"
									   + "\n"
									   + "SEGMENTINFO: \n"
									   + "\n"
									   + "LEISTUNGSNEHMER: Re OD 90-83-02 (0) \n"
									   + "\n"
									   + "KOORDINATEN: 53,52984477 10,31060530\n"
									   + "\n"
									   + "ALARMIERTE FAHRZEUGE: Re RZ 00-03-07,Fl RZ 13-47-01,Re OD 90-82-01,Re OD 90-83-01,Re OD 90-83-02,Re OD 91-83-01,LNA RD (RZ),OrgL RD (RZ),Re RZ 00-11-01,Am RZ 10-83-03,Rk RZ 10-82-01,Rk RZ 10-83-02,Pe RZ 20-12-01,Pe RZ 20-83-04,Rk RZ 30-83-02,Rk RZ 40-83-02,Fl RZ 00-01-01,Fl RZ 10-10-01,FF Kröppelshagen-Fahrendorf (RZ13),Fl RZ 13-48-01,FF Dassendorf (RZ14),Fl RZ 14-18-01,Fl RZ 14-47-01,Fl RZ 14-48-01,FF Wohltorf (RZ17),Fl RZ 17-22-01,Fl RZ 17-45-01,FF Wentorf bei Hamburg (RZ18),Fl RZ 18-11-01,Fl RZ 18-22-01,Fl RZ 18-32-01,Fl RZ 18-47-01,Fl RZ 18-48-01,FF Aumühle (RZ19),Fl RZ 19-42-01,Fl RZ 19-48-01,EL RD (RZ),SEG RZ R1 (RZ)\n"
									   + "\n"
									   + "WACHEN IM EINSATZ: DLRG Lauenburg (RZ20),DRK Büchen (RZ40),DRK Schwarzenbek (RZ30),FF Aumühle (RZ19),FF Dassendorf (RZ14),FF Geesthacht (RZ10.01),FF Kröppelshagen-Fahrendorf (RZ13),FF Wentorf bei Hamburg (RZ18),FF Wohltorf (RZ17),KFV Herzogtum Lauenburg (RZ),RW Geesthacht (RZ10.01),RW Geesthacht (RZ10.02),RW Kreis (RZ),RW Neuschönningstedt (OD91),RW Reinbek (OD90),SEG (RZ)\n"
									   + "\n"
									   + "ALARMIERTE RICS: 1714519-A,1723199-,1714576-A,1723196-,1713925-A,1713846-A,1713202-C,1685714-A,1714173-A,1723194-\n"
									   + "\n"
									   + "EINSATZNUMMER: 1191210159\n"
									   + "\n"
									   + "MELDEZEIT: 20191223151213\n"
									   + "\n"
									   + "SONDERRECHTE: ja\n";



	@Test
	public void test1() {
		// given
		Map<String, String> input = new HashMap<>();
		input.put(EAlarmDataEntries.TEXT.getKey(), TEST_DATA_1);
		AddressCodeGenerator addressCodeGenerator = new AddressCodeGenerator();

		// when
		ExtractorObject result = addressCodeGenerator.extractFromMap(input);

		// then
		System.out.println(result);

		Assert.assertEquals(18, result.getData().size());
	}

	@Test
	public void test2() {
		// given
		Map<String, String> input = new HashMap<>();
		input.put(EAlarmDataEntries.TEXT.getKey(), TEST_DATA_2);
		AddressCodeGenerator addressCodeGenerator = new AddressCodeGenerator();

		// when
		ExtractorObject result = addressCodeGenerator.extractFromMap(input);

		// then
		System.out.println(result);

		Assert.assertEquals(18, result.getData().size());
	}
}
