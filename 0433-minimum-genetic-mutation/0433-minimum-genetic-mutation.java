class Solution {
    public boolean diffOne(String a, String b){
        int count = 0;
        for(int i = 0; i < a.length(); i++){
            if(a.charAt(i) != b.charAt(i)){
                count++;
            }
        }
        return count == 1;
    }
    public int minMutation(String startGene, String endGene, String[] bank) {
        if(startGene.equals(endGene)){
            return 0;
        }
        Set<String> set = new HashSet(Arrays.asList(bank));
        if(!set.contains(endGene)){
            return -1;
        }
        if(!set.contains(startGene)){
            set.add(startGene);
        }
        int n = set.size();
        List<String> list = new LinkedList();
        int src = 0;
        int dest = 0;
        int index = 0;
        for(String s:set){
            list.add(s);
            if(s.equals(startGene)){
                src = index;
            }
            else if(s.equals(endGene)){
                dest = index;
            }
            index++;
        }
        List<List<Integer>> adjList = new ArrayList();
        for(int i = 0; i < n; i++){
            adjList.add(new ArrayList());
        }
        for(int i = 0; i < n - 1; i++){
            for(int j = i + 1; j < n; j++){
                if(diffOne(list.get(i), list.get(j))){
                    adjList.get(i).add(j);
                    adjList.get(j).add(i);
                }
            }
        }
        Queue<Integer> q = new LinkedList();
        boolean[] visited = new boolean[n];
        q.add(src);
        int ans = 0;
        while(!q.isEmpty()){
            ans++;
            int size = q.size();
            for(int i = 0; i < size; i++){
                int idx = q.poll();
                visited[idx] =  true;
                for(int num : adjList.get(idx)){
                    if(num == dest){
                        return ans;
                    }
                    if(!visited[num]){
                        q.add(num);
                    }
                }
            }
        }
        return -1;
    }
}