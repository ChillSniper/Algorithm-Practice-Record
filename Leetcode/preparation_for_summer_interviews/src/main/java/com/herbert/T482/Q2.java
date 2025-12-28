package com.herbert.T482;

public class Q2 {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        long costAll = 0;
        int bothNeed = Math.min(need1, need2);
        if (cost1 + cost2 < costBoth) {
            costAll += (long)(cost1 + cost2) * bothNeed;
        } else {
            costAll += (long)costBoth * bothNeed;
        }
        int targetCostPer = need1 > need2 ? cost1 : cost2;
        int leftNum = Math.abs(need1 - need2);
        if (targetCostPer < costBoth) {
            costAll += (long)targetCostPer * leftNum;
        } else {
            costAll += (long)costBoth * leftNum;
        }
        return costAll;
    }
}
