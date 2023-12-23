package prereqchecker;
import java.util.*;

/**
 * 
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
 * EligibleInputFile name is passed through the command line as args[1]
 * Read from EligibleInputFile with the format:
 * 1. c (int): Number of courses
 * 2. c lines, each with 1 course ID
 * 
 * Step 3:
 * EligibleOutputFile name is passed through the command line as args[2]
 * Output to EligibleOutputFile with the format:
 * 1. Some number of lines, each with one course ID
 */
public class Eligible {
    public static void main(String[] args) {

        if ( args.length < 3 ) {
            StdOut.println("Execute: java -cp bin prereqchecker.Eligible <adjacency list INput file> <eligible INput file> <eligible OUTput file>");
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

        String EligibleInput = args[1];
        StdIn.setFile(EligibleInput);
        int numTaken = StdIn.readInt();
        StdIn.readLine();
        List<String> Taken = new ArrayList<>(); 
        for(int i = 0; i < numTaken; i ++) {
            Taken.add(StdIn.readLine());
        }
        for(int i = 0; i < Taken.size(); i++) {
            graph.markCompletion(Taken.get(i));
        }
        
        List<String> eligible = graph.getCoursesWithCompletedPrerequisites();

        String EligibleOutput = args[2];
        StdOut.setFile(EligibleOutput);
        for(int i = 0; i < eligible.size(); i++){
            StdOut.println(eligible.get(i));
        }

    }
}
