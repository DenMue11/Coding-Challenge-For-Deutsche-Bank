package com.fdmgroup.codingChallengeDB;

import tech.tablesaw.api.Table;
import tech.tablesaw.io.csv.CsvReadOptions;

public class Reader {

	public Table createTableFromCsv(String file) {
		CsvReadOptions.Builder builder = CsvReadOptions.builder(file).separator(';').header(false)
				.missingValueIndicator("NA")/* .columnTypes(types) */;

		CsvReadOptions options = builder.build();

		Table t1 = Table.read().usingOptions(options);
		t1.column(0).setName("Date_Time");
		t1.column(1).setName("company ticker");
		t1.column(2).setName("price");
		t1.column(3).setName("number of securities traded");

		return t1;
	}

}
