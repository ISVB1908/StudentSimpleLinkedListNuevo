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
public interface ILinkedListTDA {
    public void add(String name,int age);
    public Node indexFind(int index);
    public void indexDelete(int index);
    public Node findFirst();
    public Node findLast();
    public void deleteFirst();
    public void  deleteLast();
    public void clean();  
}
