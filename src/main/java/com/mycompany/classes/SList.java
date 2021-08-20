/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.classes;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vasqu
 */
public class SList implements ILinkedListTDA {
    private Node first;
    private Node last;
    public int quantity;
    public int sumAge=0;
    public float average;
    public int higher;
    public int less=0;
    public int positionVerify;
    public int positionChange;
    
    //getter and setters
    public int getSumAge() {
        return sumAge;
    }
    public void setSumAge(int sumAge) {
        this.sumAge = sumAge;
    }
    public float getAverage() {
        return average;
    }
    public void setAverage(float average) {
        this.average = average;
    }
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
    //function
    
    public float averageAge(){
        if(sumAge==0){
     
            average=0;
        }else{
            
            average=sumAge/quantity;
        }
        return average;
    
    }
    public int lessAge(){
        if(first==null){
        try {
                throw new Exception("empty list");
            } catch (Exception ex) {
                Logger.getLogger(SList.class.getName()).log(Level.SEVERE, null, ex);
            }         
        }else{
        
            positionVerify=0;
            positionChange=0;
            Node current=first;
            higher=first.getValue().getAge();
            while(current.getNext()!=null){
            positionChange++;
                if(current.getNext().getValue().getAge()<=higher){
            
                    higher=current.getNext().getValue().getAge();
                    positionVerify=positionChange;
                    
                }
                current=current.getNext();
                
            }
            positionVerify=positionVerify+1;
        }
        System.out.println("pequeno"+higher);
        
        return positionVerify;
    
    }
    public int higherAge(){
        if(first==null){
        try {
                throw new Exception("empty list");
            } catch (Exception ex) {
                Logger.getLogger(SList.class.getName()).log(Level.SEVERE, null, ex);
            }         
        }else{
        
            positionVerify=0;
            positionChange=0;
            Node current=first;
            higher=first.getValue().getAge();
            while(current.getNext()!=null){
            positionChange++;
                if(current.getNext().getValue().getAge()>=higher){
            
                    higher=current.getNext().getValue().getAge();
                    positionVerify=positionChange;
                    
                }
                current=current.getNext();
              
            }
            positionVerify=positionVerify+1;
            System.out.println("grande:"+higher);
        }
        
        return positionVerify;
    
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
            sumAge=sumAge+newNode.getValue().getAge();
        //verify if the string is smaller than first
        }else if(s.getName().compareTo(first.getValue().getName())<0){
        
            newNode.setNext(first);
            first=newNode;
            sumAge=sumAge+newNode.getValue().getAge();
        //verify if the string is grater than last
        }else if(last.getValue().getName().compareTo(s.getName())<=0){

            last.setNext(newNode);
            last=last.getNext();
            sumAge=sumAge+newNode.getValue().getAge();
        
        }else{
       
            
            Node current=getFirst();
            //go trough to the list until null
            while(current.getNext()!=null){
            
                //when find the position, put in and break
                if(current.getNext().getValue().getName().compareTo(s.getName())>=0){
                
                    newNode.setNext(current.getNext());
                    current.setNext(newNode);
                    sumAge=sumAge+newNode.getValue().getAge();
                    break;
                }else{
                
                    current=current.getNext();
                }
            }
            
        }
    }

    @Override
    public Node indexFind(int index){

        int count=0;
        Node current=getFirst();
        if(index>quantity || index<=0){
        
            try {
                throw new Exception("index doesn't exist");
            } catch (Exception ex) {
                Logger.getLogger(SList.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else if(current==null){
            try {
                throw new Exception("the list is empty");
            } catch (Exception ex) {
                Logger.getLogger(SList.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        }else if(index==1){
       
            current=first;
            
        }else if(index==quantity){
        
            current=last;
        }else{
        
            while(count<index-1){
            
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
        if(index>quantity || index<=0){
        
            try {
                throw new Exception("index doesn't exist");
            } catch (Exception ex) {
                Logger.getLogger(SList.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else if(current==null){
            
        try {
                throw new Exception("the list is empty");
            } catch (Exception ex) {
                Logger.getLogger(SList.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else if(index==1){
       
            deleteFirst();
        }else if(index==quantity){
        
            deleteLast();
        }else{
        
            while(count<index-1){
            
                count++;
                current=current.getNext();
            }
            sumAge=sumAge-current.getNext().getValue().getAge();
            current.setNext(current.getNext().getNext());
            quantity--;
        }
        
    }

    @Override
    public Node findFirst() {

        if(first==null){
        
            try {
                throw new Exception("the list is empty");
            } catch (Exception ex) {
                Logger.getLogger(SList.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return first;
    }

    @Override
    public Node findLast() {

        if(first==null){
        
            try {
                throw new Exception("the list is empty");
            } catch (Exception ex) {
                Logger.getLogger(SList.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return last;
    }

    @Override
    public void deleteFirst() {

        if(first==null){
        
            try {
                throw new Exception("the list is empty");
            } catch (Exception ex) {
                Logger.getLogger(SList.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
        sumAge=sumAge-first.getValue().getAge();
        first=first.getNext();
        quantity=quantity-1;
        }
            }

    @Override
    public void deleteLast() {

        if(last==null){
        
            try {
                throw new Exception("the list is empty");
            } catch (Exception ex) {
                Logger.getLogger(SList.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
        quantity=quantity-1;
        Node current=getFirst();
        while(current.getNext()!=last){
            
            current=current.getNext();
        }
        sumAge=sumAge-last.getValue().getAge();
        last=current;
        last.setNext(null);      
        }
        
        

        

        
    }

    @Override
    public void clean() {
        this.first=null;
        this.quantity=0;
        this.sumAge=0;
    }
}
