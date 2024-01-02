package 每日一题.经营摩天轮的最大利润;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Classname Solution
 * @Description https://leetcode.cn/problems/maximum-profit-of-operating-a-centennial-wheel/
 * @Date 2024/1/1 12:42
 * @Created by ahh
 */
public class Solution {

    public static void main(String[] args) {

        System.out.println(minOperationsMaxProfit1(new int[]{10, 10, 6, 4, 7}, 3, 8));
    }

    public static int minOperationsMaxProfit(int[] customers, int boardingCost, int runningCost) {
        // 利润 = 乘客数 * boardingCost - 运行次数 * runningCost
        int runningCount = 0;
        int passengerCount = 0;
        int waitPassengerCount = 0;
        int maxProfit = -1;
        int maxCount = -1;
        int currentProfit = -1;
        int i = 0;
        while (true) {
            if (i >= customers.length && waitPassengerCount == 0) {
                break;
            }
            if (i < customers.length) {
                waitPassengerCount = waitPassengerCount + customers[i++];
            }
            int actualPassengerCount = Math.min(waitPassengerCount, 4);
            passengerCount = passengerCount + actualPassengerCount;
            waitPassengerCount = waitPassengerCount - actualPassengerCount;
            runningCount++;

            currentProfit = passengerCount * boardingCost - runningCount * runningCost;
            if (currentProfit > maxProfit) {
                maxProfit = currentProfit;
                maxCount = runningCount;

            }


        }
        return maxProfit > 0 ? maxCount : -1;
    }

    public static int minOperationsMaxProfit1(int[] customers, int boardingCost, int runningCost) {
        int totalCustomers = 0; // 总上车游客数
        int customersWaiting = 0; // 等待上车的游客数
        int totalRotations = 0; // 总轮转次数
        int maxProfit = 0; // 最大利润
        int currentProfit; // 当前利润
        int minRotationsForMaxProfit = -1; // 达到最大利润的最小轮转次数

        for (int i = 0; i < customers.length || customersWaiting > 0; i++) {
            if (i < customers.length) {


                customersWaiting += customers[i]; // 新到的游客加入等待队列
            }

            int customersBoarding = Math.min(customersWaiting, 4); // 这轮上车的游客数
            totalCustomers += customersBoarding; // 更新总上车游客数
            customersWaiting -= customersBoarding; // 更新等待上车的游客数
            totalRotations++; // 增加轮转次数

            // 计算当前利润
            currentProfit = totalCustomers * boardingCost - totalRotations * runningCost;

            // 如果当前利润大于最大利润，更新最大利润和对应的轮转次数
            if (currentProfit > maxProfit) {
                maxProfit = currentProfit;
                minRotationsForMaxProfit = totalRotations;
            }
        }

        return minRotationsForMaxProfit;
    }
}
