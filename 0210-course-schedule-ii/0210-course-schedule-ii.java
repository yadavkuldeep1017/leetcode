class Solution {
    boolean[] visited;
    Stack<Integer> stack = new Stack();
    public List<List<Integer>> getAdjList(int[][] prerequisites, int numCourses){
        List<List<Integer>> list = new ArrayList();
        for(int i = 0; i < numCourses; i++){
            list.add(new ArrayList());
        }
        for(int[] pre:prerequisites){
            list.get(pre[1]).add(pre[0]);
        }
        return list;
    }
    public boolean dfs(List<List<Integer>> adjList, int v){
        if(visited[v]){
            return stack.contains(v);
        }
        visited[v] = true;
        for(int num:adjList.get(v)){
            if(!dfs(adjList,num)){
                return false;
            }
        }
        stack.add(v);
        return true;
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = getAdjList(prerequisites, numCourses);
        visited  = new boolean[numCourses];
        for(int i = 0; i < numCourses; i++){
            if(!visited[i]){
                if(!dfs(adjList,i)){
                    return new int[0];
                }
            }
        }
        int[] order = new int[numCourses];
        int index = 0;
        while(!stack.isEmpty()){
            order[index++] = stack.pop();  
        }
        return order;
    }
}