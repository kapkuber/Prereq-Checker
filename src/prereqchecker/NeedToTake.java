package prereqchecker;

import java.util.*;

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
 * NeedToTakeInputFile name is passed through the command line as args[1]
 * Read from NeedToTakeInputFile with the format:
 * 1. One line, containing a course ID
 * 2. c (int): Number of courses
 * 3. c lines, each with one course ID
 * 
 * Step 3:
 * NeedToTakeOutputFile name is passed through the command line as args[2]
 * Output to NeedToTakeOutputFile with the format:
 * 1. Some number of lines, each with one course ID
 */
public class NeedToTake {
    public static void main(String[] args) {

        if ( args.length < 3 ) {
            StdOut.println("Execute: java NeedToTake <adjacency list INput file> <need to take INput file> <need to take OUTput file>");
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

        String NeedToTakeInput = args[1];
        StdIn.setFile(NeedToTakeInput);
        String target = StdIn.readLine();
        int numTaken = StdIn.readInt();
        StdIn.readLine();
        List<String> Taken = new ArrayList<>(); 
        for(int i = 0; i < numTaken; i ++) {
            Taken.add(StdIn.readLine());
        }
        for(int i = 0; i < Taken.size(); i++) {
            graph.markCompletion(Taken.get(i));
        }

        List<String> Remaining = graph.getRemainingPrerequisites(target);
        
        String NeedToTakeOutput = args[2];
        StdOut.setFile(NeedToTakeOutput);
        for(int i = 0; i < Remaining.size(); i++){
            StdOut.println(Remaining.get(i));
        }
    }
}
