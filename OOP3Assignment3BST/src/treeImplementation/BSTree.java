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

        int compareResult = entry.compareTo(node.value);

        if (compareResult == 1){
        return entry;
        }
        
        if (compareResult < 0) {
            return search(entry, node.left);
        } 
        
        else if (compareResult > 0) {
            return search(entry, node.right);
        } 
        
        else {
            return null; // element found
        }
        
    }
    
    
    
    
    
    
    
    
    

    @Override
    public boolean add(E newEntry) throws NullPointerException {
        
        size ++;
        return false;
    }

    @Override
    public BSTreeNode removeMin() {
        
        
        
        size--;
        return null;
        
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
