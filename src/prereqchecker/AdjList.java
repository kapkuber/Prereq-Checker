package prereqchecker;
/**
 * Steps to implement this class main method:
 * 
 * Step 1:
 * AdjListInputFile name is passed through the command line as args[0]
 * Read from AdjListInputFile with the format:
 * 1. a (int): number of courses in the graph
 * 2. a lines, each with 1 course ID
 * 3. b (int): number of edges in the graph
 * 4. b lines, each with a source ID
 * 
 * Step 2:
 * AdjListOutputFile name is passed through the command line as args[1]
 * Output to AdjListOutputFile with the format:
 * 1. c lines, each starting with a different course ID, then 
 *    listing all of that course's prerequisites (space separated)
 */
public class AdjList {
    public static void main(String[] args) {

        if ( args.length < 2 ) {
            StdOut.println("Execute: java -cp bin prereqchecker.AdjList <adjacency list INput file> <adjacency list OUTput file>");
            return;
        }
        String inputFile = args[0];
        StdIn.setFile(inputFile);
        int numCourses = StdIn.readInt();
        StdIn.readLine();
        Graph graph = new Graph();

        for(int i = 0; i < numCourses; i++) {
            String currentCourse = StdIn.readLine();
            graph.addVertex(currentCourse);
        }

        int numEdges = StdIn.readInt();
        StdIn.readLine();
        for(int i = 0; i < numEdges; i++) {
            String[] words = StdIn.readLine().split("\\s");
            graph.addEdge(words[0], words[1]);
        }

        String outputFile = args[1];
        StdOut.setFile(outputFile);
        graph.printGraph();
        
    }
}
