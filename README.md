# Prereq Checker

## Overview
The Prereq Checker project is a Java-based toolset for managing course prerequisites within the Rutgers Computer Science program. The project includes four classes: AdjList, ValidPrereq, Eligible, and NeedToTake. These classes offer functionalities to handle adjacency lists, validate prerequisites, determine eligible courses based on completed prerequisites, and identify courses needed to achieve a target course.

### Classes

1. **AdjList**
   - The `AdjList` Java class takes two command line arguments: an adjacency list input file name and an output file name. It constructs an adjacency list from the provided input file, where each course is identified by a unique ID. The output is then written to the specified output file.

2. **ValidPrereq**
   - The `ValidPrereq` Java class takes three command line arguments: an adjacency list input file, a prereq input file, and an output file. It uses the adjacency list to determine if adding an immediate prerequisite (course 2) for a target course (course 1) would still allow all courses to be taken. The output indicates whether the addition is valid.

3. **Eligible**
   - The `Eligible` Java class takes three command line arguments: an adjacency list input file, an eligible input file, and an output file. It identifies all courses that a student is now eligible to take, given the completion of specified courses along with their prerequisites (both direct and indirect).

4. **NeedToTake**
   - The `NeedToTake` Java class takes three command line arguments: an adjacency list input file, a need to take input file, and an output file. It identifies all the courses that a student needs to take to fulfill the prerequisites (both direct and indirect) for a target course.

## Usage

1. **AdjList**
   - Run the `AdjList` class with the adjacency list input file name and output file name as command line arguments to generate the adjacency list.

2. **ValidPrereq**
   - Run the `ValidPrereq` class with the adjacency list input file, prereq input file, and output file as command line arguments to validate the addition of immediate prerequisites.

3. **Eligible**
   - Run the `Eligible` class with the adjacency list input file, eligible input file, and output file as command line arguments to determine eligible courses based on completed prerequisites.

4. **NeedToTake**
   - Run the `NeedToTake` class with the adjacency list input file, need to take input file, and output file as command line arguments to identify courses needed to achieve a target course.

## License
This project is licensed under the [MIT License](LICENSE.md).

## Acknowledgments
This project provides a convenient toolset for managing course prerequisites within the Rutgers Computer Science program, aiding students in planning their academic journeys effectively.

---

Feel free to customize this README based on the specifics of your project and your preferences.
