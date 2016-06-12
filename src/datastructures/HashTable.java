package datastructures;

/**
 *
 * @author c.carrillo2014
 */
import java.util.*;
import java.io.*;

public class HashTable {
    public final int buckets = (int)Math.pow(2,15);
    ArrayList<Integer> keys = new ArrayList<>();
    
    ArrayList[] table = new ArrayList[buckets];
    
    public void add(int x){
        int generated = hash(x);
        int index = generated & (table.length-1) - 1;
        if(table[index] == null)
            table[index] = new ArrayList<Integer>();
        table[index].add(x);
    }
    public int hash(int h){
        h ^= (h >>> 20) ^ (h >>> 12);
    return h ^ (h >>> 7) ^ (h >>> 4);
    }
    public void printAll(){
        for(int x=0; x<table.length; x++){
            if(table[x] != null){
                
                System.out.print("The contents of bucket " + x+ ": ");
                for(int y =0; y< table[x].size(); y++)
                    System.out.print(table[x].get(y) + " ");
                System.out.println();
            }
        }
    }
public int find(int x){
    int index = hash(x);
    index = index & (table.length-1) -1;
    if(table[index].contains(x)==false)
        return -1;
    
    return (int) index;
}
public int pos(int x){
int pos = 0;
    int index = hash(x);
    index = index & (table.length-1) -1;
    if(table[index].contains(x)==false)
        return -1;
    pos = table[index].indexOf(x);
return pos;
}
    
    public static void main(String[] args)throws IOException{
        HashTable list = new HashTable();
        
        for(int x =0 ; x< 10000; x++)
            list.add(x);
     list.printAll();
     System.out.println("The number 9705 is located in bucket: " + list.find(9705) + "\nThe position of the number in the bucket: " + list.pos(9705));

    }
}
