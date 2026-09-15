class Solution {
    public int sumSubarrayMins(int[] arr) {
        long sum=0;
        int[] psee=new int[arr.length];
        int[] nse=new int[arr.length];
        psee=findPSEE(arr);
        nse=findNSE(arr);
        int mod=(int)(1e9+7);
        for(int i=0;i<arr.length;i++){
            int left=i-psee[i];
            int right=nse[i]-i;
            sum=(sum+(long)left*right*arr[i])%mod;
        }
        return (int)sum;
    }
    public int[] findNSE(int[] arr){
        int n=arr.length;
        int[] nse=new int[arr.length];
        Stack<Integer> st=new Stack<>();
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && arr[st.peek()]>=arr[i]){
                st.pop();
            }
            nse[i]=st.isEmpty()?n:st.peek();
            st.push(i);
        }
        return nse;
    }
    public int[] findPSEE(int[] arr){
        Stack<Integer> st=new Stack<>();
        int n=arr.length;
        int[] psee=new int[arr.length];
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && arr[st.peek()]>arr[i]){
                st.pop();
            }
            psee[i]=st.isEmpty()?-1:st.peek();
            st.push(i);
        }
        return psee;
    }
}