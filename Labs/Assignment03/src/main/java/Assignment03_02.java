/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mahbuburr
 */
import java.util.HashMap;
import java.util.Scanner;

public class Assignment03_02 {
    final static HashMap<Character, String> WORDS = new HashMap<>() {
        {
            put('M', "monkeys");
            put('W', "wearing");
            put('C', "coats");
            put('A', "are");
            put('D', "doctors");
            put('B', "because");
            put('O', "of");
            put('E', "evolution");
            put('R', "results");
            put('P', "eruption");
        }
    };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine(), s2 = sc.nextLine();
        LCS lcs = new LCS(s1.replace(" ","").toCharArray(),s2.replace(" ","").toCharArray());
        System.out.println(lcs.genlcs());
        String temp = lcs.constructString();
        for(int i = 0; i < temp.length() ; i++) System.out.print(WORDS.get(temp.charAt(i)) + " ");
        System.out.println();
    }
}
