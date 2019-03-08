/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mundo;

/**
 *
 * @author Giovanni Fajardo Utria
 */
public class Puzzle8 implements Cloneable
{ // Atributos
     private int puzzle[][];
     private int row, col;
             
  // Constructor
     public Puzzle8()
     { puzzle = new int [3][3];
     }
     
  // Getters 
     public int[][] getPuzzle()
     { return puzzle;
     }
     
     public int getRow() { return row; }
     public int getCol() { return col; }
          
  // Metodos funcionales
     public boolean solution(String solution)
     { return solution.equals("123456780");         
     }
     
     public void init(String state)
     { String vec[] = state.split("");
       int k = 0;
       for (int i = 0; i< 3; i++)  
       {for (int j = 0; j< 3; j++)  
        {     puzzle[i][j] = Integer.parseInt(vec[k]);
              if (puzzle[i][j] == 0)
              { row = i; col = j;                  
              }    
              k++;
        }
       }
     }
     
     public boolean up()
     { if (row > 0) 
       {   puzzle[row][col] = puzzle[row-1][col];
           puzzle[row-1][col] = 0;
           row--;
           return true;
       }
       return false;
     }

     public boolean down()
     { if (row < 2) 
       {   puzzle[row][col] = puzzle[row+1][col];
           puzzle[row+1][col] = 0;
           row++;
           return true;
       }
       return false;
     }
     
     public boolean left()
     { if (col > 0) 
       {   puzzle[row][col] = puzzle[row][col-1];
           puzzle[row][col-1] = 0;
           col--;
           return true;
       }
       return false;
     }
     
     public boolean right()
     { if (col < 2) 
       {   puzzle[row][col] = puzzle[row][col+1];
           puzzle[row][col+1] = 0;
           col++;
           return true;
       }
       return false;
     }
     
     public String key()
     { String key="";
       for (int i = 0; i< 3; i++)  
        for (int j = 0; j< 3; j++)  
             key = key + puzzle[i][j];
       return key;
     } 

     public Object clone()
     {
       return "";  
     }        
}
