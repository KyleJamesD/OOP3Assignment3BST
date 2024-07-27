/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package treeImplementation;

import utilities.BSTreeADT;
import utilities.Iterator;

/**
 *
 * @author kyled
 */
public class BSTree<E extends Comparable<? super E>> implements BSTreeADT<E> {
    
    
    BSTreeNode<E> root;
    int size;
    
    /*******************************Begin Constructors******************************************************/
    public BSTree() {
        //construct an empty bst
        root = null;
    }

    public BSTree(E value) {
        //construct a bst with one node
        this.root = new BSTreeNode<E>(value);
    }
    
    
     /*******************************End Constructors******************************************************/
  
    public void checker(){
        System.out.println();
    }

    
    
     /*******************************Begin Class Methods******************************************************/
    @Override
    public BSTreeNode getRoot() {
        return root;
    }

    @Override
    public int getHeight() {
        return getHeightHelper(root);
        
    }
    
    
    public int getHeightHelper(BSTreeNode<E> rootnode){
        //if the tree is empty return 0
        if (rootnode == null){return 0;}
        
        int leftHeight = getHeightHelper(rootnode.left);
        int rightheight = getHeightHelper(rootnode.right);
        
        if(leftHeight > rightheight){return leftHeight+1;}
        else return rightheight+1;        
    } 
    
    
    

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        if(root == null)
            return true;
        else 
            return false;
    }
    

    @Override
    public void clear() {
        root = null;
        size = 0;
    }

    @Override
    public boolean contains(E entry) throws NullPointerException {
        if (entry == null){throw new NullPointerException();}
        return contains(entry, root);
    }

    private boolean contains(E entry, BSTreeNode<E> node) {
        if (node == null) {
            return false;
        }
        int compareResult = entry.compareTo(node.value);

        if (compareResult < 0) {
            return contains(entry, node.left);
        } 
        
        else if (compareResult > 0) {
            return contains(entry, node.right);
        } 
        
        else {
            return true; // element found
        }
        
    }

    @Override
    public BSTreeNode search(E entry) throws NullPointerException {
    /*
        if (root == null || root.value == entry)
            return root;
        if (root.value < entry)
            return search(root.right, entry);
        return search(root.left, entry);
    unfortunately because we are using generics we cannot compare in this way, we will need to implemement the compareTo Method.
    */
    if (entry == null){throw new NullPointerException();}
    return search(entry, root);
    }
    
    
    private BSTreeNode search(E entry, BSTreeNode<E> node) {
        if (node == null) {
            return null;
        }
        int compareResult = entry.compareTo(node.value);
        
        if (compareResult < 0) {
            return search(entry, node.left);
        } 
        
        if (compareResult > 0) {
            return search(entry, node.right);
        } 
        
        else //(compareResult == 0)
            return node; // element found
          
    }
    


    @Override
    public boolean add(E newEntry) throws NullPointerException {
        if (newEntry == null) {
            throw new NullPointerException();
        }
            
            if(isEmpty())
            { root = new BSTreeNode(newEntry);
            size++;
            return true;
            }            
            
            else
                add(root, newEntry);
            size ++;
            return true;
    }

    // recursively call and use the E class compareTo method for comparison* note the Class MUST have compareTo implemented
    private void add(BSTreeNode<E> node, E newEntry) {

        if(newEntry.compareTo(node.value) < 0) {
            if(node.left == null)
                node.left = new BSTreeNode(newEntry);
            else
                add(node.left, newEntry);
        }
        else {
            if(node.right == null)
                node.right = new BSTreeNode(newEntry);
            else
                add(node.right, newEntry);
        }
    }
    
    
    @Override
    public BSTreeNode removeMin() {
        //if the tree is empty
        if(isEmpty())
        {return null;}
        //if the tree only has the root node and no children
        if (root.left == null && root.right == null)
        {BSTreeNode<E> temp = root;
        clear();
        return temp;
        }
        
        //if the left sub tree is empty, replace the root with its right node, and return the root
        if(root.left == null && root.right!= null)
        {
        BSTreeNode<E> temp = root;
        root = root.right;
        size--;
        return temp;
        }
        
        //find the parent of the mindNode because traversal back up a tree requires to much overhead
       BSTreeNode<E> parentminNode = root; //= returnleftroot(root);
       BSTreeNode<E> temp;

       while (parentminNode.left.left != null)
       {
       parentminNode = parentminNode.left;
       }
       
       if (parentminNode.left.right != null)
       {
       temp = parentminNode.left;
       parentminNode.left = parentminNode.left.right;
       }
       else 
       {
       temp = parentminNode.left;
       parentminNode.left = null;
       }
       
        size--;
        return temp;
        
    }
    
    
    
   

    @Override
    public BSTreeNode removeMax() {
        size --;
        return null;

    }

    @Override
    public Iterator inorderIterator() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Iterator preorderIterator() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Iterator postorderIterator() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
   
     /*******************************End Class Methods******************************************************/
    
    /*******************************BEGIN external Classes******************************************************/

    
    
    
    
    
    
    /*************End of Class*******************/
}
