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

class Level01{
    static int n,con,end;
    static int[] color;
    static int[] d;
    static int[] parent;
    static int[][] matrix;

    public static void main(String[] args) {
            File f= new File("input.txt");

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

                    edgeUndirectedMatrixConnector(x,y);
                    i++;
                }

                end=Integer.parseInt(sc.nextLine());
                BFS(0);
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }

    static void edgeUndirectedMatrixConnector(int i,int j){
        matrix[i][j] = 1;
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
            for(int v=0;v<n;v++){
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
        System.out.println("Minimum number of movement is : "+d[end]);
    }
}

