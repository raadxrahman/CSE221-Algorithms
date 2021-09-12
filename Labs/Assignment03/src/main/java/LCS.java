/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mahbuburr
 */
import java.util.Scanner;

public class LCS {
    int[][] L;
    final char[] s1, s2;

    LCS(char[] s1, char[] s2){
        this.s1 = s1;
        this.s2 = s2;
    }

    public int genlcs(){
        L = new int[s1.length + 1][s2.length + 1];
        for (int i = 1; i < s1.length + 1 ; i++) {
            for (int j = 1; j < s2.length + 1 ; j++) {
                if(s1[i-1] == s2[j-1]) 
                    L[i][j] = L[i-1][j-1] + 1;
                else L[i][j] = Math.max(L[i-1][j],L[i][j-1]);
            }
        }
        return L[s1.length][s2.length];
    }

    public String constructString(){
        StringBuilder x = new StringBuilder();
        int s1L = s1.length, s2L = s2.length;
        int tempLength = L[s1.length][s2.length];
        while(s1L >= 0 && s2L >= 0 && tempLength > 0){
            while(s2L > 0 && L[s1L][s2L-1] == tempLength) s2L--;
            while(s1L > 0 && L[s1L-1][s2L] == tempLength) s1L--;
            x.append(s1[s1L-1]);
            s1L--;
            s2L--;
            tempLength--;
        }
        return x.reverse().toString();
    }
}
