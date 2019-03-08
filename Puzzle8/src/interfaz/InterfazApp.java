/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import java.util.Scanner;
import mundo.Puzzle8;

/**
 *
 * @author BOG-A410-E-025
 */
public class InterfazApp 
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    { Puzzle8 puzzle = new Puzzle8();
      String state;
      
      Scanner sc = new Scanner(System.in); 
      state = sc.nextLine();
      
      puzzle.init(state);
      System.out.println(puzzle.key());
      
      puzzle.left();
      System.out.println(puzzle.key());
      puzzle.up();
      System.out.println(puzzle.key());
      puzzle.right();
      System.out.println(puzzle.key());
      puzzle.down();
      System.out.println(puzzle.key());
      puzzle.left();
      System.out.println(puzzle.key());
      
    }
    
}
