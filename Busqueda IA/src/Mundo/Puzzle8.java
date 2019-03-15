/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mundo;

import java.util.Hashtable;

public class Puzzle8 implements Cloneable
        
        
      
        
        
{ // Atributos
     private int puzzle[][];
     private int row, col;
          public int n;   
  // Constructor
     public Puzzle8()
     { puzzle = new int [3][3];
     this.puzzle=puzzle;
     n=puzzle.length;
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
     
     public void Clonado(String clon)
     { String vec[] = clon.split("");
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
    	 Puzzle8 obj=null;
         try{
             obj=(Puzzle8)super.clone();
         }catch(CloneNotSupportedException ex){
             System.out.println(" no se puede duplicar");
         }
         obj.puzzle=(int[][])obj.puzzle.clone();
         for(int i=0; i<obj.puzzle.length; i++){
             obj.puzzle[i]=(int[])obj.puzzle[i].clone();
         }
         
         //System.out.println("El clon es :" + obj);
         return obj;  
     } 
     
     public void iniciar()
     {
    	 String state = null;
		init(state);
    	 key();
    	 Hashtable<String, String> tablero = new Hashtable<String,String>();
    	 tablero.put(key(), state );
    	 System.out.println(tablero);
     }
     
     public String toString(){
         String texto="";
         for(int i=0; i<n; i++){
             for(int j=0; j<n; j++){
             texto+=""+puzzle[i][j];
             }
             texto+="";
         }
         texto+="";
         return texto;
    }
     
}
