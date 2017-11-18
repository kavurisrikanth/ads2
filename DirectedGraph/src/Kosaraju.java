import java.util.Stack;

class Kosaraju {

    private int[] scc, parent;
    private int count;
    private boolean[] visited;

    public Kosaraju(DirectedGraph dg) {
        DepthFirstSearch.initialize(dg, 0);
        visited = new boolean[dg.getNumV()];
        scc = new int[dg.getNumV()];
        parent = new int[dg.getNumV()];
        DepthFirstSearch.completeDFS(dg.reverse());
        Iterable<Integer> rev = DepthFirstSearch.getOrder();
        System.out.println("Iterating thru stack");
        for(int i: rev)
            System.out.print(i + " ");
        System.out.println();
        for(int i: rev) {
            if(!visited[i]) {
                dfs(dg, i);
                count++;
            }
        }
    }

    /*
    private void dfs(DirectedGraph dg, int start) {
        Stack<Integer> temp = new Stack<>();
//        backup = new Stack<>();
        temp.push(start);
        int x = 0;

        while(!temp.isEmpty()) {
            x = temp.pop();
            scc[x] = count;
            visited[x] = true;
            for(int y: dg.adj(x)) {
                if(!visited[y]) {
                    System.out.println("pushing " + y);
                    temp.push(y);
                    visited[y] = true;
                    parent[y] = x;
                }
            }
        }
    }
    */

    private void dfs(DirectedGraph dg, int start) {
        visited[start] = true;
        scc[start] = count;
        for(int x: dg.adj(start)) {
            if(!visited[x])
                dfs(dg, x);
        }
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        for(int i = 0; i < scc.length; i++)
            s.append(i + ": " + scc[i] + "\n");
        return s.toString();
    }
}
