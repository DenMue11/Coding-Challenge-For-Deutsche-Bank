package com.fdmgroup.codingChallengeDB;

import tech.tablesaw.api.Table;

public class IndexCreator {
	
	private double weightTRX = 0.2;
	private double weightNGL= 0.4;
	private double weightMEGA= 0.3;
	private double weightABC= 0.1;

	public double[] createIndexDoubleArray(int columnIndex, Table table1, Table table2, Table table3, Table table4) {
		double[] indexDoubleArray = new double[7];
		for (int i = 0; i <= 6; i++) {
			if (i == 1) {
				indexDoubleArray[i] = (table1.doubleColumn(columnIndex).getDouble(i) * weightABC)
						+ (table2.doubleColumn(columnIndex).getDouble(i) * weightMEGA)
						+ (table3.doubleColumn(columnIndex).getDouble(i - 1) * weightTRX)
						+ (table4.doubleColumn(columnIndex).getDouble(i - 1) * weightNGL);
			} else if (i > 1 && i < 6) {
				indexDoubleArray[i] = (table1.doubleColumn(columnIndex).getDouble(i) * weightABC)
						+ (table2.doubleColumn(columnIndex).getDouble(i) * weightMEGA)
						+ (table3.doubleColumn(columnIndex).getDouble(i) * weightTRX)
						+ (table4.doubleColumn(columnIndex).getDouble(i) * weightNGL);
			} else if (i == 6) {
				indexDoubleArray[i] = (table1.doubleColumn(columnIndex).getDouble(i) * weightABC)
						+ (table2.doubleColumn(columnIndex).getDouble(i) * weightMEGA)
						+ (table3.doubleColumn(columnIndex).getDouble(i - 1) * weightTRX)
						+ (table4.doubleColumn(columnIndex).getDouble(i) * weightNGL);
			} else {
				indexDoubleArray[i] = (table1.doubleColumn(columnIndex).getDouble(i) * weightABC)
						+ (table2.doubleColumn(columnIndex).getDouble(i) * weightMEGA)
						+ (table3.doubleColumn(columnIndex).getDouble(i) * weightTRX)
						+ (table4.doubleColumn(columnIndex).getDouble(i) * weightNGL);
			}
		}
		return indexDoubleArray;
	}

	public double getWeightTRX() {
		return weightTRX;
	}

	public void setWeightTRX(double weightTRX) {
		this.weightTRX = weightTRX;
	}

	public double getWeightNGL() {
		return weightNGL;
	}

	public void setWeightNGL(double weightNGL) {
		this.weightNGL = weightNGL;
	}

	public double getWeightMEGA() {
		return weightMEGA;
	}

	public void setWeightMEGA(double weightMEGA) {
		this.weightMEGA = weightMEGA;
	}

	public double getWeightABC() {
		return weightABC;
	}

	public void setWeightABC(double weightABC) {
		this.weightABC = weightABC;
	}
	
	

}
