package ru.utility;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class ParseCsv {


	public List<CSVRecord> parseFromCSV() throws IOException {
		String csv = "TestData.csv";
		CSVParser parser = new CSVParser(new FileReader(csv), CSVFormat.RFC4180);
		return parser.getRecords();

	}
}
