package Controller;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author NguyenGiap
 */
public class ArrayQueue<T> {
    T data[];
    int front;
    int back;
    int size;
    int cap;
    
    
    public ArrayQueue(int data){
        this.data = (T[]) new Object[data];
        this.front = -1;
        this.back = -1;
        this.size = 0;
        this.cap = data;
        
    }
    
    public boolean isFull()
    {
        return size == cap;
    }
    
    public boolean isEmpty(){
        return this.size == 0;
    }
    public void enQueue(T data){
        if(isFull()){
            System.out.println("Queue is full");
        }
        if (this.front == -1) {
            this.front = 0;
            this.back = 0;
            this.data[0] = data;
            size++;
            return;
        }
        if (this.size == 0) {
            this.front = (this.front+1)%this.cap;
        }
        this.back = (this.back+1) % this.cap;
        this.data[back] = data;
        this.size++;
    }
    public void clear(){
        
        this.front = -1;
        this.back = -1;
        this.size = 0;
    }
    public T deQueue(){
        if (isEmpty()) {
            System.out.println("Queue is emptY");
            return null;
        }
        if(this.size == 1){
            T value = this.data[front];
            this.clear();
            return value;
        }
        T value = this.data[front];
        this.data[front] = null;
        this.front = (this.front+1)%this.cap;
        size--;
        return value;
        
    }
    
    public void traverse(){
        for (int i = 0; i < size; i++) {
            System.out.print(this.data[(this.front + i) % cap]+ " ");
        }
        System.out.println("");
    }
    
    
    
    
}
