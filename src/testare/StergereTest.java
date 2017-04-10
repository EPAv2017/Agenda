/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testare;

import static org.junit.Assert.*;

import java.util.List;

import com.agile.model.Abonat;
import com.agile.model.Stergere;

import com.agile.model.CarteDeTelefon;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Assume;

/**
 *
 * @author Rodica
 */
public class StergereTest {
    
    private static CarteDeTelefon ct;
    private static int dimensiune;
    
    private static void citesteCarteDeTelefon() throws ClassNotFoundException, IOException 
    {
        FileInputStream fis;
		ObjectInputStream ois;
		fis = new FileInputStream("D:\\carteDeTelefon.ser");
		ois = new ObjectInputStream(fis);
        ct = (CarteDeTelefon) ois.readObject();
        dimensiune = ct.getListaAbonati().size();
    }
    
    private static List<Abonat> copiere()
    {
        Iterator it = ct.getListaAbonati().iterator();
        List<Abonat> lista = new ArrayList();
        while (it.hasNext())
        {
            Abonat ab = (Abonat)it.next();
            lista.add(ab);
        }
        return lista;
    }
            
    
    @BeforeClass
    public static void setUpClass() 
    {
        try
        {
            citesteCarteDeTelefon();
	    Assume.assumeTrue("Agenda vida", !ct.getListaAbonati().isEmpty());
        }
        catch(IOException | ClassNotFoundException e) {e.printStackTrace();}
    }
    
        
     @Test
     public void stergereCompleta()
     {
         List<Abonat> lista = copiere();
         lista = Stergere.stergereTot(lista);
         assertEquals(true, lista.isEmpty());
     }
     
     @Test
     public void listaNevida()
     {
         assertTrue(dimensiune > 0);
     }
     
     
     @Test
     public void indexNegativ()
     {
         List<Abonat> lista = copiere();
         assertEquals(false, Stergere.checkIndex(lista, -1));
         
     }
     
     @Test
     public void indexOver()
     {
         List<Abonat> lista = copiere();
         assertEquals(false, Stergere.checkIndex(lista, dimensiune));
         
     }
     
     @Test
     public void indexZero()
     {
         List<Abonat> lista = copiere();
         assertEquals(true, Stergere.checkIndex(lista, 0));         
     }
     
     @Test
     public void indexMediu()
     {
         List<Abonat> lista = copiere();
         assertEquals(true, Stergere.checkIndex(lista, dimensiune/2));         
     }
     
     @Test
     public void indexDim()
     {
         List<Abonat> lista = copiere();
         assertEquals(true, Stergere.checkIndex(lista, dimensiune-1));         
     }
     
     @Test
     public void stergereElementZero()
     {
         List<Abonat> lista = copiere();
         
         Abonat ab = lista.get(0);
         lista = Stergere.stergereElem(lista, 0);
         assertFalse(lista.contains(ab));
     }
     
     @Test
     public void stergereElementMediu()
     {
         List<Abonat> lista = copiere();
                       
         int i = dimensiune/2;
         Abonat ab = lista.get(i);
         lista = Stergere.stergereElem(lista, i);
         assertFalse(lista.contains(ab));
     }
     
     @Test
     public void stergereElementUltim()
     {
         List<Abonat> lista = copiere();
         
         int i = dimensiune - 1;
         Abonat ab = lista.get(i);
         lista = Stergere.stergereElem(lista, i);
         assertFalse(lista.contains(ab));
     }
}
