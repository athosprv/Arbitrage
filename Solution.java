   import java.io.*;
import java.util.ArrayList;
   import java.util.LinkedList;
   import java.util.Scanner;
   import java.util.Stack;

   /**
    *
    * @author Ath
    */
   public class Solution
   {      

        public static void run(BufferedReader in, PrintWriter out)        throws IOException
      {
        action(in, out);
      }
       

       public static void action(BufferedReader in, PrintWriter out)throws IOException
      {
    	   System.out.println("=============================================="); 
           String n = in.readLine();
           while(n!=null)
           {
           int numConversions = Integer.parseInt(n)+1;
           double lookupTable[][][] = new double[numConversions][numConversions][numConversions];
           String memTable[][][] = new String[numConversions][numConversions][numConversions];
           double currTable[][]= new double[numConversions][numConversions];
                    
           
           initCurrTable(numConversions, in, currTable);
           initLookupTable(lookupTable, currTable, memTable);
           fillLookupTable(lookupTable, currTable, memTable);
           out.println(findBestSequence(lookupTable, memTable));
         //printTable(memTable);
           out.flush();
           System.out.println("5) End of executions for this input!");
           System.out.println("==============================================");
           
           n=in.readLine();
           if(n=="")
        	   n=in.readLine();   

           }
           out.println();
           out.flush();
          // printTable(memTable);
           //System.out.println();

         //  System.out.println(memTable[1][1][3]);
         //  System.out.println(lookupTable[1][1][3]);
         //  System.out.println(lookupTable.length);
       }

       public static void initCurrTable(int numConversions, BufferedReader in, double currTable[][])throws IOException
       {        
         Scanner sc = new Scanner(in.readLine());

          for(int i = 1; i<numConversions; i++)
          {
              for(int j=1; j<numConversions; j++)
                  currTable[i][j] = sc.nextDouble();
              if((i+1)<numConversions)
                  sc = new Scanner(in.readLine());
          }
         System.out.println("1) Currency Table Initialized!");
       }

       /**
        *
        */
       public static void initLookupTable(double lookupTable[][][], double currTable[][], String memTable[][][])
       {          
          for(int i = 1; i<lookupTable.length; i++)
          {
              for(int j=1; j<lookupTable.length; j++)
              {
                  //for(int k=1; k<lookupTable.length; k++)
                  {
                    //  if(k==1)
                      {
                          memTable[i][j][1] = i+" "+j;
                          lookupTable[i][j][1] = currTable[i][j];
                      }
                    //  else
                     //     lookupTable[i][j][k] = -1.0;
                  }
              }
          }
         System.out.println("2) Lookup Table Initialized!");
       }

       public static void fillLookupTable(double lookupTable[][][], double currTable[][], String memTable[][][])
       {
           for(int i = 2; i<lookupTable.length; i++)
               for(int j = 1; j<lookupTable.length; j++)
                   for(int k = 1; k<lookupTable.length; k++)
                       lookupTable[j][k][i]  = max(lookupTable, currTable, j,k,i-1, memTable);
           System.out.println("3) Max values calculated. Lookup Table Complete!");
       }

       public static double max(double lookupTable[][][], double currTable[][], int from, int to, int numConvs, String memTable[][][])
       {
           double max = 0;
           double val = 0;

           for(int i = 1; i<lookupTable.length; i++)
           {
               if(i!=to)
                   val = lookupTable[from][i][numConvs]*currTable[i][to];
               else
                   val = lookupTable[from][i][numConvs];
               if(val>max)
               {
                   int prevNum = numConvs+1;
               //    System.out.println("["+from+"]"+"["+to+"]"+"["+prevNum +"] = " + memTable[from][i][numConvs] + "" + to);
                   memTable[from][to][prevNum] = memTable[from][i][numConvs]+" " +to;
                   max = val;
               }
           }
           return max;
       }

       public static String findBestSequence(double lookupTable[][][], String memTable[][][])
       {
            ArrayList <String>candidates = new ArrayList<String>();
            String sequence = "none";

           for(int i = 1; i<lookupTable.length; i++)
           {
               for(int j = 1; j<lookupTable.length; j++)
               {
            	   	if(lookupTable[i][i][j]>1.01)
            	   	{
            	   		sequence = memTable[i][i][j];
            	   		break;            	   		
            	   	}
               }
               candidates.add(sequence);
           }
           
          
           System.out.println(candidates.toString());
           
           String answer = "X";
           String finalAnswer = "11111111111111111111111111111111111111111111111111111111111111111";
           
           for(int i = 0; i<candidates.size(); i++)
           {
        	   if(candidates.get(i).equals("none"))
        	   {
        		   	candidates.remove(i);        		   
        	   }
           }   
           if(candidates.size()==0)
           {
        	   answer = "none";
        	   System.out.println("4) A valid sequence has not been found! (" + answer+")");
        	   return answer;
           }           
           else
           {
        	   for(int i = 0; i<candidates.size(); i++)
        	   {
        		   answer = candidates.get(i);
        		   if(answer.length()<finalAnswer.length())
        		   {
        			   finalAnswer = answer;
        			   System.out.println("answer: " +answer + "finalAnswer: "+ finalAnswer);
        		   }
        	   } 
        	   System.out.println("4) A valid sequence has been found! (" + finalAnswer+")");   
        	   return finalAnswer;
           }       
          
       }

       public static void printTable(String table[][][])
       {
          for(int i = 1; i<table.length; i++)
          {
              System.out.println();
              for(int j=1; j<table.length; j++)
              {
                  System.out.println();
                  for(int k=1; k<table.length; k++)
                  {
                    System.out.print(table[i][j][k] + "|");
                  }
              }
          }
          System.out.println();
       }

    }

       