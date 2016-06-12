

package datastructures;
/**
 *
 * @author c.carrillo2014
 */
public class Avl<T extends Comparable<T>>{
public Node<T> root;
    private int size;
 
    public Avl()
    {
        root = null;
    }
    
    private int height(Node t)
    {
        return t==null?0:t.height;
    }
    
    private int max(int lhs,int rhs)
    {
        return lhs>rhs?lhs:rhs;
    }
    
    public void insert(T data)
    {
        root=insert(data,root);
    }
    
    private Node insert(T x, Node t)
    {
        if(t==null)
            t=new Node(x);
        if(t.getData().compareTo(x)>0)
        {
            t.left=insert(x,t.left);
            if(height(t.left)-height(t.right)==2)
                if(t.left.getData().compareTo(x)>0)
                    t=rotateWithLeftChild(t);
                else    
                    t=doubleWithLeftChid(t);
        }
        else if(t.getData().compareTo(x)<0)
        {
           t.right=insert(x,t.right);
            if(height(t.right)-height(t.left)==2)
                if(t.right.getData().compareTo(x)<0)
                    t=rotateWithRightChild(t);
                else    
                    t=doubleWithRightChild(t); 
        }
        else ;
        t.height=Math.max(height(t.left),height(t.right))+1;
        return t;
    }
    
    
    public void remove(T targetData)
    {
        root = remove(root, targetData);
    }
    
    //recursive removal
    private Node<T> remove(Node<T> current, T targetData)
    {
        //empty
        if(current == null)
        {
            return null;
        }
        
        //compare
        int comparison = targetData.compareTo(current.getData());
        
        //match found
        if(comparison == 0)
        {
            size--;
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
        else if(comparison < 0){
           
            if(height(current.left)-height(current.right)==2)
                if(current.left.getData().compareTo(targetData)>0)
                    current=rotateWithLeftChild(current);
                else    
                    current=doubleWithLeftChid(current);
            
            current.left = remove(current.left, targetData);
            current.height = Math.max(height(current.left),height(current.right))+1;
        }
        //search right
        else{
            
            if(height(current.right)-height(current.left)==2)
                if(current.right.getData().compareTo(targetData)<0)
                    current=rotateWithRightChild(current);
                else    
                    current=doubleWithRightChild(current);
            current.right = remove(current.right, targetData);
            current.height = Math.max(height(current.left),height(current.right))+1;
        }  
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
    public Node doubleWithLeftChid(Node t){
        t.left = rotateWithRightChild(t.left);
        return rotateWithLeftChild(t);
    }
    public Node doubleWithRightChild(Node t){
        t.right = rotateWithLeftChild(t.right);
        return rotateWithRightChild(t);
    }
    private Node rotateWithLeftChild(Node p)  // left left
    {
        Node c3=p.left.right;
        Node A=p.left;
        Node B=A.left;
        p.left=c3;
        A.right=p;
        return A;
    }
    
    private Node rotateWithRightChild(Node p) // right right
    {
        Node c3=p.right.left;
        Node A=p.right;
        Node B=A.right;
        p.right=c3;
        A.left=p;
        return A;
    }
    
    private int getHeightFactor(Node fun)
    {
        int LeftH= fun.left==null? 0:fun.left.height;
        int RightH= fun.right==null? 0:fun.right.height;
        return LeftH-RightH;
    }
    
    
    private void swapChildren(Node<T> n)
    {
        Node<T> temp = n.left;
        n.left = n.right;
        n.right = temp;
    }
    
    //obtain the node with the target data
    public int findNode(Node<T> current, T targetData)
    {
        
        //base case - empty tree or nothing found
        if(current == null)
            return current.height+1;
        
        //compare
        int comparison = targetData.compareTo(current.getData());
        
        //base case - targetData found
        if(comparison == 0)
            return current.height+1;
        
        //search left
        else if(comparison < 0)
            return findNode(current.left, targetData);
        
        //search right
        else
            return findNode(current.right, targetData);
    }
    public int findNode(T targetData){
        int level =findNode(root, targetData);

        return level;
         
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
    
    public int getHeight()
    {
        return getHeight(root);
    }
    
    private int getHeight(Node current)
    {
        if(current==null)
            return 0;
        else if(current.left==null && current.right==null)
            return 1;
        else 
            return Math.max(getHeight(current.left),getHeight(current.right))+1;
    }
    
    public Node getRoot()
    {
        return root;
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