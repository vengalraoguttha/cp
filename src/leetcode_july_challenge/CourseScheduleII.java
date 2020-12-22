package leetcode_july_challenge;

import java.util.*;

public class CourseScheduleII {
    private boolean checkCycle(int current, boolean[] stack, List<Integer>[] graph, boolean[] visited){
        visited[current] = true;
        stack[current] = true;
        boolean cycle = false;
        if(graph[current] != null){
            for(int next : graph[current]){
                if(!visited[next]){
                    cycle = cycle || checkCycle(next, stack, graph, visited);
                }else if(stack[next]){
                    // cycle
                    return true;
                }
            }
        }
        stack[current] = false;
        return cycle;
    }

    private void process(int current, List<Integer>[] graph, boolean[] visited, LinkedList<Integer> stack){
        visited[current] = true;
        if(graph[current] != null){
            for(int next : graph[current]){
                if(!visited[next]){
                    process(next, graph, visited, stack);
                }
            }
        }
        stack.add(current);
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new ArrayList[numCourses];
        for(int[] edge : prerequisites){
            if(graph[edge[0]] == null) graph[edge[0]] = new ArrayList<>();
            graph[edge[0]].add(edge[1]);
        }

        boolean[] visited = new boolean[numCourses];
        boolean[] stack = new boolean[numCourses];

        for(int i = 0; i < numCourses; i++){
            if(!visited[i]){
                if(checkCycle(i, stack, graph, visited)){
                    return new int[]{};
                }
            }
        }

        Arrays.fill(stack, false);
        Arrays.fill(visited, false);

        LinkedList<Integer> st = new LinkedList<>();
        for(int i = 0; i < numCourses; i++){
            if(!visited[i]){
                process(i, graph, visited, st);
            }
        }

        int[] ans = new int[numCourses];
        int index = 0;
        while (!st.isEmpty()){
            ans[index] = st.pollFirst();
            index++;
        }
        return ans;
    }
}
