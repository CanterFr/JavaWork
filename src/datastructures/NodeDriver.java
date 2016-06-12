/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures;

 import java.util.*;

public class NodeDriver {
 
    public static void main(String[] args) {
        //BinarySearchTree<Integer> bst = new BinarySearchTree();
        //Avl<Integer> yolo = new Avl();
        Graphs dolo = new Graphs();
        
        /*NodeG a = new NodeG("A");
        NodeG b = new NodeG("B");
        NodeG c = new NodeG("C");
        NodeG d = new NodeG("D");
        NodeG e = new NodeG("E");
        NodeG f = new NodeG("F");
        NodeG g = new NodeG("G");
        NodeG h = new NodeG("H");
        NodeG i = new NodeG("I");
        NodeG j = new NodeG("J");
        NodeG k = new NodeG("K");
        NodeG l = new NodeG("L");
        
        dolo.connectTo(a, b);
        dolo.connectTo(a, d);
        dolo.connectTo(b, e);
        dolo.connectTo(b, g);
        dolo.connectTo(c, f);
        dolo.connectTo(c, g);
        dolo.connectTo(d, g);
        dolo.connectTo(d, h);
        dolo.connectTo(e, j);
        dolo.connectTo(i, j);
        dolo.connectTo(i, k);
        dolo.connectTo(i, f);
        dolo.connectTo(f, g);
        dolo.connectTo(h, l);
        dolo.connectTo(f, l);
        dolo.connectTo(g, k);

        
        dolo.find(a,l);
        */
        NodeG a = new NodeG("A");
        NodeG b = new NodeG("B");
        NodeG c = new NodeG("C");
        NodeG d = new NodeG("D");
        NodeG e = new NodeG("E");
        NodeG f = new NodeG("F");
        dolo.add(a);
        dolo.add(b);
        dolo.add(c);
        dolo.add(d);
        dolo.add(e);
        dolo.add(f);
        dolo.connectTo(a,b,2);
        dolo.connectTo(b,c,4);
        dolo.connectTo(a,c,8);
        dolo.connectTo(b,d,15);
        dolo.connectTo(c,d,8);
        dolo.connectTo(c,e,2);
        dolo.connectTo(e,f,1);
        dolo.connectTo(f,d,1);
        ArrayList<NodeG> fun = new ArrayList<>();
        fun = dolo.findSmallestList(a,d);
        
        for(int x =0; x<fun.size(); x++)
            System.out.print(fun.get(x).data + " ");
        System.out.println("");
        
        
      /* int array[] = {3,2,1,4,5,6,-1,-2,0,10};
        
        
         for(int n : array){
            yolo.insert(n);
                   }
         
         yolo.displayPreOrder();
         yolo.remove(2);
         yolo.displayPreOrder();
         
        //yolo.displayInOrder();
   /*   
        bst.displayInOrder();
        System.out.println("Max: " + bst.getMax());
        System.out.println("Min: " + bst.getMin());
        System.out.println("Size: " + bst.getSize());
        System.out.println("Height: " + bst.getHeight());
       
        */
        //System.out.println("Height: " + bst.getHeight());
                
      //  bst.displayInOrder();
        
    }
    
}
