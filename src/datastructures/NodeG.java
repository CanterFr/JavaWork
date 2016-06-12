

package datastructures;
import java.util.*;
/**
 *
 * @author c.carrillo2014
 */
public class NodeG implements Comparable<NodeG>{
	
    public ArrayList<NodeG> list = new ArrayList<>();
    public String data;
    public ArrayList<Integer> weight = new ArrayList<>();
    public NodeG camefrom;
    int relativecost;
    public NodeG(){
        this.data = null;
    }
    public NodeG(String data)
    {
        this.relativecost = 0;
        this.data = data;
    }
    public int compareTo(NodeG obj){
        if(this.relativecost == obj.relativecost)
            return 0;
        else if(this.relativecost < obj.relativecost)
            return -1;
        else 
        return 1;
    }
    public void setFrom(NodeG fun){
        camefrom = fun;
    }
    public void setCost(int cost){
        relativecost = cost;
    }
    public int getCost(NodeG path){
        int number = getWeight(path);
        return this.relativecost + number;
    }
    public void addNeigh(NodeG fun,Integer yolo){
        list.add(fun);
        weight.add(yolo);
    }
    public void addWeight(int fun){
        weight.add(fun);
    }
    public int getWeight(NodeG path){
        int number =list.indexOf(path);
        return weight.get(number);
    }
    public ArrayList neighbors(){
        return list;
    }
    public String getData()
    {
        return data;
    }
    public void setData(String data)
    {
        this.data = data;
    }
 
    @Override
    public String toString()
    {
        if(this == null)
            return "";
        return data.toString();
    }
}