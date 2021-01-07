package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpiralMatrix {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if(matrix==null||matrix.length==0) return res;
        int eleNum = matrix[0].length*matrix.length;
        int l = 0;
        int r = matrix[0].length-1;
        int t = 0;
        int b = matrix.length-1;

        int num =0;
        while(num<eleNum){

            for(int i =l;i<=r&&num<eleNum;i++){
                num++;
                res.add(matrix[t][i]);
            }
            t++;

            for(int i =t;i<=b&&num<eleNum;i++){
                num++;
                res.add(matrix[i][r]);
            }
            r--;

            for(int i =r;i>=l &&num<eleNum;i--){
                num++;
                res.add(matrix[b][i]);
            }
            b--;

            for(int i =b;i>=t &&num<eleNum;i--){
                num++;
                res.add(matrix[i][l]);
            }
            l++;
        }
        return res;
    }

    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int eleNum = n*n;
        int l = 0;
        int r = n-1;
        int t = 0;
        int b = n-1;
        int num =0;
        while(num<eleNum){

            for(int i =l;i<=r;i++){
                matrix[t][i] = ++num;
            }
            t++;

            for(int i =t;i<=b;i++){
                matrix[i][r] = ++num;
            }
            r--;

            for(int i =r;i>=l ;i--){
                matrix[b][i] = ++num;
            }
            b--;

            for(int i =b;i>=t;i--){
                matrix[i][l]=++num;
            }
            l++;
        }
        return  matrix;
    }


//    public static void main(String[] args) {
//        SpiralMatrix spiralMatrix = new SpiralMatrix();
//        int[][] matrix ={{1,2,3},{4,5,6},{7,8,9}};
//        List<Integer> result = spiralMatrix.spiralOrder(matrix);
//        System.out.println(result);
//
//    }

    public static void main(String[] args) {
        SpiralMatrix spiralMatrix = new SpiralMatrix();
        int[][] ints = spiralMatrix.generateMatrix(3);
        System.out.println(Arrays.toString(ints));

    }
}
