package datastructures;

/**
 *
 * @author c.carrillo2014
 */
import java.util.*;
public class Graphs {
    
   ArrayList<NodeG> Nodes;
   int size=0;
   public Graphs(){
       Nodes = new ArrayList<>();
   }
   
   public void add(NodeG information){
       Nodes.add(information);
       
       size++;
   }
   public void findSmallest(NodeG start, NodeG end){//lets find the smallest
       ArrayList<NodeG> visited = new ArrayList<>();     
       ArrayList<NodeG> vertices = Nodes; 
       int weight = findSmall(start,end,visited, vertices);
       System.out.println(weight);
   }
   private int findSmall(NodeG start, NodeG end, ArrayList<NodeG> visited, ArrayList<NodeG> vertices){//actual method to find the smallest list
       int weight = 0; 
       PriorityQueue<NodeG> list = new PriorityQueue<>();
       vertices.get(0).setCost(0);
       for(int x=1; x<vertices.size(); x++){
           vertices.get(x).setCost(Integer.MAX_VALUE);
       }
       list.add(start); 
       while(!list.isEmpty()){
           NodeG x = list.poll();       
           ArrayList<NodeG> neighbor = x.neighbors();
           
           for(int fun=0; fun<neighbor.size(); fun++){
               
               neighbor.get(fun).setCost(Math.min(neighbor.get(fun).relativecost , x.getCost(neighbor.get(fun))));
               if(!visited.contains(neighbor.get(fun)) && !list.contains(neighbor.get(fun)))
                   list.add(neighbor.get(fun));
               if(neighbor.get(fun).relativecost == x.getCost(neighbor.get(fun)))
                   neighbor.get(fun).setFrom(x);
           }        
           visited.add(x);   
       }  
       return end.relativecost;
   }
   public ArrayList<NodeG> findSmallestList(NodeG start, NodeG end){//lets find the smallest
       ArrayList<NodeG> visited = new ArrayList<>();     
       ArrayList<NodeG> vertices = Nodes; 
        
       Stack<NodeG> mod = new Stack<>();
             mod = findSmallList(start,end,visited, vertices,mod);
       ArrayList<NodeG> list = new ArrayList<>();
            while(!mod.isEmpty()){
                list.add(mod.pop());
            } 
             
         return list;
   }
   private Stack<NodeG> findSmallList(NodeG start, NodeG end, ArrayList<NodeG> visited, ArrayList<NodeG> vertices,Stack<NodeG> mod){//actual method to find the smallest list
       
       
       PriorityQueue<NodeG> list = new PriorityQueue<>();
       
       vertices.get(0).setCost(0);
       for(int x=1; x<vertices.size(); x++){
           vertices.get(x).setCost(Integer.MAX_VALUE);
       }
       list.add(start); 
       while(!list.isEmpty()){
           NodeG x = list.poll();       
           ArrayList<NodeG> neighbor = x.neighbors();
           
           for(int fun=0; fun<neighbor.size(); fun++){
               
               neighbor.get(fun).setCost(Math.min(neighbor.get(fun).relativecost , x.getCost(neighbor.get(fun))));
               if(!visited.contains(neighbor.get(fun)) && !list.contains(neighbor.get(fun)))
                   list.add(neighbor.get(fun));
               if(neighbor.get(fun).relativecost == x.getCost(neighbor.get(fun)))
                   neighbor.get(fun).setFrom(x);
           }        
           visited.add(x);   
       }  
       NodeG temp = end;
       while(temp.camefrom != null){
           mod.add(temp);
           temp = temp.camefrom;     
       }
       mod.add(start);
       return mod;
   }

   public void connectTo(NodeG first, NodeG second,Integer weight){

       first.addNeigh(second,weight);
       second.addNeigh(first,weight);
       
   }
   public boolean checkCon(NodeG check, NodeG with){
       if(check.list.contains(with))
           return true;
       
       return false;
   }
   
   public boolean isConnected(NodeG check, NodeG with, ArrayList<NodeG> visited){ 
       
       if(!visited.contains(check)){
         
           if(check.equals(with)){
               System.out.println(with);
             return true;  
           }
           
       else{
           visited.add(check);
           System.out.print(check+ " ");
           ArrayList<NodeG> temp = check.neighbors();
           
           for(int x=0; x<temp.size(); x++){
               if(isConnected(temp.get(x),with,visited))
                   return true;
           }
         }
       }
       return false;
   }
   public void checkWeight(NodeG first){
      ArrayList<NodeG> neigh = first.neighbors();
      int weight=0;
      for(int x=0; x<neigh.size(); x++){
      weight = first.weight.get(x);
      System.out.println("Neighbor: " + neigh.get(x) + " Weight: "+ weight);
      }
     
   }
  public boolean find(NodeG node, NodeG node2){

       ArrayList<NodeG> visited = new ArrayList<>();

       
       return isConnected(node,node2,visited);    
  }
}