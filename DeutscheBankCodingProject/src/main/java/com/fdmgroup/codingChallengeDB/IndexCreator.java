package com.fdmgroup.codingChallengeDB;

import tech.tablesaw.api.Table;

public class IndexCreator {

	public double[] createIndexDoubleArray(int columnIndex, Table table1, Table table2, Table table3, Table table4) {
		double[] indexDoubleArray = new double[7];
		for (int i = 0; i <= 6; i++) {
			if (i == 1) {
				indexDoubleArray[i] = (table1.doubleColumn(columnIndex).getDouble(i) * 0.1)
						+ (table2.doubleColumn(columnIndex).getDouble(i) * 0.3)
						+ (table3.doubleColumn(columnIndex).getDouble(i - 1) * 0.2)
						+ (table4.doubleColumn(columnIndex).getDouble(i - 1) * 0.4);
			} else if (i > 1 && i < 6) {
				indexDoubleArray[i] = (table1.doubleColumn(columnIndex).getDouble(i) * 0.1)
						+ (table2.doubleColumn(columnIndex).getDouble(i) * 0.3)
						+ (table3.doubleColumn(columnIndex).getDouble(i) * 0.2)
						+ (table4.doubleColumn(columnIndex).getDouble(i) * 0.4);
			} else if (i == 6) {
				indexDoubleArray[i] = (table1.doubleColumn(columnIndex).getDouble(i) * 0.1)
						+ (table2.doubleColumn(columnIndex).getDouble(i) * 0.3)
						+ (table3.doubleColumn(columnIndex).getDouble(i - 1) * 0.2)
						+ (table4.doubleColumn(columnIndex).getDouble(i) * 0.4);
			} else {
				indexDoubleArray[i] = (table1.doubleColumn(columnIndex).getDouble(i) * 0.1)
						+ (table2.doubleColumn(columnIndex).getDouble(i) * 0.3)
						+ (table3.doubleColumn(columnIndex).getDouble(i) * 0.2)
						+ (table4.doubleColumn(columnIndex).getDouble(i) * 0.4);
			}
		}
		return indexDoubleArray;
	}

}
