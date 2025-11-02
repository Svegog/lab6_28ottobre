package it.unibo.generics.graph.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import it.unibo.generics.graph.api.Graph;

public class GraphImpl<N> implements Graph<N> {

    protected Map<N,List<N>> mapForGraph = new HashMap<>();
    protected List<N> nodeList = new ArrayList<>();

    public void addNode(N node) {
        if(!nodeList.contains(node)) {
            nodeList.add(node);
        }
    }

    public void addEdge(N source, N target) {
        if (source!=null && target!=null) {
            if(!mapForGraph.containsKey(source)) {
                mapForGraph.put(source, new ArrayList<>());
            }
            List<N> tempList = mapForGraph.get(source);
            if(!tempList.contains(target)) {
                tempList.add(target);
            }
        }
    }

    public Set<N> nodeSet() {
        return new HashSet<>(nodeList);
    }

    public Set<N> linkedNodes(N node) {
        if(mapForGraph.containsKey(node)) {
            List<N> tempList = mapForGraph.get(node);
            return new HashSet<>(tempList);
        }
        return new HashSet<>();
    }

    public List<N> getPath(N source, N target) {
        if(!mapForGraph.containsKey(source) || !mapForGraph.containsKey(target)) {
            return null;
        }

        Queue<N> queue = new LinkedList<>();
        Map<N,N> parent = new HashMap<>();
        Set<N> visited = new HashSet<>();

        queue.add(source);
        visited.add(source);

        while(!queue.isEmpty()) {
            N current = queue.poll();

            if(current.equals(target)) {
                List<N> path = new ArrayList<>();
                for(N solution = target; solution != null; solution = parent.get(solution)) {
                    path.add(solution);
                }
                Collections.reverse(path);
                return path;
            }

            for(N neighbor : mapForGraph.get(current)) {
                if(!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    parent.put(neighbor,current);
                    queue.add(neighbor);
                }
            }
        }
        return null;
    }

}
