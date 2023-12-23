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
 * ValidPreReqInputFile name is passed through the command line as args[1]
 * Read from ValidPreReqInputFile with the format:
 * 1. 1 line containing the proposed advanced course
 * 2. 1 line containing the proposed prereq to the advanced course
 * 
 * Step 3:
 * ValidPreReqOutputFile name is passed through the command line as args[2]
 * Output to ValidPreReqOutputFile with the format:
 * 1. 1 line, containing either the word "YES" or "NO"
 */
public class ValidPrereq {
    public static void main(String[] args) {

        if ( args.length < 3 ) {
            StdOut.println("Execute: java -cp bin prereqchecker.ValidPrereq <adjacency list INput file> <valid prereq INput file> <valid prereq OUTput file>");
            return;
        }
        String AdjListInputFile = args[0];
        StdIn.setFile(AdjListInputFile);
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

        String validPrereqInput = args[1];
        StdIn.setFile(validPrereqInput);
        String advanced = StdIn.readLine();
        String prereqString = StdIn.readLine();

        String validPrereqOutput = args[2];
        StdOut.setFile(validPrereqOutput);
        if(!graph.findString(prereqString, advanced)) {
            StdOut.print("YES");
        }
        else StdOut.print("NO");

    }
}
