class HamiltonCheck {

    public static boolean HamiltonPathExists(DirectedGraph dGraph) {
        Iterable<Integer> it =  TopologicalSort.doTopologicalSort(dGraph);
        int test[] = new int[dGraph.getNumV()], i = 0;

        for(int x: it)
            test[i++] = x;

        for(int x = dGraph.getNumV() - 1; x > 0; x--) {
            if (!dGraph.hasEdge(test[x], test[x - 1])) {
                System.out.println("no edge between " + test[x] + " and " + test[x - 1]);
                return false;
            }
        }
        return true;
    }
}
