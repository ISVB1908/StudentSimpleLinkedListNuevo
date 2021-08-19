/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sudentsimplelistnew;

import com.mycompany.classes.SList;
import java.awt.HeadlessException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author vasqu
 */
public class Main {
    public static void main(String[] args) {
        String addName;
        int addAge;
        int indexSearch;
        SList list = new SList();
        int input =-1;
        do{
        
            JOptionPane.showMessageDialog(null,"1.Add \n2.Search for position \n3.Delete for position \n4.Get first \n5.Get last"
                    + "\n6.Delete first \n7.Delete last \n8.clean \n9.print \n0.exit");
            input=Integer.parseInt(JOptionPane.showInputDialog("Digite un numero"));
            switch(input){
            
                case 1:
                    //add
                    addName=JOptionPane.showInputDialog("Digite el nombre:");
                    addAge=Integer.parseInt(JOptionPane.showInputDialog("Digite la edad:"));
                    list.add(addName, addAge);
                    JOptionPane.showMessageDialog(null,"Nombre:"+addName+"\nage:"+addAge+"\nFue agregado!");
                    break;
                case 2:
                    //findindex
                    indexSearch=Integer.parseInt(JOptionPane.showInputDialog("Digite la posicion:"));
                    indexSearch=indexSearch-1;
                    try {
                        if(indexSearch<list.getQuantity() && indexSearch>=0){
                            JOptionPane.showMessageDialog(null,"Node:"+list.indexFind(indexSearch)+"\nName:"+list.indexFind(indexSearch).getValue().getName()
                            +"\nAge:"+list.indexFind(indexSearch).getValue().getAge()+list.getQuantity());
                        }else{
                        
                            JOptionPane.showMessageDialog(null,"this position doesn' exist, remember that the list start in 1st position");
                        }
                        
                    } catch (HeadlessException ex) {
                        Logger.getLogger(SList.class.getName()).log(Level.SEVERE, null, ex);
            
                    }
                    

                    break;


                case 3:
                    //indexdelete
                    indexSearch=Integer.parseInt(JOptionPane.showInputDialog("Digite la posicion:"));
                    indexSearch=indexSearch-1;
                    try {
                        if(indexSearch<list.getQuantity() && indexSearch>=0){
                            JOptionPane.showMessageDialog(null,"Node:"+list.indexFind(indexSearch)+"\nName:"+list.indexFind(indexSearch).getValue().getName()
                            +"\nAge:"+list.indexFind(indexSearch).getValue().getAge()+"\nwas been erased");
                            list.indexDelete(indexSearch);
                        }else{
                        
                            JOptionPane.showMessageDialog(null,"this position doesn' exist, remember that the list start in 1st position");
                        }
                        
                    } catch (HeadlessException ex) {
                        Logger.getLogger(SList.class.getName()).log(Level.SEVERE, null, ex);
            
                    }
                    break;
                case 4:
                    //getfirst
                    try {
                        if(list.getFirst()==null){
                            JOptionPane.showMessageDialog(null,"emptyList");
                        }else{
                        
                            JOptionPane.showMessageDialog(null,"Node:"+list.getFirst()+"\nName:"+list.getFirst().getValue().getName()
                            +"\nAge:"+list.getFirst().getValue().getAge());
                        }
                    
                    } catch (HeadlessException ex) {
                        Logger.getLogger(SList.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                case 5: 
                    //getlast
                    try {
                        if(list.getFirst()==null){
                            JOptionPane.showMessageDialog(null,"emptyList");
                        }else{
                        
                            JOptionPane.showMessageDialog(null,"Node:"+list.getLast()+"\nName:"+list.getLast().getValue().getName()
                            +"\nAge:"+list.getLast().getValue().getAge());
                        }
                    
                    } catch (HeadlessException ex) {
                        Logger.getLogger(SList.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                case 6:
                    //delete first
                    try {
                        if(list.getFirst()==null){
                            JOptionPane.showMessageDialog(null,"emptyList");
                        }else{
                        
                            JOptionPane.showMessageDialog(null,"Node:"+list.getFirst()+"\nName:"+list.getFirst().getValue().getName()
                            +"\nAge:"+list.getFirst().getValue().getAge()+"\nwas benn delete");
                            list.deleteFirst();
                        }
                    
                    } catch (HeadlessException ex) {
                        Logger.getLogger(SList.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                case 7:
                    //deletelast
                    try {
                        if(list.getFirst()==null){
                            JOptionPane.showMessageDialog(null,"emptyList");
                        }else{
                        
                            JOptionPane.showMessageDialog(null,"Node:"+list.getLast()+"\nName:"+list.getLast().getValue().getName()
                            +"\nAge:"+list.getLast().getValue().getAge()+"\nwas been delete");
                            list.deleteLast();
                        }
                    
                    } catch (HeadlessException ex) {
                        Logger.getLogger(SList.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    break;
                case 8:
                    list.clean();
                    break;
                case 9:
                    list.print();
                    break;
                case 10:
                    break;
            }
        }while(input!=0);
        list.add("perra", 0);
        list.clean();
        list.add("carlos", 0);
        list.add("david", 5);
        list.add("ana", 0);
        list.add("aaron", 0);
        list.add("x",0);
        list.add("aaron", 4);
        list.add("bobo", 0);
        list.deleteFirst();
        list.deleteLast();
        list.indexDelete(0);
        list.print();
        list.getLast();
        System.out.println("probar last:"+list.findLast().getValue().getName());
        list.getFirst();
        list.indexFind(2);
        System.out.println("probar first:"+list.findFirst().getValue().getName());
        System.out.println("index find:"+list.indexFind(3).getValue().getName());


    }
    
}
