package it.unibo.generics.graph.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import it.unibo.generics.graph.api.Graph;

public class GraphImpl<N> implements Graph<N> {

    private Map<N,List<N>> mapForGraph = new HashMap<>();
    private List<N> nodeList = new ArrayList<>();

    public void addNode(N node) {
        if(!nodeList.contains(node)) {
            nodeList.add(node);
        }
    }

    public void addEdge(N source, N target) {
        if(!mapForGraph.containsKey(source)) {
            mapForGraph.put(source, new ArrayList<>());
        }
        List<N> tempList = mapForGraph.get(source);
        if(!tempList.contains(target)) {
            tempList.add(target);
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

    @Override
    public List<N> getPath(N source, N target) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPath'");
    }

}
