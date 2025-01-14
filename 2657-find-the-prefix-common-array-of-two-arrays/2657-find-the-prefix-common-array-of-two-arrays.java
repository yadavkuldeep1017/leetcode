class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n=A.length;
        int[] ans=new int[n];
        boolean[] isVisit=new boolean[n+1];
        int count=0;
        for(int i=0;i<n;i++){
            if(A[i]==B[i]){
                ans[i]=++count;
                continue;
            }
            if(isVisit[A[i]]){
                count++;
            }
            if(isVisit[B[i]]){
                count++;
            }
            isVisit[A[i]]=true;
            isVisit[B[i]]=true;
            ans[i]=count;
        }
        return ans;
    }
}