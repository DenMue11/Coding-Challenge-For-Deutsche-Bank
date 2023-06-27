package com.fdmgroup.codingChallengeDB;

import static tech.tablesaw.aggregate.AggregateFunctions.first;
import static tech.tablesaw.aggregate.AggregateFunctions.last;
import static tech.tablesaw.aggregate.AggregateFunctions.max;
import static tech.tablesaw.aggregate.AggregateFunctions.min;
import static tech.tablesaw.aggregate.AggregateFunctions.sum;

import tech.tablesaw.api.DoubleColumn;
import tech.tablesaw.api.Table;

public class AggregatesCalculator {

	public Table calculateDailyAggregates(Table table) {
		Table aggregateValuesTable = table.summarize("price", first, max, min, sum, last)
				.by(table.dateTimeColumn(0).date());
		Table dailySumOfTrades = table.summarize("number of securities traded", sum).by(table.dateTimeColumn(0).date());
		DoubleColumn sumOfPrice = aggregateValuesTable.doubleColumn(4);
		DoubleColumn sumOfTrades = dailySumOfTrades.doubleColumn(1);
		DoubleColumn dailyTradedVolumeAllTicker = sumOfPrice.multiply(sumOfTrades);
		aggregateValuesTable.addColumns(dailyTradedVolumeAllTicker);
		aggregateValuesTable.column(6).setName("daily traded volume");
		aggregateValuesTable.removeColumns(4);
		return aggregateValuesTable;
	}

	public Table calculateDailyAggregates(Table table, String ticker) {
		Table tickerTable = table.where(table.stringColumn(1).isEqualTo(ticker));
		tickerTable.setName(ticker);
		Table aggregateValuesTable = tickerTable.summarize("price", first, max, min, sum, last)
				.by(tickerTable.dateTimeColumn(0).date());
		Table dailySumOfTrades = tickerTable.summarize("number of securities traded", sum)
				.by(tickerTable.dateTimeColumn(0).date());
		DoubleColumn sumOfPrice = aggregateValuesTable.doubleColumn(4);
		DoubleColumn sumOfTrades = dailySumOfTrades.doubleColumn(1);
		DoubleColumn dailyTradedVolumeAllTicker = sumOfPrice.multiply(sumOfTrades);
		aggregateValuesTable.addColumns(dailyTradedVolumeAllTicker);
		aggregateValuesTable.column(6).setName("daily traded volume");
		aggregateValuesTable.removeColumns(4);
		aggregateValuesTable.setName("Table of daily aggregates of " + ticker + " ticker");
		return aggregateValuesTable;
	}

}
