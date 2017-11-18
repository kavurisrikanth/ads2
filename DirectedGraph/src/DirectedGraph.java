class DirectedGraph {

    // number of vertices
    private int numV, numE;

    // adjacency list
    private List<Integer>[] adj;

    public DirectedGraph(int numV) {
        this.numV = numV;
        numE = 0;
        adj = new List[numV];
        for(int i = 0; i < numV; i++)
            adj[i] = new List<>();
    }

    public void addEdge(int one, int two) {
        assert (one >= 0 && one < numV) &&
                (two >= 0 && two < numV);

        // only put two as the neighbor of one,
        // since this is a directed graph
        adj[one].insert(two);
        numE++;
    }

    public int getNumE() {
        return numE;
    }

    public int getNumV() {
        return numV;
    }

    public Iterable<Integer> adj(int v) {
        // get the adjacency list of v
        assert v >= 0 && v < numV;

        return adj[v];
    }

    public DirectedGraph reverse() {
        DirectedGraph temp = new DirectedGraph(numV);
        for(int i = 0; i < numV; i++) {
            for(int j: adj[i])
                temp.addEdge(j, i);
        }
        return temp;
    }

    public boolean hasEdge(int from, int to) {
        for(int x: adj[from])
            if(x == to)
                return true;
        return false;
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        for(int i = 0; i < numV; i++) {
            if(!adj[i].isEmpty()) {
                s.append(i + " -> ");
                for (int x : adj[i])
                    s.append(x + " ");
                s.append("\n");
            }
        }
        return s.toString();
    }
}
