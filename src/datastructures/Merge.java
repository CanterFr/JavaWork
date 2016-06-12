/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures;

import java.io.*;
public class Merge extends MergeSort {
    
     public static void main(String[] args)throws IOException{
         
         
         int[] values = {1,22,-1,0,20,514};
        //values = sort(values);
         
         for(int x=0; x<values.length;x++){
             System.out.print(values[x] + " ");
         }
     }
     
}
