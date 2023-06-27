package com.fdmgroup.codingChallengeDB;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tech.tablesaw.api.DateTimeColumn;
import tech.tablesaw.api.DoubleColumn;
import tech.tablesaw.api.IntColumn;
import tech.tablesaw.api.StringColumn;
import tech.tablesaw.api.Table;

class AggregatesCalculatorTest {

	Table testtable1;

	@BeforeEach
	void setup() {
		LocalDateTime dateTime = LocalDateTime.parse("2018-05-05T11:50:55");
		LocalDateTime dateTime1 = LocalDateTime.parse("2018-05-05T12:50:55");
		LocalDateTime dateTime2 = LocalDateTime.parse("2018-05-06T11:50:55");
		LocalDateTime dateTime3 = LocalDateTime.parse("2018-05-06T15:50:55");
		List<LocalDateTime> dates = new ArrayList<>();
		dates.add(dateTime);
		dates.add(dateTime1);
		dates.add(dateTime2);
		dates.add(dateTime3);

		ArrayList<String> tickers = new ArrayList<>();
		tickers.add("NGL");
		tickers.add("NGL");
		tickers.add("TRX");
		tickers.add("TRX");

		double[] doubles = { 6.80, 4.70, 3.50, 2.10 };
		int[] ints1 = { 16, 4, 8, 7 };

		testtable1 = Table.create("testtable").addColumns(DateTimeColumn.create("date", dates),
				StringColumn.create("company ticker", tickers), DoubleColumn.create("price", doubles),
				IntColumn.create("number of securities traded", ints1));
		System.out.println(testtable1.rowCount());
	}

	@Test
	void test_calculateDailyAggregatesReturnsFirstPriceInSecondColumn() {
		AggregatesCalculator aggregateCalculator = new AggregatesCalculator();
		Table aggregatetable = aggregateCalculator.calculateDailyAggregates(testtable1);
		double firstPriceNGL = aggregatetable.doubleColumn(1).getDouble(0);
		assertEquals(6.80, firstPriceNGL);

	}

	@Test
	void test_calculateDailyAggregatesReturnsdailyMaxPriceInThirdColumn() {
		AggregatesCalculator aggregateCalculator = new AggregatesCalculator();
		Table aggregatetable = aggregateCalculator.calculateDailyAggregates(testtable1);
		double maxPriceNGL = aggregatetable.doubleColumn(2).getDouble(0);
		assertEquals(6.80, maxPriceNGL);

	}

	@Test
	void test_calculateDailyAggregatesReturnsdailyMinPriceInFourthColumn() {
		AggregatesCalculator aggregateCalculator = new AggregatesCalculator();
		Table aggregatetable = aggregateCalculator.calculateDailyAggregates(testtable1);
		double minPriceNGL = aggregatetable.doubleColumn(3).getDouble(0);
		assertEquals(4.7, minPriceNGL);
	}

	@Test
	void test_calculateDailyAggregatesReturnsdailyLastPriceInFourthColumn() {
		AggregatesCalculator aggregateCalculator = new AggregatesCalculator();
		Table aggregatetable = aggregateCalculator.calculateDailyAggregates(testtable1);
		double lastPriceNGL = aggregatetable.doubleColumn(4).getDouble(0);
		assertEquals(4.7, lastPriceNGL);
	}

	@Test
	void test_calculateDailyAggregatesReturnsdailyTradedVolumeInFifthColumn() {
		AggregatesCalculator aggregateCalculator = new AggregatesCalculator();
		Table aggregatetable = aggregateCalculator.calculateDailyAggregates(testtable1);
		double lastPriceNGL = aggregatetable.doubleColumn(5).getDouble(0);
		assertEquals(230.0, lastPriceNGL);
	}

	@Test
	void test_calculateDailyAggregatesReturnsdailyMaxValueofJustTheTRXTicker() {
		AggregatesCalculator aggregateCalculator = new AggregatesCalculator();
		Table TRXaggregatetable = aggregateCalculator.calculateDailyAggregates(testtable1, "TRX");
		double maxPriceTRX = TRXaggregatetable.doubleColumn(2).getDouble(0);
		assertEquals(3.5, maxPriceTRX);
	}

	@Test
	void test_calculateDailyAggregatesReturnsdailyFirstPriceOfJustTheTRXTicker() {
		AggregatesCalculator aggregateCalculator = new AggregatesCalculator();
		Table aggregatetable = aggregateCalculator.calculateDailyAggregates(testtable1, "TRX");
		double firstPriceTRX = aggregatetable.doubleColumn(1).getDouble(0);
		assertEquals(3.5, firstPriceTRX);
	}

	@Test
	void test_calculateDailyAggregatesReturnsdailyMinPriceOfJustTheTRXTicker() {
		AggregatesCalculator aggregateCalculator = new AggregatesCalculator();
		Table aggregatetable = aggregateCalculator.calculateDailyAggregates(testtable1, "TRX");
		double minPriceTRX = aggregatetable.doubleColumn(3).getDouble(0);
		assertEquals(2.1, minPriceTRX);
	}

	@Test
	void test_calculateDailyAggregatesReturnsdailyLastPriceOfJustTheTRXTicker() {
		AggregatesCalculator aggregateCalculator = new AggregatesCalculator();
		Table aggregatetable = aggregateCalculator.calculateDailyAggregates(testtable1, "TRX");
		double lastPriceTRX = aggregatetable.doubleColumn(4).getDouble(0);
		assertEquals(2.1, lastPriceTRX);
	}

	@Test
	void test_calculateDailyAggregatesReturnsdailyTradedVolumeOfJustTheTRXTicker() {
		AggregatesCalculator aggregateCalculator = new AggregatesCalculator();
		Table aggregatetable = aggregateCalculator.calculateDailyAggregates(testtable1, "TRX");
		double dailyTradedVolumeTRX = aggregatetable.doubleColumn(5).getDouble(0);
		assertEquals(84.0, dailyTradedVolumeTRX);
	}

}
