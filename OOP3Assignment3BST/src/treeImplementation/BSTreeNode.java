package treeImplementation;

import utilities.BSTreeADT;
import utilities.Iterator;

public class BSTreeNode<E> {

    public E data;
    public BSTreeNode<E> left;
    public BSTreeNode<E> right;

    public BSTreeNode(E data, BSTreeNode<E> left, BSTreeNode<E> right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public BSTreeNode(E data) {
        this.data = data;
        this.left = this.right = null;
    }

    public BSTreeNode<E> getLeft(){
        return this.left;
    }

    public void setLeft(BSTreeNode<E> left){
        this.left = left;
    }

    public BSTreeNode<E> getRight(){
        return this.right;
    }

    public void setRight(BSTreeNode<E> right){
        this.right = right;
    }

    public E getData(){
        return this.data;
    }
}