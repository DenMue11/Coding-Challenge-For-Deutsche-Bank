package com.fdmgroup.codingChallengeDB;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import tech.tablesaw.api.Table;

class ReaderTest {

	@Test
	void test_thatTheDatasetisCorrectlyReadAsATableWiththeCorrectRowCount() {
		String file = "C:\\Users\\Dennis Müller\\Documents\\FDM\\test-market.csv\\test-market2.csv";
		Reader csvReader = new Reader();

		Table t1 = csvReader.createTableFromCsv(file);
		int rowCountOfTable = t1.rowCount();
		assertEquals(104465, rowCountOfTable);
	}

	@Test
	void test_thatTheDatasetisCorrectlyReadAsATableWiththeCorrectColumnCount() {
		String file = "C:\\Users\\Dennis Müller\\Documents\\FDM\\test-market.csv\\test-market2.csv";
		Reader csvReader = new Reader();

		Table t1 = csvReader.createTableFromCsv(file);
		int columnCountOfTable = t1.columnCount();
		assertEquals(4, columnCountOfTable);
	}

}
