package com.path.finder;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class PathFinder {
	
	
	
	
	
	
    public int          distances[];
    private Set<Integer> checked;
    private Set<Integer> unchecked;
    private int          number_of_citys;
    private int          citys[][];
 
    public PathFinder(int number_of_citys)
    {
        this.number_of_citys = number_of_citys;
        distances = new int[number_of_citys + 1];
        checked = new HashSet<Integer>();
        unchecked = new HashSet<Integer>();
        citys = new int[number_of_citys + 1][number_of_citys + 1];
    }
 
    public void dijkstra_algorithm(int citys[][], int source)
    {
        int evaluationNode;
        for (int i = 1; i <= number_of_citys; i++)
            for (int j = 1; j <= number_of_citys; j++)
                this.citys[i][j] = citys[i][j];
 
        for (int i = 1; i <= number_of_citys; i++)
        {
            distances[i] = Integer.MAX_VALUE;
        }
 
        unchecked.add(source);
        distances[source] = 0;
        while (!unchecked.isEmpty())
        {
            evaluationNode = getNodeWithMinimumDistanceFromunchecked();
            unchecked.remove(evaluationNode);
            checked.add(evaluationNode);
            evaluateNeighbours(evaluationNode);
        }
    }
 
    private int getNodeWithMinimumDistanceFromunchecked()
    {
        int min;
        int node = 0;
 
        Iterator<Integer> iterator = unchecked.iterator();
        node = iterator.next();
        min = distances[node];
        for (int i = 1; i <= distances.length; i++)
        {
            if (unchecked.contains(i))
            {
                if (distances[i] <= min)
                {
                    min = distances[i];
                    node = i;
                }
            }
        }
        return node;
    }
 
    private void evaluateNeighbours(int evaluationNode)
    {
        int edgeDistance = -1;
        int newDistance = -1;
 
        for (int destinationNode = 1; destinationNode <= number_of_citys; destinationNode++)
        {
            if (!checked.contains(destinationNode))
            {
                if (citys[evaluationNode][destinationNode] != Integer.MAX_VALUE)
                {
                    edgeDistance = citys[evaluationNode][destinationNode];
                    newDistance = distances[evaluationNode] + edgeDistance;
                    if (newDistance < distances[destinationNode])
                    {
                        distances[destinationNode] = newDistance;
                    }
                    unchecked.add(destinationNode);
                }
            }
        }
    }
 
	
	
	
	
	
	

}
