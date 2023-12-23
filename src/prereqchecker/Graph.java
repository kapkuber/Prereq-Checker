package prereqchecker;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Graph {
    private Map<String, List<String>> adjacencyList;
    private Map<String, Boolean> completedStatus;

    // Constructor
    public Graph() {
        this.adjacencyList = new HashMap<>();
        this.completedStatus = new HashMap<>();
    }

    // Add a vertex to the graph
    public void addVertex(String vertex) {
        if (!adjacencyList.containsKey(vertex)) {
            adjacencyList.put(vertex, new ArrayList<>());
        }
    }

    // Add a directed edge between two vertices
    public void addEdge(String source, String destination) {
        adjacencyList.get(source).add(destination);
    }

    // Get the neighbors of a vertex
    public List<String> getNeighbors(String vertex) {
        return adjacencyList.getOrDefault(vertex, new ArrayList<>());
    }
    //***************************************************************************************************/
    // for validprereq
    
    public boolean findString(String startVertex, String targetString) {
        Set<String> visited = new HashSet<>();
        return dfs(startVertex, targetString, visited);
    }
    private boolean dfs(String currentVertex, String targetString, Set<String> visited) {
        if (visited.contains(currentVertex)) {
            return false;
        }

        visited.add(currentVertex);

        if (currentVertex.equals(targetString)) {
            return true;
        }

        for (String neighbor : getNeighbors(currentVertex)) {
            if (dfs(neighbor, targetString, visited)) {
                return true;
            }
        }

        return false;
    }
    //***************************************************************************************************/
    // for eligible
    public void markCompletion(String course) {
        markCompletionDFS(course, new HashSet<>());
    }

    private void markCompletionDFS(String currentVertex, Set<String> visited) {
        if (visited.contains(currentVertex)) {
            return;
        }

        visited.add(currentVertex);
        completedStatus.put(currentVertex, true);

        for (String neighbor : getNeighbors(currentVertex)) {
            markCompletionDFS(neighbor, visited);
        }
    }
    public List<String> getCoursesWithCompletedPrerequisites() {
        List<String> coursesWithCompletedPrerequisites = new ArrayList<>();
    
        for (String course : adjacencyList.keySet()) {
            if (hasCompletedPrerequisites(course) && !completedStatus.getOrDefault(course, false)) {
                coursesWithCompletedPrerequisites.add(course);
            }
        }
        return coursesWithCompletedPrerequisites;
    }
    
    private boolean hasCompletedPrerequisites(String course) {
        for (String prerequisite : getNeighbors(course)) {
            if (!completedStatus.getOrDefault(prerequisite, false)) {
                return false; // If any prerequisite is not completed, return false
            }
        }
        return true; // All prerequisites are completed
    }
    //***************************************************************************************************/
    // for NeedToTake
    public List<String> getRemainingPrerequisites(String targetCourse) {
        Set<String> visited = new HashSet<>();
        List<String> remainingPrerequisites = new ArrayList<>();
    
        getRemainingPrerequisitesDFS(targetCourse, visited, remainingPrerequisites);
    
        return remainingPrerequisites;
    }
    
    private void getRemainingPrerequisitesDFS(String currentVertex, Set<String> visited, List<String> remainingPrerequisites) {
        if (visited.contains(currentVertex)) {
            return;
        }
    
        visited.add(currentVertex);
    
        List<String> neighbors = getNeighbors(currentVertex);
        for (String neighbor : neighbors) {
            if (!completedStatus.getOrDefault(neighbor, false)) {
                remainingPrerequisites.add(neighbor);
            }
            getRemainingPrerequisitesDFS(neighbor, visited, remainingPrerequisites);
        }
    }
    //***************************************************************************************************/
    // Prints the graph in the output file
    public void printGraph() {
        for (Map.Entry<String, List<String>> entry : adjacencyList.entrySet()) {
            String vertex = entry.getKey();
            List<String> neighbors = entry.getValue();

            StdOut.print(vertex + " ");

            for (String neighbor : neighbors) {
                StdOut.print(neighbor + " ");
            }
            StdOut.println();
        }
    }
}
