/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import java.awt.List;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Scanner;
import Mundo.Puzzle8;

/**
 *
 * @author BOG-A410-E-025
 */
public class InterfazApp 
{

    /**
     * @param args the command line arguments
     * @throws Exception 
     */
	
	static ArrayList<String> tabla = new ArrayList<String>();
    public static void main(String[] args) throws Exception 
    { 
    	InterfazApp s = new InterfazApp();
    	String state;
      	Scanner sc = new Scanner(System.in); 
      	state = sc.nextLine();
    	int i = -1;
    	Puzzle8 puzzle = new Puzzle8();
    	Puzzle8 matrix = new Puzzle8();
    	String solution = "123456780";
    	puzzle.init(state);
    	matrix.init(state);
    	ArbolNario arbol1 = new ArbolNario();
    	arbol1.insertarHijo(null, state);
    	Hashtable<String, String> tablero = new Hashtable<String,String>();	
    	//ArrayList<String> tabla = new ArrayList<String>();
    	tablero.put(puzzle.key(), puzzle.key());
    	String reiniciar = state;

      	
      	while(!tablero.contains(solution)) {
      		
      	
      	puzzle.init(reiniciar);
      	
      	
      	if(!tablero.contains(solution))
      	{
      		//System.out.println("U");
      		puzzle.up();
      		if (!tablero.contains(puzzle.key())) 
      		{
				arbol1.insertarHijo(reiniciar, puzzle.key());
				tablero.put(puzzle.key(), puzzle.key());
				tabla.add(puzzle.key());
			}
      		
      	}
      	
      	puzzle.init(reiniciar);
      	
      	if(!tablero.contains(solution))
      	{
      		//System.out.println("D");
      		puzzle.down();
      		if (!tablero.contains(puzzle.key())) 
      		{
				arbol1.insertarHijo(reiniciar, puzzle.key());
				tablero.put(puzzle.key(), puzzle.key());
				tabla.add(puzzle.key());
			}
      		
      	}
      	
      	puzzle.init(reiniciar);
      	
      	if(!tablero.contains(solution))
      	{
      		//System.out.println("R");
      		puzzle.right();
      		if (!tablero.contains(puzzle.key())) 
      		{
				arbol1.insertarHijo(reiniciar, puzzle.key());
				tablero.put(puzzle.key(), puzzle.key());
				tabla.add(puzzle.key());
			}
      		
      	}
      	
      	puzzle.init(reiniciar);
      	
      	if(!tablero.contains(solution))
      	{
      		//System.out.println("L");
      		puzzle.left();
      		if (!tablero.contains(puzzle.key())) 
      		{
				arbol1.insertarHijo(reiniciar, puzzle.key());
				tablero.put(puzzle.key(), puzzle.key());
				tabla.add(puzzle.key());
			}
      		
      	}
      	//if(tabla.size()   > i)
      	{
      		i++;
      		reiniciar = tabla.get(i);
      	}
      	//reiniciar = tabla.get(i);
      	//System.out.println("INDICE " + i + "TAMAÑO TABLA " + tabla.size());
      	
      	
      	}
      	

      	
      	System.out.println("Solución encontrada ");
      	
      	System.out.println("La solución se encontró en ");
      	System.out.println(s.buscarIndice("123456780") + " Movimientos");
      	
      	
    }
    
    
    public int buscarIndice(String r){
        int index = -1;
        int bound = tabla.size();
        for (int userInd = 0; userInd < bound; userInd++) {
            if (tabla.get(userInd).equals(r)) {
                index = userInd;
                break;
            }
        }
        return index;
    }
    
    
}