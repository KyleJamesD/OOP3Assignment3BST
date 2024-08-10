/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package treeImplementation;

/**
 *
 * @author Will
 */
public class BSTreeNode<E extends Comparable<? super E>> {
    private E element;
    private BSTreeNode<E> left;
    private BSTreeNode<E> right;

    public BSTreeNode(E element) {
        this.element = element;
        this.left = null;
        this.right = null;
    }

    // Getter and setter for element
    public E getElement() {
        return element;
    }

    public void setElement(E element) {
        this.element = element;
    }

    // Getter and setter for left child
    public BSTreeNode<E> getLeft() {
        return left;
    }

    public void setLeft(BSTreeNode<E> left) {
        this.left = left;
    }

    // Getter and setter for right child
    public BSTreeNode<E> getRight() {
        return right;
    }

    public void setRight(BSTreeNode<E> right) {
        this.right = right;
    }
}