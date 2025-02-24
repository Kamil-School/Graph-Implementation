//Test code for the Graph ADT
//Created by James Vanderhyde, 19 November 2024

package c311graphadt;

public class Main
{
    public static void main(String[] args)
    {
        String[] names = {"Aeris", "Barret", "Cloud", "Tifa"};

        ListGraph ff7 = new ListGraph(4);
        ff7.addEdge(0, 1);
        ff7.addEdge(0, 2);
        ff7.addEdge(1, 3);
        ff7.addEdge(2, 3);

        System.out.println("Expect 2:");
        System.out.println("The degree of vertex 2 is "+ff7.getDegree(2));
        System.out.println();

        System.out.println("Expect true, because we added 0,1:");
        System.out.println("Edge 1,0 exists: "+ff7.edgeExists(1, 0));
        System.out.println();

        //Fix the ListGraph and MatrixGraph classes so the degree
        //  and edgeExists work correctly. Check removeEdge, too.

        System.out.println("Who knows who?");
        //Loop over all the names in a nested loop.
        // If the pair is present as an edge in the graph,
        // print "X knows Y" with the names for X and Y.
        for (int i = 0; i < ff7.getNumVertices(); i++) {
            for (int j = 0; j < ff7.getNumVertices(); j++) {
                if (ff7.edgeExists(i, j)) {
                    System.out.println(names[i] + " knows " + names[j]);
                }
            }
        }
        System.out.println();
        System.out.println("Removing edge 0 -> 2 (Aeris -> Cloud) True: " + ff7.removeEdge(0, 2));
        System.out.println("Edge from 0 to 2 exists, False: " + ff7.edgeExists(0, 2));
        System.out.println();
        for (int i = 0; i < ff7.getNumVertices(); i++) {
            for (int j = 0; j < ff7.getNumVertices(); j++) {
                if (ff7.edgeExists(i, j)) {
                    System.out.println(names[i] + " knows " + names[j]);
                }
            }
        }

        System.out.println();

        String[] names2 = {"Aeris", "Barret", "Cloud", "Tifa"};

        MatrixGraph ff8 = new MatrixGraph(4);
        ff8.addEdge(0, 1);
        ff8.addEdge(0, 2);
        ff8.addEdge(1, 3);
        ff8.addEdge(2, 3);

        System.out.println("Expect 2:");
        System.out.println("The degree of vertex 2 is " + ff8.getDegree(2));
        System.out.println();

        System.out.println("Expect true, because we added 0,1:");
        System.out.println("Edge 1,0 exists: "+ff8.edgeExists(1, 0));
        System.out.println();

        System.out.println("Edge 0,1 exists: True"+ff8.edgeExists(0, 1));
        System.out.println();


        for (int i = 0; i < ff8.getNumVertices(); i++) {
            for (int j = 0; j < ff8.getNumVertices(); j++) {
                if (ff8.edgeExists(i, j)) {
                    System.out.println(names2[i] + " knows " + names2[j]);
                }
            }
        }

        System.out.println();
        System.out.println("Removing edge 0 -> 2 (Aeris -> Cloud) True: " + ff8.removeEdge(0, 2));
        System.out.println("Edge from 0 to 2 exists, False: " + ff8.edgeExists(0, 2));
        System.out.println();
        for (int i = 0; i < ff8.getNumVertices(); i++) {
            for (int j = 0; j < ff8.getNumVertices(); j++) {
                if (ff8.edgeExists(i, j)) {
                    System.out.println(names2[i] + " knows " + names2[j]);
                }
            }
        }


    }
}
