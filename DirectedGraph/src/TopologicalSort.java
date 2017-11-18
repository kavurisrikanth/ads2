class TopologicalSort {
    public static Iterable<Integer> doTopologicalSort(DirectedGraph G) {
        DepthFirstSearch.initialize(G, 0);
        DepthFirstSearch.completeDFS(G);
        return DepthFirstSearch.getOrder();
        /*
        for(int x: DepthFirstSearch.getOrder())
            System.out.print(x + " ");
        System.out.println();
        */
    }
}
