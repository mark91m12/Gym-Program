package com.gym.program.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Parser {
	public static void main(String[] args) throws IOException {

		String csvFile = "file/records.csv";
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ";";

		try {

			br = new BufferedReader(new FileReader(csvFile));
			while ((line = br.readLine()) != null) {

				if (!line.matches("^\\s*$")) {
					String[] record = line.split(cvsSplitBy);

					System.out.println("RECORD [ SEX = " + record[2] + ", AGE = " + record[3] + " , WEIGHT="
							+ record[0] + " , VALUE=" + record[1] + " ]");
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
}
