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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void indexDelete(int index) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Node findFirst() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Node findLast() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteFirst() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteLast() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void clean() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
