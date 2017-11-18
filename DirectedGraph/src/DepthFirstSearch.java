import java.util.Iterator;
import java.util.Stack;

class DepthFirstSearch {

    private static int start;
    private static boolean visited[];
    private static int[] parent;
    private static Stack<Integer> backup;

    public static void initialize(DirectedGraph G, int s) {
        start = s;
        visited = new boolean[G.getNumV()];
        parent = new int[G.getNumV()];
        backup = new Stack<>();
        for(int i = 0; i < G.getNumV(); i++)
            parent[i] = start;
    }

//    public static void initialize(DirectedGraph G) {
//
//    }

    public static void completeDFS(DirectedGraph G) {
        for(int i = 0; i < G.getNumV(); i++)
            if(!visited[i])
                doDepthFirstSearch(G, i);
        //for(int x: backup)
          //  System.out.println(x);
    }

    public static void completeDFS(DirectedGraph G, Iterable<Integer> order) {
        for(int i: order)
            if(!visited[i])
                doDepthFirstSearch(G, i);
    }

    public static void doDepthFirstSearch(DirectedGraph G, int s) {
        //System.out.println(G);
        dfs(G, s);
    }


    private static void dfs(DirectedGraph G, int start) {
        Stack<Integer> temp = new Stack<>();
//        backup = new Stack<>();
        temp.push(start);
        int x = 0;

        while(!temp.isEmpty()) {
            x = temp.pop();
            System.out.println("pushing " + x);
            backup.push(x);
            visited[x] = true;
            for(int y: G.adj(x)) {
                if(!visited[y]) {
                    temp.push(y);
                    visited[y] = true;
                    parent[y] = x;
                }
            }
        }
    }


    /*
    private static void dfs(DirectedGraph G, int start) {

        if(visited[start])
            return;

        visited[start] = true;
        System.out.println("start: " + start);
        for(int i: G.adj(start)) {
            System.out.println("  checking: " + i);
            if(!visited[i]) {
                dfs(G, i);
                //System.out.println("Setting parent of " + i + " to " + start);
                parent[i] = start;
            }
        }
        System.out.println("pushing " + start);
        backup.push(start);
    }
    */

    public static boolean hasPath(int to) {
        assert to >= 0 && to < visited.length;
        return visited[to];
    }

    public static String getPath(int to) {
        String s = "";
        for(int x = to; x != start; x = parent[x]) {
            s = x + s;
            s = "->" + s;
        }
        s = start + s;
        return s;
    }

    public static boolean[] getVisited() {
        return visited;
    }

    public static Stack<Integer> getOrder() {
        Stack<Integer> temp = (Stack<Integer>) backup.clone(),
                        ans = new Stack<>();
        while(!temp.isEmpty())
            ans.push(temp.pop());
        return ans;
    }

    public static String pathTo(int to) {
        assert to >= 0 && to < visited.length;

        String s = "";
        for(int i = to; i != start; i = parent[i]) {
            s = i + s;
            s = "-" + s;
        }
        s = start + s;
        return s;
    }
}
