package com.gym.program.utils;

import java.util.HashMap;
import java.util.Map;

import com.gym.program.logic.match.Match.TypeOfMatch;

public class RecordsDB {
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
		for (TypeOfMatch type : TypeOfMatch.values()) {
			for (Category age : Category.Male.Male_Age.values()) {

				for (Category weight : Category.Male.Male_Weight.values()) {
					records.put(new RecordKey(type, age, weight), 500.00);
					// System.out.println(new RecordKey(type, age) + "-->value:"
					// + records.get(new RecordKey(type, age)));
				}

			}
			for (Category age : Category.Female.Female_Age.values()) {

				for (Category weight : Category.Female.Female_Weight.values()) {
					records.put(new RecordKey(type, age, weight), 200.00);
					// System.out.println(
					// new RecordKey(type, weight) + "-->value:" +
					// records.get(new RecordKey(type, weight)));
				}
			}

		}
	}

	public Double getRecord(RecordKey key) {
		System.out.println(key + "-->value:" + records.get(key));
		return records.get(key);
	}

}
