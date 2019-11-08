import com.sun.source.tree.WhileLoopTree;

import java.util.LinkedList;
import java.util.ListIterator;

public class Graph {
    LinkedList nodeList[];
    int NUM_NODES = 6;

    public Graph(int node) {
        NUM_NODES  = node;
        nodeList = new LinkedList[NUM_NODES];
        for (int i = 0; i < NUM_NODES; i++) {
            nodeList[i] = new LinkedList();
        }
    }

    public void primAlgo() {
        ListIterator iterator1;
        Edge edge;
        LinkedList treeVertices = new LinkedList();
        LinkedList remainingVertices = new LinkedList();

        treeVertices.add(new Edge(0, 0, -1));
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < NUM_NODES; i++) {
            iterator1 = nodeList[0].listIterator();
            for (edge = (Edge) iterator1.next(); edge.to != i && iterator1.hasNext(); edge = (Edge) iterator1.next()) {
            }

            if (edge.to == i) {
                if(edge.distance < min) {
                    remainingVertices.addFirst(edge);
                    min = edge.distance;
                } else {
                    remainingVertices.add(edge);
                }
            } else {
                remainingVertices.add( new Edge(0, i, Integer.MAX_VALUE));
            }
        }

        iterator1 = remainingVertices.listIterator();
        while (iterator1.hasNext()) {
            Edge x = (Edge)iterator1.next();
            System.out.print(x.to + " (" + x.from + "," + x.distance + "), ");
        }
        System.out.println();

        Edge removeNodeFromRemaining = (Edge)remainingVertices.getFirst();
        treeVertices.add(removeNodeFromRemaining);
        remainingVertices.remove();

        ListIterator iteratorForRemain;
        Edge eRemain, edge1;
        while (!remainingVertices.isEmpty()) {
            min = Integer.MAX_VALUE;
            int minIndex = 0;
            iteratorForRemain = remainingVertices.listIterator();
            for (int i = 0; iteratorForRemain.hasNext() ; i++) {
                eRemain = (Edge) iteratorForRemain.next();
                iterator1 = nodeList[removeNodeFromRemaining.to].listIterator();

                while (iterator1.hasNext()) {
                    edge1 = (Edge)iterator1.next();
                    if(edge1.to == eRemain.to && edge1.distance < eRemain.distance) {
                        eRemain.from = edge1.from;
                        eRemain.distance = edge1.distance;
                    }
                }

                if (eRemain.distance < min) {
                    minIndex = i;
                    min = eRemain.distance;
                }
            }

            removeNodeFromRemaining = (Edge) remainingVertices.get(minIndex);
            treeVertices.add(removeNodeFromRemaining);
            remainingVertices.remove(minIndex);
            iterator1 = remainingVertices.listIterator();


            while (iterator1.hasNext()) {
                Edge x = (Edge)iterator1.next();
                System.out.print(x.to + " (" + x.from + "," + x.distance + "), ");
            }
            System.out.println();
        }

        iterator1 = treeVertices.listIterator();
        while (iterator1.hasNext()) {
            Edge x = (Edge)iterator1.next();
            System.out.print(x.to + " (" + x.from + "," + x.distance + "), ");
        }
        System.out.println();

    }
}
