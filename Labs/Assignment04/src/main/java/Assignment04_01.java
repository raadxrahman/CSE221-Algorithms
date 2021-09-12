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
import java.util.Collections;
import java.util.Scanner;

public class Assignment04_01 {
    static int CAPACITY;
    static int[][] DP;
    static Player[] players;
    public static void knapsack() {
        for (int i = 1; i < DP.length; i++) {
            int w = players[i-1].FORM;
            int v = players[i-1].PRICE;
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
                sz -= players[idx].FORM;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = items.size() - 1; i > -1; i--)
            sb.append(players[items.get(i)].NAME).append("->");

        sb.setLength(Math.max(sb.length() - 2, 0));
        return sb.toString();
    }

    static class Player {
        final String NAME;
        final int PRICE;
        final int FORM;
        final char POSITION;

        public Player(String name, int FORM, int PRICE, char position) {
            NAME = name;
            this.PRICE = PRICE;
            this.FORM = FORM;
            this.POSITION = position;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        CAPACITY = Integer.parseInt(in.nextLine());
        int N = Integer.parseInt(in.nextLine());
        DP = new int[N + 1][CAPACITY + 1];
        players = new Player[N];
        for (int i = 0; i < N; i++) {
            String[] player = in.nextLine().split(", ");
            players[i] = new Player(player[0],
                                    Integer.parseInt(player[1]),
                                    Integer.parseInt(player[2]),
                                    player[3].charAt(0));

        }
        knapsack();
        System.out.println(DP[N][CAPACITY]);
        System.out.println(construct());
    }
}

