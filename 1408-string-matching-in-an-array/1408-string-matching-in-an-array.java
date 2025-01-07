class Solution {
    public List<String> stringMatching(String[] words) {
        int n=words.length;
        List<String> answer=new ArrayList();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                // System.out.println(words[i]+" "+words[j]);
                if(i!=j && words[j].contains(words[i])){
                    answer.add(words[i]);
                    break;
                }
            }
        }
        return answer;
    }
}