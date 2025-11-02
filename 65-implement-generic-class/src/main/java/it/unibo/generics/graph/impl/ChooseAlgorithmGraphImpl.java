package it.unibo.generics.graph.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ChooseAlgorithmGraphImpl<N> extends GraphImpl<N> {
    
    @Override
    public List<N> getPath(N source, N target) {
        System.out.print(
            "Please select which algorithm to use [0 for BFS, 1 for DFS]: ");
        int choice = Integer.parseInt(System.console().readLine());
        if(choice==0) {
            return getPathBFS(source, target);
        } else if(choice==1) {
            return getPathDFS(source, target);
        } else {
            System.out.println("Please insert 0 or 1!");
            getPath(source, target);
        }
        return null;
        
    }

    public List<N> getPathBFS(N source, N target) {
        return super.getPath(source, target);
    }

    public List<N> getPathDFS(N source, N target) {
        Set<N> visited = new HashSet<>();
        List<N> path = new ArrayList<>();
        if(recursiveDFS(source,target,visited,path)) {
            return path;
        }
        return null;
    }

    private boolean recursiveDFS(N current, N destination, Set<N> visited, List<N> path) {
        visited.add(current);
        path.add(current);

        if(current.equals(destination)) {
            return true;
        }

        for(N neighbor : mapForGraph.get(current)) {
            if(!visited.contains(neighbor)) {
                if(recursiveDFS(neighbor, destination, visited, path)) {
                    return true;
                }
            }
        }

        path.remove(path.size() - 1);
        return false;
    }
}
