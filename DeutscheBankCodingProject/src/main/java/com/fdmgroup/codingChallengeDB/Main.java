package com.fdmgroup.codingChallengeDB;

import tech.tablesaw.api.DateColumn;
import tech.tablesaw.api.DoubleColumn;
import tech.tablesaw.api.Table;

public class Main {

	public static void main(String[] args) {
		// reading the csv file and creating a table of it
		String file = "C:\\Users\\Dennis Müller\\Documents\\FDM\\test-market.csv\\test-market2.csv";
		Reader csvReader = new Reader();

		Table t1 = csvReader.createTableFromCsv(file);

		// System.out.println(t1);

		// calculating the daily aggregate values (of every ticker)
		AggregatesCalculator aggregateCalculator = new AggregatesCalculator();
		Table dailyAggregatesOfAllTicker = aggregateCalculator.calculateDailyAggregates(t1);
		dailyAggregatesOfAllTicker.setName("Table of daily aggregates of all tickers");
		System.out.println(dailyAggregatesOfAllTicker);

		// calculating the daily aggregate value of the NGL ticker
		Table dailyAggregatesOfNGLTicker = aggregateCalculator.calculateDailyAggregates(t1, "NGL");

		// adding days were no trades happened
		DealingWithNoTrades handleNoTrades = new DealingWithNoTrades();
		dailyAggregatesOfNGLTicker = handleNoTrades.addDaysOfNoTrade(dailyAggregatesOfNGLTicker, "2023-06-02");
		System.out.println(dailyAggregatesOfNGLTicker);

		// calculating the daily aggregate value of the TRX ticker
		Table dailyAggregatesOfTRXTicker = aggregateCalculator.calculateDailyAggregates(t1, "TRX");
		// adding days were no trades happened
		dailyAggregatesOfTRXTicker = handleNoTrades.addDaysOfNoTrade(dailyAggregatesOfTRXTicker, "2023-06-02");
		dailyAggregatesOfTRXTicker = handleNoTrades.addDaysOfNoTrade(dailyAggregatesOfTRXTicker, "2023-06-09");
		System.out.println(dailyAggregatesOfTRXTicker);

		// calculating the daily aggregate value of the MEGA ticker
		Table dailyAggregatesOfMEGATicker = aggregateCalculator.calculateDailyAggregates(t1, "MEGA");
		System.out.println(dailyAggregatesOfMEGATicker);

		// calculating the daily aggregate value of the ABC ticker
		Table dailyAggregatesOfABCTicker = aggregateCalculator.calculateDailyAggregates(t1, "ABC");
		System.out.println(dailyAggregatesOfABCTicker);

		// creating the index Table
		// first creating index double arrays that will be used to create the columns
		IndexCreator indexCreator = new IndexCreator();

		double[] indexFirstPrice = indexCreator.createIndexDoubleArray(1, dailyAggregatesOfABCTicker,
				dailyAggregatesOfMEGATicker, dailyAggregatesOfTRXTicker, dailyAggregatesOfNGLTicker);

		double[] indexMaxPrice = indexCreator.createIndexDoubleArray(2, dailyAggregatesOfABCTicker,
				dailyAggregatesOfMEGATicker, dailyAggregatesOfTRXTicker, dailyAggregatesOfNGLTicker);

		double[] indexMinPrice = indexCreator.createIndexDoubleArray(3, dailyAggregatesOfABCTicker,
				dailyAggregatesOfMEGATicker, dailyAggregatesOfTRXTicker, dailyAggregatesOfNGLTicker);

		double[] indexLastPrice = indexCreator.createIndexDoubleArray(4, dailyAggregatesOfABCTicker,
				dailyAggregatesOfMEGATicker, dailyAggregatesOfTRXTicker, dailyAggregatesOfNGLTicker);

		double[] indexDailyTradedVolume = indexCreator.createIndexDoubleArray(5, dailyAggregatesOfABCTicker,
				dailyAggregatesOfMEGATicker, dailyAggregatesOfTRXTicker, dailyAggregatesOfNGLTicker);

		DateColumn indexDateColumn = dailyAggregatesOfAllTicker.dateColumn(0);
		
		//Creating the INDEX Table of the calculated double-arrays
		Table indexTable = Table.create("INDEX").addColumns(indexDateColumn,
				DoubleColumn.create("first price", indexFirstPrice), DoubleColumn.create("max price", indexMaxPrice),
				DoubleColumn.create("min price", indexMinPrice), DoubleColumn.create("last price", indexLastPrice),
				DoubleColumn.create("daily traded volume", indexDailyTradedVolume));
		System.out.println(indexTable);

	}

}
