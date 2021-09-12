/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mahbuburr
 */
import java.util.ArrayList;
import java.util.Scanner;

public class Assignment04_02 {
    static int CAPACITY;
    static double[][] DP;
    static Club[] clubs;
    public static void knapsack() {
        for (int i = 1; i < DP.length; i++) {
            int w = clubs[i-1].WEIGHT;
            double v = clubs[i-1].PRICE;
            for (int sz = 1; sz <= CAPACITY; sz++) {
                DP[i][sz] = DP[i-1][sz];
                if (sz >= w && DP[i-1][sz-w]+v>= DP[i][sz])
                    DP[i][sz] = DP[i-1][sz-w]+v;
            }
        }
    }

    public static String construct() {
        ArrayList<Integer> items = new ArrayList<>();
        int sz = CAPACITY;
        for (int i = DP.length - 1; i > 0; i--) {
            if (DP[i][sz] != DP[i-1][sz]) {
                int idx = i-1;
                items.add(idx);
                sz -= clubs[idx].WEIGHT;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = items.size() - 1; i > -1; i--)
            sb.append(clubs[items.get(i)].NAME).append("->");

        sb.setLength(Math.max(sb.length() - 2, 0));
        return sb.toString();
    }

    static class Club {
        final String NAME;
        final int WEIGHT;
        final double PRICE;
        final String TROPHY;

        public Club(String name, int WEIGHT, double PRICE, String position) {
            NAME = name;
            this.WEIGHT = WEIGHT;
            this.PRICE = PRICE;
            this.TROPHY = position;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        CAPACITY = Integer.parseInt(in.nextLine());
        int N = Integer.parseInt(in.nextLine());
        DP = new double[N + 1][CAPACITY + 1];
        clubs = new Club[N];
        for (int i = 0; i < N; i++) {
            String[] club = in.nextLine().split(", ");
            clubs[i] = new Club(club[0],
                                 Integer.parseInt(club[1]),
                                 Double.parseDouble(club[2]),
                                 club[3]);

        }
        knapsack();
        System.out.printf("Name of clubs whose trophies were sold:\n%s\nMaximum money he earned: %.2f", construct(), DP[N][CAPACITY]);
    }
}

