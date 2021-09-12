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
public class Assignment03_01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine(),s2 = sc.nextLine();
        LCS lcs = new LCS(s1.replace(" ","").toCharArray(),s2.replace(" ","").toCharArray());
        int length = lcs.genlcs();
        System.out.println(lcs.constructString());
        double answer = ((double)length/(double)s1.replace(" ","").toCharArray().length) * 100;
        System.out.println(answer + "% PASSED");
    }
}
