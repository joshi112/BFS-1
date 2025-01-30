import java.util.*;

//Time Complexity: O(V+E)
//Space Complexity: O(1)
public class CourseSchedule {
    class Solution {
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            HashMap<Integer,List<Integer>> hmap = new HashMap<>();
            int[] indegrees = new int[numCourses];
            Queue<Integer> q = new LinkedList<>();

            for(int[] prereq : prerequisites){
                int from = prereq[1];
                int to = prereq[0];
                List<Integer> clist = new ArrayList<>();
                clist.add(to);
                if(!hmap.containsKey(from)){
                    hmap.put(from, clist);
                }else{
                    List<Integer> elist = hmap.get(from);
                    elist.add(to);
                    hmap.put(from, elist);
                }
                indegrees[to]++;
            }
            int count=0;
            for(int i=0;i<indegrees.length;i++){
                if(indegrees[i] ==0){
                    count++;
                    q.add(i);
                }
            }

            while(!q.isEmpty()){
                int from = q.poll();
                List<Integer> elist = hmap.get(from);
                if(elist == null){
                    continue;
                }
                for(int e: elist){
                    indegrees[e]--;
                    if(indegrees[e] ==0){
                        count++;
                        q.add(e);
                    }
                }
            }

            return count == numCourses;
        }
    }
}
