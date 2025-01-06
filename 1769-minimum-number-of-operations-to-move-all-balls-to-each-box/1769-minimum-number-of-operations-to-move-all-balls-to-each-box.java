class Solution {
    public int[] minOperations(String boxes) {
        int n=boxes.length();
        int[] answer=new int[n];
        int[] suffSum=new int[n+2];
        int[] prefSum=new int[n+2];
        int[] suffCountOne=new int[n+2];
        int[] prefCountOne=new int[n+2];
        for(int i=n;i>0;i--){
            int prefCount=boxes.charAt(n-i)=='1'?(n-i+1):0;
            int suffCount=boxes.charAt(i-1)=='1'?i:0;
            suffSum[i]=suffCount+suffSum[i+1];
            prefSum[n-i+1]=prefCount+prefSum[n-i];
            suffCountOne[i]=(suffCount==0?0:1)+suffCountOne[i+1];
            prefCountOne[n-i+1]=(prefCount==0?0:1)+prefCountOne[n-i];
        }
        for(int i=0;i<n;i++){
            int prefixSum=Math.abs(prefSum[i]-prefCountOne[i]*(i+1));
            int suffixSum=Math.abs(suffSum[i+2]-suffCountOne[i+2]*(i+1));
            answer[i]=prefixSum+suffixSum;
            // System.out.println(prefSufSum+" "+prefSumCount+" "+answer[i]);
        }
        // for(int i=0;i<=n+1;i++){
        //     System.out.println(prefSum[i]+" "+suffSum[i]+" "+prefCountOne[i]+" "+suffCountOne[i]);
        // }
        return answer;
    }
}