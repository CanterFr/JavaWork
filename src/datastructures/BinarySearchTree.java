
package datastructures;
/**
 *
 * @author c.carrillo2014
 */
public class BinarySearchTree<T extends Comparable<T>>{
	
    private Node<T> root;
    private int size;
 
    public BinarySearchTree()
    {
        root = null;
    }
 
    public void add(T data)
    {
        //start from root then go downwards
        root = add(root, data);
        size++;
    }
 
    //recursive addition
    private Node<T> add(Node<T> current, T data)
    {	
        //base case: empty tree, or end of tree
        if(current == null)
            return new Node(data);
 
        //compare the objects
        int comparison = data.compareTo(current.getData());
 
        //go to left tree (smaller value than parent)
        if(comparison < 0)
            current.left = add(current.left, data);
 
        //go to right tree (greater or equal value than parent)
        else
            current.right = add(current.right, data);
 
        return current;
    }
    
    public int getHeight(Node<T> fun){
        if(fun == null){
            return 0;
        }
        if(fun.left == null && fun.right == null){
            return 1;
        }
         
         else 
             return Math.max(getHeight(fun.left), getHeight(fun.right))+1;
        
    }
    public int getHeight(){
        return getHeight(root);
    }
    public void remove(T targetData)
    {
        if(root != null)
        {
            root = remove(root, targetData);
            size--;   
        }
    }
    
    //recursive removal
    private Node<T> remove(Node<T> current, T targetData)
    {
        //empty
        if(current == null)
            return null;
        
        //compare
        int comparison = targetData.compareTo(current.getData());
        
        //match found
        if(comparison == 0)
        {
                    
            boolean leftExists = current.left != null;
            boolean rightExists = current.right != null;
            
            //full node
            if(leftExists && rightExists)
            {
                Node<T> temp;
                
                //pick a side at random
                int r = (int)(Math.random() * 2);
 
                //get max from left tree
                if(r == 0)
                {   
                    temp = getMax(current.left);
                    
                    //swap data
                    current.setData(temp.getData());
                    
                    //remove the max in the left subtree
                    current.left = removeMax(current.left);
                }
                
                //get min from right tree
                else
                {
                    temp = getMin(current.right);
                    
                    //swap data
                    current.setData(temp.getData());
                    
                    //remove the min in the right sub tree
                    current.right = removeMin(current.right);
                }
            }            
            
            else if(leftExists)
                return current.left;
            
            //right child exists
            else if(rightExists)
                return current.right;
            
            //leaf
            else
                return null;
        }
        
        //search left
        else if(comparison < 0)
            current.left = remove(current.left, targetData);
        
        //search right
        else
            current.right = remove(current.right, targetData);
        
        return current;
    }
    
    private Node<T> removeMax(Node<T> current)
    {
        if(current.right == null)
            return current.left;
       
        //keep going right
        current.right = removeMax(current.right);
        
        return current;
    }
    
    private Node<T> removeMin(Node<T> current)
    {
        if(current.left == null)
            return current.right;
       
        //keep going left
        current.left = removeMin(current.left);
        
        return current;
    }

    private void swapChildren(Node<T> n)
    {
        Node<T> temp = n.left;
        n.left = n.right;
        n.right = temp;
    }
    
    //obtain the node with the target data
    public Node<T> findNode(Node<T> current, T targetData)
    {
        //base case - empty tree or nothing found
        if(current == null)
            return current;
        
        //compare
        int comparison = targetData.compareTo(current.getData());
        
        //base case - targetData found
        if(comparison == 0)
            return current;
        
        //search left
        else if(comparison < 0)
            return findNode(current.left, targetData);
        
        //search right
        else
            return findNode(current.right, targetData);
    }
 
    public T getMax()
    {
        return getMax(root).getData();
    }
    
    //get the farthest-right node
    private Node<T> getMax(Node<T> current)
    {
        //max reached
        if(current.right == null)
           return current;
        
        //keep going right
        return getMax(current.right);
    }
 
    //get the farthest-left node 
    public T getMin(){
        return getMin(root).getData();
    }
    
    private Node<T> getMin(Node<T> current)
    {
        //min reached
        if(current.left == null)
            return current;
        
        //keep going left
        return getMin(current.left);
    }
 
    public void displayInOrder()
    {
        inOrder(root); 
        System.out.println();
    }
 
    private void inOrder(Node<T> current){
        if(current != null){
            inOrder(current.left);
            System.out.print(current + " ");
            inOrder(current.right);
        }
    }
 
    public void displayPreOrder()
    { 
        preOrder(root); 
        System.out.println();
    }
 
    private void preOrder(Node<T> current){
        if(current != null){
            System.out.print(current + " ");
            preOrder(current.left);
            preOrder(current.right);
        }
    }
 
    public void displayPostOrder()
    { 
        postOrder(root);
        System.out.println();
    }
 
    private void postOrder(Node<T> current){
        if(current != null){
            postOrder(current.left);
            postOrder(current.right);
            System.out.print(current + " ");
        }
    }		
 
    public int getSize()
    {
        return size;
    }
}