/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package friendgraph;

import DataStructures.GraphNode;

/**
 * A simple simulation for the friend graph.
 *
 * @author Brian Thompson
 * @version 2017/11/17
 */
public class FriendGraphSim {

    public static void main(String[] args) {
        try {
            runSim();
        } catch (Exception ex) {
            System.out.println(ex);
        }

    }

    public static void runSim() throws Exception {
        //This code will not work until you've created your FriendGraph<T> class.

        FriendGraph<String> g = new FriendGraph<>();

        GraphNode brian = new GraphNode("Brian");
        g.addVertex(brian);
        GraphNode mariah = new GraphNode("Mariah");
        g.addVertex(mariah);
        GraphNode kyle = new GraphNode("Kyle");
        g.addVertex(kyle);
        GraphNode syeda = new GraphNode("Syeda");
        g.addVertex(syeda);
        GraphNode narges = new GraphNode("Narges");
        g.addVertex(narges);
        GraphNode celine = new GraphNode("Dr. Celine");
        g.addVertex(celine);
        GraphNode manuel = new GraphNode("Dr. Perez");
        g.addVertex(manuel);
        GraphNode stephen = new GraphNode("Stephen");
        g.addVertex(stephen);
        GraphNode mary = new GraphNode("Mary");
        g.addVertex(mary);
        GraphNode sandy = new GraphNode("Sandy");
        g.addVertex(sandy);

        //
        g.addEdge(brian, mariah);
        g.addEdge(brian, kyle);
        g.addEdge(brian, syeda);
        g.addEdge(brian, narges);
        g.addEdge(brian, celine);
        g.addEdge(brian, manuel);
        g.addEdge(brian, stephen);

        g.addEdge(mariah, kyle);
        g.addEdge(mariah, syeda);
        g.addEdge(mariah, narges);
        g.addEdge(mariah, celine);
        g.addEdge(mariah, stephen);

        g.addEdge(kyle, celine);
        g.addEdge(kyle, stephen);

        g.addEdge(syeda, narges);
        g.addEdge(syeda, celine);

        g.addEdge(narges, celine);
        g.addEdge(narges, mary);

        g.addEdge(celine, stephen);
        g.addEdge(celine, manuel);
        g.addEdge(celine, mary);
        g.addEdge(celine, sandy);

        g.addEdge(manuel, stephen);
        g.addEdge(manuel, mary);
        g.addEdge(manuel, sandy);
        
        g.addEdge(stephen, mary);

        g.addEdge(mary, sandy);

        System.out.println("Graph has " + g.getNumVertices() + " vertices.");
        System.out.println("Graph has " + g.getNumEdges() + " edges.");
        System.out.println("The graph: ");
        g.printGraph();

        System.out.println("Highest Degree Node: "
                + g.getHighestDegreeVertex().toString());
        System.out.println("Highest Degree Node's degree: "
                + g.getDegree(g.getHighestDegreeVertex()));
        System.out.println("All edges of highest degree node: "
                + g.getEdgesOfVertex(g.getHighestDegreeVertex()).toString());
        System.out.println("Graph is connected: " + g.isGraphConnected());

        System.out.println("Breadth First Traversal of Graph: " + g.bft(brian).toString());

        System.out.println("Is there a path between Brian and Sandy?: "
                + g.hasPathBetween(brian, mary));

        if (g.hasPathBetween(brian, mary)) {
            System.out.println("Path between Brian and Sandy: "
                    + g.getPathBetween(brian, sandy));
        }

        //uncomment the code below once you've completed your solution.
        System.out.println("Graph Density: " + g.density());
        System.out.println("Graph Inclusivity: " + g.inclusivity());
        System.out.println("Isolated Points in graph: " + g.numIsolatedPoints());
        System.out.println("Graph is complete: " + g.isGraphComplete());
        System.out.println("Depth First Traversal of Graph: "
                + g.dft(brian).toString());

        System.out.println("Should we suggest an edge between Brian and Sandy? "
                + g.suggestFriend(brian, sandy));
        
        System.out.println(brian.getConnectedNodes());

    }
}
