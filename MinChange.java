import java.util.List;
import java.util.Collections;
import java.util.HashMap;
import java.lang.Integer;

class MinChange {
    public static void main(String[] args) {
        minChange(4, List.of(1, 2, 3));
    }

    public static int minChange(int amount, List<Integer> coins) {
        return minChangeMySolution(amount, coins, new HashMap<Integer, Integer>());
    }

    public static int minChangeMySolution(Integer amount, List<Integer> coins, HashMap<Integer, Integer> memo) { // gets the number of coins
        // base case
        if (amount == 0)
            return 0;
        if (amount < 0)
            return -1;

        if (memo.containsKey(amount))
            return memo.get(amount);

        int minCoins = -1; // min number of coins needed to get change
        for (int coin: coins) {
            int subAmount = amount - coin;
            int subCoins = minChangeMySolution(subAmount, coins, memo);
            if (subCoins != -1) {
                int numCoins = subCoins + 1;
                if (numCoins < minCoins || minCoins == -1) {
                    minCoins = numCoins;
                }
            } 
        }
        memo.put(amount, minCoins);
        return minCoins;
    }
}