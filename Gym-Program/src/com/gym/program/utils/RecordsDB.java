package com.gym.program.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.gym.program.logic.match.Match.TypeOfMatch;

public class RecordsDB {

	private final int AGE = 0;
	private final int WEIGHT = 1;

	private Map<RecordKey, Double> records;

	private static RecordsDB instance = null;

	public static RecordsDB getInstance() {
		if (instance == null) {
			instance = new RecordsDB();
		}

		return instance;
	}

	private RecordsDB() {
		super();
		records = new HashMap<>();
		initRecords();
	}

	private void initRecords() {

		String csvFile = "file/records.csv";
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ";";

		try {

			br = new BufferedReader(new FileReader(csvFile));
			while ((line = br.readLine()) != null) {

				if (!line.matches("^\\s*$")) {
					String[] record = line.split(cvsSplitBy);

					Sex sex = Sex.valueOf(record[2]);
					records.put(new RecordKey(TypeOfMatch.valueOf(record[4]), sex,
							this.getCategory(record[3], sex, this.AGE), this.getCategory(record[0], sex, this.WEIGHT)),
							Double.parseDouble(record[1]));

				}

			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

	public Double getRecord(RecordKey key) {
		System.out.println(key + "-->value:" + records.get(key));
		return records.get(key);
	}

	private Category getCategory(String string, Sex sex, int type) {

		Category category = null;

		switch (sex) {
		case MALE:
			if (type == this.AGE)
				category = Category.Male.Male_Age.valueOf(string);
			else
				category = Category.Male.Male_Weight.valueOf(string);
			break;
		case FEMALE:
			if (type == this.AGE)
				category = Category.Female.Female_Age.valueOf(string);
			else
				category = Category.Female.Female_Weight.valueOf(string);
			break;
		default:
			break;
		}

		return category;
	}

}
