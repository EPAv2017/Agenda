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
public class Modifica 
{
    public static boolean modificaAbonatNume(String nume)
    {    
        return !nume.equals("");
    }
    
    public static boolean modificaAbonatPrenume(String prenume)
    {
        return !prenume.equals("");
    }
    
    public static boolean modificaAbonatCNP(List<Abonat> lista, String cnp)
    {
        boolean unic = true;
        
        for (Abonat ab : lista) {
            if (ab.getCNP().equals(cnp))
            {
                unic = false;
                break;
            }
        }
        
        return cnp.length()==13 && cnp.matches("^[0-9]+$") && unic;
    }
    
    public static boolean modificaAbonatTel(NrTelefon nr)
    {
        return nr.getNumar().length()==10 && nr.getNumar().matches("^[0-9]+$");
    }
    
    
    public static boolean checkIndex(List<Abonat> lista, int index)
    {
        int size = lista.size();
        return index >= 0 && index < size;        
    }
}
