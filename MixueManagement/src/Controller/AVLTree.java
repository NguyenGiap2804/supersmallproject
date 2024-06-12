/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.AVLNode;

/**
 *
 * @author NguyenGiap
 * @param <T>
 */
public class AVLTree <T extends Comparable<T>> {
    
    public AVLNode<T> root;
    int size = 0;

    public AVLTree() {
        this.root = null;
        size = 0;
    }
    public boolean isEmpty()
    {
        return this.root == null;
    }
    
    public void add(T key) {
        if (isEmpty()) {
            this.root = new AVLNode<>(key);
            size++; 
            return;
        }
        AVLNode<T> current = root;
        AVLNode<T> parent = null;
       
        AVLNode<T> newNode = new AVLNode<>(key);
        while(current != null) {
            parent = current;
            if (key.compareTo(current.key) > 0) {
                current = current.right;
            } else if(key.compareTo(current.key) < 0) {
                current = current.left;
            } else {
                System.out.println("Key exists");
                return;
            }
        }
        
        if (key.compareTo(parent.key) < 0) {
            parent.left = newNode;
            size++;
        } else {
            parent.right = newNode;
            size++;

        }

        
    }
    
    public AVLNode addRecursive(AVLNode<T> root, T key)
    {
        AVLNode<T> newNode = new AVLNode<T>(key);
        if (root == null) {
            root = newNode;
            size++;
        }
        else{
            if (key.compareTo(root.key) > 0) {
                root.right = addRecursive(root.right, key);
            }else if(key.compareTo(root.key) < 0){
                root.left = addRecursive(root.left, key);
            }
            else{
                System.out.println("Exited");
                root = null;      
            }
        }
        int balance  =  getBalance(root);
        if (balance > 1 ) {
            if (key.compareTo(root.left.key) < 0) {
                //lech trai phai
                root = rotateLeft(root);
            }else{
                root.left = rotateLeft(root.left);
                root = rotateRight(root);
                System.out.println("lech trai phai");
            }
        }else if(balance < -1){
            System.out.println("Lech phai");
            if (root.right != null && key.compareTo(root.right.key) < 0 ){
                System.out.println("lech phai trai");
                root.right = rotateRight(root.right);
                root = rotateLeft(root);
            }else{
                System.out.println("lech phai phai");
                root = rotateLeft(root);
            }
            
        }
        return root;
        
    }
    
    
    
    
    
    
    public int getBalance(AVLNode<T> root)
    {
        return getHight(root.left) - getHight(root.right);
    }
    public void addNode(T key)
    {
        this.root = addRecursive(this.root, key);
    }
    
    
    
    
    private int getHeight(AVLNode<T> node) {
        if (node == null) {
            return 0;
        }
        return node.height;
    }

    private void updateHeight(AVLNode<T> node) {
        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));
    }

    public void BFS(AVLNode<T> root){
        ArrayQueue<AVLNode> q = new ArrayQueue<>(100);
        q.enQueue(root);
        while(!q.isEmpty()){
            AVLNode<T> current = q.deQueue();
            System.out.println(current.key + " ");
            if (current.left != null) {
                q.enQueue(current.left );
            }
            if(current.right != null) 
            {
                q.enQueue(current.right);
            }
        }
    }
    
    
    
    
//    public AVLNode addRecursive(AVLNode root, int key)
//    {
//        AVLNode newNode = new AVLNode(key);
//        if (root == null) {
//            root = newNode;
//            size++;
//        }
//        else{
//            if (root.key < key) {
//                root.right = addRecursive(root.right, key);
//            }else if(root.key > key){
//                root.left = addRecursive(root.left, key);
//            }
//            else{
//                System.out.println("Exited");
//                root = null;      
//            }
//        }
//        int balance  =  getBalance(root);
//        if (balance > 1 ) {
//            if (key < root.left.key) {
//                //lech trai phai
//                root = rootLeft(root);
//            }
//            
//        }
//        return root;
//        
//    }
//    public  int getBalance(AVLNode root)
//    {
//        return getHight(root.left) - getHight(root.right);
//    }
//    
//    public void addNode(int key)
//    {
//        this.root = addRecursive(this.root, key);
//    }
//    
//    public AVLNode removeRecursive(AVLNode root, int key)
//    {
//        if (root == null) {
//            return null;
//        }
//        else{
//            if (root.key < key) {
//                root.right = this.removeRecursive(root.right, key);
//            }else if(root.key > key){
//                root.left = this.removeRecursive(root.left, key);
//            }else if (root.key == key) {
//                if (root.left == null && root.right == null) {
//                    System.out.println("Xoa o Node la");
//                    root = null;
//                    this.size--;
//                }else if (root.left != null && root.right != null) {
//                    System.out.println("Xoa o node 2 con");
//                    AVLNode max = findMax(root.left);
//                    root.key = max.key;
//                    root.left = removeRecursive(root.left, max.key);
//                }else{
//                    if (root.right != null) {
//                        root = root.right;
//                    }else
//                    {
//                        root = root.left;
//                    }
//                    this.size--;
//                }
//            }
//        }
//        return root;
//        
//    }
    
//    public  void removeNode(int key)
//    {
//        this.root = removeRecursive(this.root, key);
//    }
    
    
    public AVLNode removeRecursive(AVLNode<T> root, T key)
    {
        if (root == null) {
            return null;
        }
        else{
            if (key.compareTo(root.key) > 0) {
                root.right = this.removeRecursive(root.right, key);
            }else if(key.compareTo(root.key) < 0){
                root.left = this.removeRecursive(root.left, key);
            }else if (root.key == key) {
                if (root.left == null && root.right == null) {
                    //System.out.println("Xoa o Node la");
                    root = null;
                    this.size--;
                }else if (root.left != null && root.right != null) {
                    //System.out.println("Xoa o node 2 con");
                    AVLNode<T> max = findMax(root.left);
                    root.key = max.key;
                    root.left = removeRecursive(root.left, max.key);
                }else{
                    if (root.right != null) {
                        root = root.right;
                    }else
                    {
                        root = root.left;
                    }
                    this.size--;
                }
            }
        }
        return root;
        
    }
    public  void removeNode(T key)
    {
        this.root = removeRecursive(this.root, key);
    }
    
    
    
    
    private AVLNode findMax(AVLNode<T> root){
        AVLNode current = root;
        while (current.right != null) {            
            current = current.right;
        }
        return  current;
    }
    
    public int max(int a, int b)
    {
        if (a > b) {
            return a;
        }
        return b;
    }
    
    public int getHight(AVLNode<T> root)
    {
        if (root  == null)
        {
            return -1;
        }
        else{
            return max(getHight(root.left), getHight(root.right)) + 1;
        }
    }
    
    public AVLNode<T> rotateLeft(AVLNode<T> root){
        AVLNode<T> temp = root.right;
        root.right = temp.left;
        temp.left = root;
        return temp;
    }
    
    public AVLNode<T> rotateRight(AVLNode<T> root)
    {
        AVLNode<T> temp = root.left;
        root.left = temp.right;
        temp.right = root;
        return temp;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
}
