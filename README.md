# algorithms_datastructures

This repo contains the source code of the exam project "algorithms and data structures" A.A.2017/2018.
Below there's a quick recap of the exercises. Each implementation has a correlated Unit Test made with JUnit 4

## Exercise 1
Implement a library that offers the following sorting algorithms:

- Insertion Sort
- Merge Sort

Each algorithm must be implemented using generic types.
The implementation of the algorithms must allow to specify the criterion according to which to order the data.
  
## Exercise 2
Consider the problem of determining the edit distance between two strings (Edit distance): given two strings s1 and s2, not necessarily of the same length, determine the minimum number of operations necessary to transform the string s2 into s1. Assume that there are only two available operations: deleting and inserting a character.
  Examples:
- "casa" and "cassa" have edit distance = 1 (1 deletion)
- "casa" and "cara" have edit distance = 2 (1 deletion + 1 insertion)
- "tassa" and "passato" have edit distance = 4 (3 deletion + 1 insertion)
- "pioppo" and "pioppo" have edit distance = 0
Implement a recursive version of the function `edit_distance`.
Implement a second `edit_distance_dyn` version of the function, adopting a dynamic programming strategy.
  
## Exercise 3
Implement the priority queue data structure.

The data structure must handle generic types and allow any number of elements that are not known in advance.

## Exercise 4
Implement a library that realizes the Graph data structure so that it is optimal for sparse data.

The structure must allow us to represent both direct graphs and non-directed graphs (suggestion: a non-direct graph can be represented using an implementation by direct graphs in the following way: for each arc (a, b), labeled w, present in the graph, the arc is also present in the graph (b, a), labeled w, of course, the graph must keep the information that specifies whether it is a direct or non-directed graph.).

In addition to the essential functions for the Graph data structure, implement a function that returns the weight of the graph (if the graph is not weighed, the function can end with an error).

## Exercise 5

Implement the Prim algorithm for determining the minimum covering forest of a graph. The implementation of the Prim algorithm must use the priority queue in the previous exercise.
