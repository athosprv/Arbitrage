Arbitrage

Arbitrage:

Arbitrage is the trading of one currency for another with the hopes of taking advantage of small differences in conversion rates among several currencies in order to achieve a profit. For example, if $1.00 in U.S. currency buys 0.7 British pounds currency, £1 in British currency buys 9.5 French francs, and 1 French franc buys 0.16 in U.S. dollars, then an arbitrage trader can start with $1.00 and earn

    1 x 0.7 x 9.5 x 0.16 = 1.064 thus earning a profit of 6.4 percent.

You will write a program that determines whether a sequence of currency exchanges can yield a profit as described above.

To result in successful arbitrage, a sequence of exchanges must begin and end with the same currency, but any starting currency may be considered.  Please pay close attention to the requirements described in the Input and Output sections of this write up.  In particular, you will be allowed a limited number of exchanges, the total profit must be at least 1%, and you are allowed to repeat currencies multiple times as along as the total number of exchanges does not exceed the required limit.

 

Input:

The input consists of one or more conversion tables. You must solve the arbitrage problem for each of the tables in the input. 

Each table is preceded by an integer n on a line by itself giving the dimensions of the table (the total number of currencies). The maximum dimension is 20; the minimum dimension is 2.  Because each problem begins with a number indicating the size of the table that follows, this input does not have blank lines between problems.

The table then follows with one table row per line.  Each row contains the conversions factors for converting from the currency of the country in that row.  In other words, the table entry in row i, column j contains the conversion factor for converting from currency i to currency j (the amount of currency j that you would get for 1 unit of currency i).

Thus each table consists of n+1 lines in the input file: 1 line containing the integer n immediately followed n lines representing the n rows of the table.  Each table row will have n real numbers (Java doubles) separated from each other by spaces.  It is imperative that after reading the single number n on the first line, you only read the next n lines which correspond to the rows of the table.  If you try reading past the end of the table before answering that problem, your code will block and time out.  Once you send your answer, you should continue to read in the next problem (and answer it). 

Output:

For each table in the input you must determine whether a sequence of exchanges beginning at some currency and ending at the same currency exists that results in a profit of more than 1 percent (0.01). If a sequence exists you must print the sequence of exchanges that results in a profit. If there is more than one sequence that results in a profit of more than 1 percent you must print a sequence of minimal length, i.e., one of the sequences that uses the fewest exchanges of currencies to yield a profit of more than 1 percent.

Because the IRS (United States Internal Revenue Service) notices lengthy transaction sequences, all profiting sequences must consist of n or fewer transactions where n is the dimension of the table giving conversion rates. The sequence 1 2 1 represents two conversions.

If a profiting sequence exists you must print the sequence of exchanges that results in a profit. The sequence is printed as a sequence of integers with the integer i representing the ith line of the conversion table (country i). The first integer in the sequence is the country from which the profiting sequence starts. This integer also ends the sequence.  Important: The first row in the table is called row 1.  This is different from the way Java usually numbers arrays.

If no profiting sequence of n or fewer transactions exists, then the line

none
should be printed.
 

End of all Input:

The end of all input will be marked by an additional blank line a blank line.  Note this this blank line would come after a table description, when you would normally be looking for the size of the next table.

Example:

For example, the input might look like:

3
1.0 1.2 .89
.88 1.0 5.1
1.1 0.15 1.0
4
1.0 3.1 0.0023 0.35
0.21 1.0 0.00353 8.13 
200 180.559 1.0 10.339
2.11 0.089 0.06111 1.0
2
1.0 2.0
0.45 1.0
<blank line here>

Which contains a single blank line at the end (after the line 0.45 1.0).  A possible valid output would be:
1 2 1
1 2 4 1
none
 
Correctness:

Note that in the example above, 1 2 4 1 is a correct solution for the second table because:

The total number of conversions (3) is less than or equal to the number of currencies/dimensions of the table (4)
The product of the conversions involved is greater than 1.01  (3.1 * 8.13 * 2.11 = 53.17833).  (Note that in practice you never get an arbitrage situation that yields 5300% profit like this).
There is no other sequence of conversions that is shorter (contains fewer than 3 conversions) and still yields a product that is greater than 1.01.
 

 