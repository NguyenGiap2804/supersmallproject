/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author NguyenGiap
 * @param <T>
 */
public class AVLNode<T>{
    public T key;
    public AVLNode<T> parent;
    public AVLNode<T> right;
    public AVLNode<T> left;
    public int height;
    
    public AVLNode(T key) {
        
        this.left = null;
        this.right = null;
        this.parent = null;
        this.key = key;
        this.height = 1;
    }
}
