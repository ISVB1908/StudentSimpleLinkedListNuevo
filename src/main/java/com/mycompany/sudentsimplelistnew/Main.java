/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sudentsimplelistnew;

import com.mycompany.classes.SList;

/**
 *
 * @author vasqu
 */
public class Main {
    public static void main(String[] args) {
        SList list = new SList();
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
        list.print();
        list.getLast();
        System.out.println("probar last:"+list.findLast().getValue().getName());

    }
    
}
