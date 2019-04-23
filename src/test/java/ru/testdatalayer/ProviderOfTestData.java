package ru.testdatalayer;

import java.io.IOException;
import java.util.List;

import org.apache.commons.csv.CSVRecord;

import ru.utility.ParseCsv;

public class ProviderOfTestData {
	protected String MAIL_ADDRESS = "seleniumtest00@mail.ru";
	protected String[] FIRST_LETTER = { MAIL_ADDRESS, "one", "oneoneone" };
	protected String[] SECOND_LETTER = { MAIL_ADDRESS, "two", "twotwotwo" };
	protected String[] THIRD_LETTER = { MAIL_ADDRESS, "three", "threethreethree" };

	public Object[][] getTestDataFromCSV() throws IOException {
		ParseCsv dataFromCSV = new ParseCsv();
		List<CSVRecord> rec = dataFromCSV.parseFromCSV();
		int size = rec.size() - 1;
		int columnCount = rec.get(0).get(0).split(";").length;
		Object[][] messages = new Object[size][columnCount];
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < columnCount; j++) {
				messages[i][j] = rec.get(i + 1).get(0).split(";")[j];
//				System.out.print(messages[i][j] + "\t");
			}
//			System.out.println();
		}
		return messages;
	}

	public Object[][] getTestDataFromHere() {
		return new Object[][] { { FIRST_LETTER, SECOND_LETTER, THIRD_LETTER } };
	}

}
