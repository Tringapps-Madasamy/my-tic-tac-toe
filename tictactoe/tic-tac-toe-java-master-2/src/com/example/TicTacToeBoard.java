package com.example;

public class TicTacToeBoard{
      
       public static Evaluation evaluateBoard(String boardstate)
       {
           String lowstring= boardstate.toLowerCase();

           if(boardstate.length() !=9)
           {
               return Evaluation.InvalidInput;
           }
       
    int countx=0;
    int counto=0;

      for(int  i=0;i<lowstring.length();i++)
      {
         if(lowstring.charAt(i)=='x'){
         countx++;
         }
         if(lowstring.charAt(i)=='o'){
         counto++;
         }
      }
      if(Math.abs(counto - countx)>=2){
        return Evaluation.UnreachableState;
    }
    Boolean xwins = win('x',lowstring);
    Boolean owins = win('o',lowstring);
    if((xwins)&&(owins))
    {
      return Evaluation.UnreachableState;
    }
    else if(xwins)                      
    {
      return Evaluation.Xwins;
    }
    else if(owins)
    {
      return Evaluation.Owins;
    }
    else
    {
      return Evaluation.NoWinner;
    }
  }
   public static boolean win(char checker, String lowstring)
   {             
     if(lowstring.charAt(0)==checker && lowstring.charAt(1)==checker && lowstring.charAt(2)==checker)
    {
      return true;
    }
    if(lowstring.charAt(3)==checker && lowstring.charAt(4)==checker && lowstring.charAt(5)==checker)
    {
      return true;
    }
    if(lowstring.charAt(6)==checker && lowstring.charAt(7)==checker && lowstring.charAt(8)==checker)
    {
      return true;
    }
    if(lowstring.charAt(0)==checker && lowstring.charAt(3)==checker && lowstring.charAt(6)==checker)
    {
      return true;
    }
    if(lowstring.charAt(2)==checker && lowstring.charAt(9)==checker && lowstring.charAt(5)==checker)
    {
      return true;
    }
    if(lowstring.charAt(2)==checker &&lowstring.charAt(5)==checker && lowstring.charAt(8)==checker)
    {
      return true;
    }
    if(lowstring.charAt(0)==checker &&lowstring.charAt(4)==checker &&lowstring.charAt(8)==checker)
    {
      return true;
    }
    return(lowstring.charAt(2)==checker &&lowstring.charAt(4)==checker &&lowstring.charAt(6)==checker);
   }
   public static void main(String args[]){
   System.out.println(evaluateBoard("O...X.X.."));
  
    System.out.println(evaluateBoard("XXX...oo."));
    System.out.println(evaluateBoard("...Xxx.oo"));
    System.out.println(evaluateBoard("oo....xxx"));
    System.out.println(evaluateBoard("x..x..xoo"));
    System.out.println(evaluateBoard(".x..xoox."));              
    System.out.println(evaluateBoard("..xoox..x"));
    System.out.println(evaluateBoard("x...x.oox"));
    System.out.println(evaluateBoard("..x.x.xoo"));
    System.out.println(evaluateBoard("O.."));
    System.out.println(evaluateBoard("O...X.X...."));
    System.out.println(evaluateBoard("Oooxxx..."));
    System.out.println(evaluateBoard("oxooxooxo"));
   }
}

