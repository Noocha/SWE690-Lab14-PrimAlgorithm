public class PrimAlgorithm {
    public static void main(String[] args) {

        Graph g = new Graph(6);
        g.nodeList[0].add(new Edge(0, 5, 5)); // from a to f
        g.nodeList[0].add(new Edge(0, 1, 3)); // a -> b: 3
        g.nodeList[0].add(new Edge(0, 4, 6)); // a -> e: 6

        g.nodeList[1].add(new Edge(1, 0, 3)); // b -> a: 3
        g.nodeList[1].add(new Edge(1, 2, 1)); // b -> c: 1
        g.nodeList[1].add(new Edge(1, 5, 4)); // b -> f: 4

        g.nodeList[2].add(new Edge(2, 1, 1)); // c -> b: 1
        g.nodeList[2].add(new Edge(2, 3, 6)); // c -> d: 6
        g.nodeList[2].add(new Edge(2, 5, 4)); // c -> f: 4

        g.nodeList[3].add(new Edge(3, 2, 6)); // d -> c: 6
        g.nodeList[3].add(new Edge(3, 4, 8)); // d -> e: 8
        g.nodeList[3].add(new Edge(3, 5, 5)); // d -> f: 5

        g.nodeList[4].add(new Edge(4, 0, 6)); // e -> a: 6
        g.nodeList[4].add(new Edge(4, 3, 8)); // e -> d: 8
        g.nodeList[4].add(new Edge(4, 5, 2)); // e -> f: 2

        g.nodeList[5].add(new Edge(5, 0, 5)); // f -> a: 5
        g.nodeList[5].add(new Edge(5, 1, 4));  // f -> b: 4
        g.nodeList[5].add(new Edge(5, 2, 4)); // f -> c: 4
        g.nodeList[5].add(new Edge(5, 3, 5)); // f -> d: 5
        g.nodeList[5].add(new Edge(5, 4, 2)); // f -> e: 2

        g.primAlgo();
    }
}
