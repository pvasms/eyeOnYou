package com.path.finder;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ShortestPathFinder {
	
	
	
	public static void main(String... arg)
    {
        int citys[][];
        int number_of_citys;
        int source = 0, destination = 0;
        Scanner scan = new Scanner(System.in);
        try
        {
            System.out.println("Enter the number of citys");
            number_of_citys = scan.nextInt();
            citys = new int[number_of_citys + 1][number_of_citys + 1];
 
            System.out.println("Enter distance beetween citys");
            for (int i = 1; i <= number_of_citys; i++)
            {
                for (int j = 1; j <= number_of_citys; j++)
                {  
                	System.out.println("Distence from " +i+ "to "+j+" -> :  ");
                	
                    citys[i][j] = scan.nextInt();
                    if (i == j)
                    {
                        citys[i][j] = 0;
                        continue;
                    }
                    if (citys[i][j] == 0)
                    {
                        citys[i][j] = Integer.MAX_VALUE;
                    }
                }
            }
            
            
            System.out.println("Generated matrix is :"+Integer.MAX_VALUE);
            
             
            
            for (int i = 1; i <= number_of_citys; i++)
            {
                for (int j = 1; j <= number_of_citys; j++)
                {  
                	
                	System.out.print("  [ "+i+" ] [ " +j +" ]  -: "+citys[i][j]);
                }
                
                System.out.println();
            
            }
            System.out.println("Enter the source city");
            source = scan.nextInt();
 
            System.out.println("Enter the destination city ");
            destination = scan.nextInt();
 
            PathFinder pathFinder = new PathFinder(number_of_citys);
            pathFinder.dijkstra_algorithm(citys, source);
 
            System.out.println("The Shorted Path from " + source + " to " + destination + " is: ");
            for (int i = 1; i <= pathFinder.distances.length - 1; i++)
            {
                if (i == destination)
                    System.out.println(source + " to " + i + " is "
                            + pathFinder.distances[i]);
            }
        } catch (InputMismatchException inputMismatch)
        {
            System.out.println("Wrong Input Format");
        }
        scan.close();
    }
	
	
	
	
	
	
	
	
	
	

}
