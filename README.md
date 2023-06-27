# Coding-Challenge-For-Deutsche-Bank
The Task was to calculate some daily aggregates for the provided market historical log (sample attached as a .csv-file). Log is a list of all trades done in the market for a period of time. For every date in a log and for every traded ticker, daily values for open price (price of the first deal in the day), close price (price of the last deal in the day), highest price, lowest price, daily traded volume (sum of price*number_traded) are printed. The weighted sum of ticker prices at an instant were saved in the INDEX table.

## Description
To handle the task i made use of the Java Libary **emphasised** tablesaw. With tablesaw it is possible to create dataframes.
