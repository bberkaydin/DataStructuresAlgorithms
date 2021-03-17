package Interview.General;

/*
You are given an array prices where prices[i] is the price of a given stock on the ith day.
Input: prices = [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
 */
public class BestTimetoBuyandSellStock {

    /*
    Kadene's Algorithm:
    Here, the logic is to calculate the difference (maxCur += prices[i] - prices[i-1])
    of the original array, and find a contiguous subarray giving maximum profit.
    If the difference falls below 0, reset it to zero.
     */
    public int maxProfit(int[] prices) {
        int maxCur = 0, maxSoFar = 0;
        for(int i = 1; i < prices.length; i++) {
            maxCur = Math.max(0, maxCur += prices[i] - prices[i-1]);
            maxSoFar = Math.max(maxCur, maxSoFar);
        }
        return maxSoFar;
    }
}
