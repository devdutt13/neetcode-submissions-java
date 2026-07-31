class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> courses = new ArrayList<>();
        int[] indegree = new int[numCourses];
        for(int i=0;i<numCourses;i++){
            courses.add(new ArrayList<>());
        }
        for(int[] preq : prerequisites){
            int course = preq[0];
            int prerequisite = preq[1];
            courses.get(prerequisite).add(course);
            indegree[course]++;
            
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<numCourses; i++){
            if(indegree[i] == 0){
                queue.add(i);
            }
        }
        int finish =0;
        while(!queue.isEmpty()){
            int course = queue.poll();
             finish++;
            for(int dependentCourse : courses.get(course)){
              indegree[dependentCourse]--;
              if(indegree[dependentCourse] == 0){
                queue.add(dependentCourse);
              }

            }
        }
        return numCourses == finish;

    }
}
