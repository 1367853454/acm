package com.company.zaqizaba;

import java.util.Scanner;

/**
 * @author: wangyuhang
 * @date: 2019/9/20
 * @description:
 *输入
 * 005300000
 * 800000020
 * 070010500
 * 400005300
 * 010070006
 * 003200080
 * 060500009
 * 004000030
 * 000009700
 *
 *输出
 * 125346897
 * 831467925
 * 276918543
 * 489625371
 * 912873456
 * 753291684
 * 367584219
 * 694752138
 * 548139762
 */
public class dfs {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[][] matrix = new char[9][9];
        for (int i = 0 ; i < 9 ; i ++){
            matrix[i] = sc.next().toCharArray();
        }
        DFS(matrix,0,0);
    }

    static void DFS(char[][] matrix, int i, int j ){
        if (i == 9){
            for (int a = 0 ; a < 9 ; a++){
                System.out.println(matrix[a]);
            }
            System.exit(0);
        }
        if (matrix[i][j] == '0'){
            for (int k = 1; k < 10; k++){
                if(check(matrix , i , j ,k +'0')){
                    //确定当前状态
                    matrix[i][j] = (char) (k + '0');
                    //转移到下一个状态
                    DFS(matrix, i + (j +1) / 9, (j +1) % 9);
                }
            }
            //回溯？？
            matrix[i][j] = '0';
        } else {
            //转移到下一个状态
            DFS(matrix, i + (j +1) / 9, (j +1) % 9);
        }
    }

    private static boolean check(char[][] matrix, int i , int j , int k){
        for (int a = 0; a < 9; a++){
            if (matrix[i][a] == k){
                return false;
            }
        }
        for (int a = 0 ; a < 9 ; a ++){
            if (matrix[a][j] == k){
                return false;
            }
        }
        return true;
    }

}
