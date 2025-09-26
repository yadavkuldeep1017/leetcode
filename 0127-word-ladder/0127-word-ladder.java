class Solution {
    public boolean diffOne(String a, String b){
        int count = 0;
        char[] ch1 = a.toCharArray();
        char[] ch2 = b.toCharArray();
        for(int i = 0; i < ch1.length; i++){
            if(ch1[i] != ch2[i]){
                count ++;
            }
        }
        return count == 1;
    }
    public List<List<Integer>> getAdjList(List<String> wordList, int k){
        List<List<Integer>> adjList = new ArrayList();
        for(int i = 0; i < k; i++){
            adjList.add(new ArrayList());
        }
        for(int i = 0; i < k-1; i++){
            for(int j = i+1; j < k; j++){
                if(diffOne(wordList.get(i), wordList.get(j))){
                    adjList.get(i).add(j);
                    adjList.get(j).add(i);
                }
            }
        }

        return adjList;
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int src = 0;
        if(!wordList.contains(beginWord)){
            wordList.add(beginWord);
            src = wordList.size() - 1;
        }else{
            for(int i = 0;i < wordList.size(); i++){
                if(wordList.get(i).equals(beginWord)){
                    src = i;
                }
            }
        }
         int k = wordList.size();
        List<List<Integer>> adjList = getAdjList(wordList, k);
        // System.out.println(adjList);

        boolean[] visited = new boolean[k];
        int[] distance = new int[k];
        Arrays.fill(distance, Integer.MAX_VALUE);
        Queue<Integer> q = new ArrayDeque();
        q.add(src);
        distance[src] = 0;
        visited[src] = true;
        while(!q.isEmpty()){
            int num = q.poll();
            visited[num] = true;
            for(int n:adjList.get(num)){
                if(!visited[n]){
                    q.add(n);
                }
                distance[n] = Math.min(distance[n],distance[num] + 1);
            }
        }
        // for(int i = 0; i < wordList.size(); i++){
        //     System.out.println(distance[i]);
        // }
        for(int i = 0; i < wordList.size(); i++){
            if(wordList.get(i).equals(endWord)){
                if(distance[i] == Integer.MAX_VALUE){
                    return 0;
                }
                return distance[i] + 1;
            }
        }
        return 0;
    }
}