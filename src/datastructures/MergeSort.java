/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures;

import java.util.*;
import java.io.*;
public class MergeSort {
         
 
    private int[] numbers;
    private int[] sorted;
    
    private int number;
    
    public int[] sort(int[] values){
        this.numbers = values;
        number = values.length;
        this.sorted = new int[number];
       mergesort(0, number-1);
       return sorted;
    }
    private void mergesort(int low, int high){
        if(low<high){
            int middle = low + (high - low) / 2;
            
            mergesort(low,middle);
            
            mergesort(middle+1, high);
            
            merge(low, middle, high);
        }
    }
     private void merge(int low, int middle, int high) {

    for (int i = low; i <= high; i++) {
      sorted[i] = numbers[i];
    }

    int i = low;
    int j = middle + 1;
    int k = low;
    
    
    while (i <= middle && j <= high) {
      if (sorted[i] <= sorted[j]) {
        numbers[k] = sorted[i];
        i++;
      } else {
        numbers[k] = sorted[j];
        j++;
      }
      k++;
    }
    
    while (i <= middle) {
      numbers[k] = sorted[i];
      k++;
      i++;
    }

  }
} 