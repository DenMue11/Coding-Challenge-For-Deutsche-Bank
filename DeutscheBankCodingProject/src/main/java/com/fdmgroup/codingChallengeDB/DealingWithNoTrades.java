package com.fdmgroup.codingChallengeDB;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import tech.tablesaw.api.Row;
import tech.tablesaw.api.Table;

public class DealingWithNoTrades {

	public Table addDaysOfNoTrade(Table table, String date) {
		Row row1 = table.appendRow();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate localDate = LocalDate.parse(date, formatter);
		row1.setDate(0, localDate);
		for (int i = 1; i <= 5; i++) {
			row1.setDouble(i, 0.0);
		}
		table = table.sortAscendingOn("Date_Time date");
		return table;
	}

}
