# Coding-Challenge-For-Deutsche-Bank
The Task was to calculate some daily aggregates for the provided market historical log (sample attached as a .csv-file). Log is a list of all trades done in the market for a period of time. For every date in a log and for every traded ticker, daily values for open price (price of the first deal in the day), close price (price of the last deal in the day), highest price, lowest price, daily traded volume (sum of price*number_traded) are printed. The weighted sum of ticker prices at an instant were saved in the INDEX table.

## Description
### Reading the .csv-file
To handle the task i made use of the Java library **tablesaw** (_Version:0.43.1_). With tablesaw it is possible to create dataframes. 
The .csv-file is read with a Reader object (takes in the String of the path of the file as argument), which then creates a Table. 

### Calculating daily aggregates
With a AggregatesCalculator object the daily aggregates are calculated. For that the calculateDailyAggregates-Function is used.
This function takes in a table as argument. To calculate the daily aggregates of a specified ticker the function can take in a String as a second argument.
The function returns a table consisting of daily aggregates. The table of the aggregates can be displayed with a System.out.println(tableOfAggregates); command.

### Handling days where ticker did not trade
Some tickers did not trade in certain days. That was made visible in the tables with the DealingWithNoTrades class. With the addDaysOfNoTrade-function specified days can be added to the desired table. The days were no trades were made appear in the table with 0-values in all of their columns(except date).

### Creating Index
The INDEX is created with the help of the IndexCreator class. With the createIndexDoubleArray of the IndexCreator class double arrays are created, that consist of the sum of ticker prices (min,max,first,last prices and daily traded volume). The double arrays are used to create the INDEX table.

### Run
When the main method is run (in the Main class), the tables of daily aggregates of all tickers and the INDEX-table appear in the console.

### Tests
To test the Aggregate Calculation run:


