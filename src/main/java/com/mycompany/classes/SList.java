/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.classes;

/**
 *
 * @author vasqu
 */
public class SList implements ILinkedListTDA {
        private Node first;
    private Node last;
    public int quantity;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Node getFirst() {
        return first;
    }

    public void setFirst(Node first) {
        this.first = first;
    }

    public Node getLast() {
        return last;
    }
    public void setLast(Node last) {
        this.last = last;
    }
    
    
    public int averageAge(){
        return 0;
    
    }
    public int lessAge(){
        return 0;
    
    }
    public int higherAge(){
        return 0;
    
    }
    public void print(){
                Node current=getFirst();
        while(current!=null){
            
            System.out.println("Nombre:"+current.getValue().getName()+"/     Edad:"+current.getValue().getAge());
            current=current.getNext();}
        System.out.println("size:"+quantity);
        //System.out.println("last:"+last.getValue().getName());

        
    
    }

    @Override
    public void add(String name, int age) {

        //initialize quantity
        quantity++;
        //create a new Nodo that contains student
        Node newNode = new Node();
        //create a new student that contains the name and age
        Student s =new Student(name,age);
        //add the student to the new node
        newNode.setValue(s);
        //verify if the list is empty
        if (first==null){
            first=newNode;
            last=first;
        //verify if the string is smaller than first
        }else if(s.getName().compareTo(first.getValue().getName())<0){
        
            newNode.setNext(first);
            first=newNode;
        //verify if the string is grater than last
        }else if(last.getValue().getName().compareTo(s.getName())<=0){

            last.setNext(newNode);
            last=last.getNext();
        
        }else{
       
            
            Node current=getFirst();
            //go trough to the list until null
            while(current.getNext()!=null){
            
                //when find the position, put in and break
                if(current.getNext().getValue().getName().compareTo(s.getName())>=0){
                
                    newNode.setNext(current.getNext());
                    current.setNext(newNode);
                    break;
                }else{
                
                    current=current.getNext();
                }
            }
            
        }
    }

    @Override
    public Node indexFind(int index) {

        int count=0;
        Node current=getFirst();
        if(index>=quantity || index<0){
        
            System.out.println("index doesn't exist");
        }else if(current==null){
            System.out.println("the list is empty");
        
        }else if(index==0){
       
            
        }else if(index==quantity-1){
        
            current=getLast();
        }else{
        
            while(count<index){
            
                count++;
                current=current.getNext();
            }
            
    }
            return current;
    }
    @Override
    public void indexDelete(int index) {

        int count=0;
        Node current=getFirst();
        if(index>=quantity || index<0){
        
            System.out.println("index doesn't exist");
        }else if(current==null){
            System.out.println("the list is empty");
        
        }else if(index==0){
       
            deleteFirst();
        }else if(index==quantity-1){
        
            deleteLast();
        }else{
        
            while(count<index-1){
            
                count++;
                current=current.getNext();
            }
            current.setNext(current.getNext().getNext());
            quantity--;
        }
        
    }

    @Override
    public Node findFirst() {

        return first;
    }

    @Override
    public Node findLast() {

        return last;
    }

    @Override
    public void deleteFirst() {

        first=first.getNext();
        quantity=quantity-1;    }

    @Override
    public void deleteLast() {

        quantity=quantity-1;
        Node current=getFirst();
        while(current.getNext()!=last){
            
            current=current.getNext();
        }
        last=current;
        last.setNext(null);
        

        

        
    }

    @Override
    public void clean() {
        this.first=null;
        this.quantity=0;    }
}
