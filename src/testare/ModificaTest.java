/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testare;

import com.agile.model.Abonat;
import com.agile.model.CarteDeTelefon;
import com.agile.model.Modifica;
import com.agile.model.NrTelefon;
import com.agile.model.Stergere;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;
import java.util.Random;

import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Assume;

/**
 *
 * @author Rodica
 */
public class ModificaTest 
{  
    private static CarteDeTelefon ct;
    private static int dimensiune ;
    
    private static void citesteCarteDeTelefon() throws ClassNotFoundException, IOException 
    {
        FileInputStream fis;
	ObjectInputStream ois;
	fis = new FileInputStream("D:\\carteDeTelefon.ser");
	ois = new ObjectInputStream(fis);
        ct = (CarteDeTelefon) ois.readObject();
        dimensiune = ct.getListaAbonati().size();
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
    public void numeDa()
    {
        String nume = "abc";
        assert(Modifica.modificaAbonatNume(nume));
        
    }
    
    @Test
    public void numeNu()
    {
        String nume = "";
        assert(!Modifica.modificaAbonatNume(nume));
        
    }
    
    @Test
    public void prenumeDa()
    {
        String prenume = "dea";
        assert(Modifica.modificaAbonatPrenume(prenume));
        
    }
    
    @Test
    public void prenumeNu()
    {
        String prenume = "";
        assert(!Modifica.modificaAbonatPrenume(prenume));
        
    }
    
    @Test
    public void cnpDa()
    {
        String cnp = "1234567891230";
        assert(Modifica.modificaAbonatCNP(ct.getListaAbonati(), cnp));
        
    }
    
    @Test
    public void cnpDimNu()
    {
        String cnp = "123456789123";
        assert(!Modifica.modificaAbonatCNP(ct.getListaAbonati(), cnp));
        
    }
    
    @Test
    public void cnpLitereNu()
    {
        String cnp = "12345678912w0";
        assert(!Modifica.modificaAbonatCNP(ct.getListaAbonati(), cnp));
        
    }
    
    @Test
    public void cnpVid()
    {
        String cnp = "";
        assert(!Modifica.modificaAbonatCNP(ct.getListaAbonati(), cnp));
        
    }
    
    @Test
    public void cnpExistent()
    {
        int index = ct.getListaAbonati().size();
        Random rd = new Random();
        int nr = rd.nextInt(index);        
        String cnp = ct.getListaAbonati().get(nr).getCNP();
        assert(!Modifica.modificaAbonatCNP(ct.getListaAbonati(), cnp));  
    }
    
    @Test
    public void telDa()
    {
        NrTelefon nr = new NrTelefon("1234567890") {};
        assert(Modifica.modificaAbonatTel(nr));
        
    }
    
    @Test
    public void telDimNu()
    {
        NrTelefon nr = new NrTelefon("134567890") {};
        assert(!Modifica.modificaAbonatTel(nr));
        
    }
    
    @Test
    public void telLitereNu()
    {
        NrTelefon nr = new NrTelefon("12345bn890") {};
        assert(!Modifica.modificaAbonatTel(nr));
        
    }
    
    @Test
    public void telVid()
    {
        NrTelefon nr = new NrTelefon("") {};
        assert(!Modifica.modificaAbonatTel(nr));
    }
    
    @Test
     public void indexNegativ()
     {
         List<Abonat> lista = ct.getListaAbonati();
         assertEquals(false, Stergere.checkIndex(lista, -1));
         
     }
     
     @Test
     public void indexOver()
     {
         List<Abonat> lista = ct.getListaAbonati();
         assertEquals(false, Stergere.checkIndex(lista, dimensiune));
         
     }
     
     @Test
     public void indexZero()
     {
         List<Abonat> lista = ct.getListaAbonati();
         assertEquals(true, Stergere.checkIndex(lista, 0));         
     }
     
     @Test
     public void indexMediu()
     {
         List<Abonat> lista = ct.getListaAbonati();
         assertEquals(true, Stergere.checkIndex(lista, dimensiune/2));         
     }
     
     @Test
     public void indexDim()
     {
         List<Abonat> lista = ct.getListaAbonati();
         assertEquals(true, Stergere.checkIndex(lista, dimensiune-1));         
     }
}
