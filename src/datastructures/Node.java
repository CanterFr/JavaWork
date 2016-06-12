

package datastructures;
/**
 *
 * @author c.carrillo2014
 */
public class Node <T extends Comparable<T>>{
	
    public Node<T> left;
    public Node<T> right;
    public int height;
    public T data;
 
    public Node(Node<T> node)
    {
        if(node==null)
        {
            left = null;
            right = null;
            height = 0;
            data=null;
        }
        else
        {
            this.data = node.data;
            left = node.left;
            right = node.right;
            height = node.getHeight();
        }
    }
    public Node(T data)
    {
        left = null;
        right = null;
        height = 0;
        this.data = data;
    }
    
    
    public T getData()
    {
        return data;
    }
    public int getHeight(){
        return height;
    }
    public void increment(){
        height++;
    }
    public boolean hasLeft(){
        return left==null;
    }
    public boolean hasRight(){
        return right == null;
    }
    public void setData(T data)
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
