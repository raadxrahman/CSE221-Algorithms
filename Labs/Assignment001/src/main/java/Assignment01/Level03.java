/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment01;
import java.io.*;
import java.util.*;

/**
 *
 * @author raadr
 */

class Level03{
        static int n,con,x,k,k1,k2,k3,k4,k5;
        static int[] color;
        static int[] d;
        static int[] parent;
        static int[][] matrix;

        public static void main(String[] args){
            File f= new File("input2.txt");

            try{
                Scanner sc = new Scanner(f);
                n=Integer.parseInt(sc.nextLine());
                matrix=new int[n][n];
                con=Integer.parseInt(sc.nextLine());

                String[] split;
                int i=0;
                while (i<con) {
                    String line=sc.nextLine();
                    split=line.split(" ");
                    int x=Integer.parseInt(split[0]);
                    int y=Integer.parseInt(split[1]);

                    edgedirectedMatrixConnector(x,y);
                    i++;
                }

                x=Integer.parseInt(sc.nextLine());
                k=Integer.parseInt(sc.nextLine());
                k1=Integer.parseInt(sc.nextLine());
                k2=Integer.parseInt(sc.nextLine());
                k3=Integer.parseInt(sc.nextLine());
                k4=Integer.parseInt(sc.nextLine());
                k5=Integer.parseInt(sc.nextLine());

                BFS(x);
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }

        static void edgedirectedMatrixConnector(int i,int j){
            matrix[j][i] = 1;
        }

        static void BFS(int s){
            color=new int[n];
            d=new int[n];
            parent=new int[n];

            for(int i=0;i<n;i++){
                color[i]=0; //white
                d[i]=0;
                parent[i]=-1; //null
            }
            Queue<Integer> q=new LinkedList<Integer>();
            q.add(s);
            color[s]=1; //grey

            while(!q.isEmpty()){
                int u=q.remove();
                for(int v=n-1;v>=0;v--){
                    if(matrix[u][v]==1){
                        if(color[v]==0){
                            d[v]=d[u]+1;
                            parent[v]=u;
                            color[v]=1;
                            q.add(v);
                        }
                    }
                }
                color[s]=2; //black
            }
            int min=min(d);
            System.out.println("Minimum number of moves needed to win is : "+min);
        }

       static int min(int[] d){
           int minValue = d[0];
           for(int i=0;i<n;i++) {
               if (i == k1 || i == k2 || i == k3 || i == k4 || i == k5) {
                   if (d[i] < minValue) {
                       minValue = d[i];
                   }
               }
           }
            return minValue;
        }

}
