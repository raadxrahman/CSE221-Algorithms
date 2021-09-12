import java.io.*;
import java.util.*;

class Level04 {
    static int n,m;
    static int[] indegree;
    static int[][] matrix;

    public static void main(String[] args){
        File f= new File("input.txt");

        try{
            Scanner sc = new Scanner(f);
            n=Integer.parseInt(sc.nextLine());
            matrix=new int[n][n];
            m=Integer.parseInt(sc.nextLine());
            indegree=new int[n];
            String[] split;
            int i=0;
            while (i<m) {
                String line=sc.nextLine();
                split=line.split(" ");
                int x=Integer.parseInt(split[0]);
                int y=Integer.parseInt(split[1]);

                edgeDirectedMatrixConnector(x,y);
                i++;
            }
            Count();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    static void edgeDirectedMatrixConnector(int i,int j){
        matrix[i][j] = 1;
    }

    static void Count() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(matrix[i][j]==1){
                    indegree[j]++;
                }
            }
        }

        int min = indegree[0];
        int minpos=0;
        for (int i = 0; i < n; i++) {
            if (indegree[i] < min) {
                min = indegree[i];
                minpos=i;
            }
        }
        System.out.println("Suitable first position for Nora is : " + minpos);
    }
}