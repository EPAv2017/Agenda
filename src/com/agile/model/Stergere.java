/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agile.model;

import java.util.List;

/**
 *
 * @author Rodica
 */
public class Stergere 
{
    public static List<Abonat> stergereElem(List<Abonat> lista, int index)
    {
        lista.remove(index);
        return lista;
    }
    
    public static List<Abonat> stergereTot(List<Abonat> lista)
    {
        lista.clear();
        return lista;
    }
    
    public static boolean checkIndex(List<Abonat> lista, int index)
    {
        int size = lista.size();
        return index >= 0 && index < size;        
    }
}
