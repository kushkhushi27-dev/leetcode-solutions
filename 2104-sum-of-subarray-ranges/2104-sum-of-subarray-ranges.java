class Solution {
    public long subArrayRanges(int[] nums) {
        return sumMax(nums)-sumMin(nums);
    }
    public long sumMin(int[] nums){
        int[] psee=findPSEE(nums);
        int[] nse=findNSE(nums);
        long sum=0;
        int n=nums.length;
        for(int i=0;i<n;i++){
            int left=i-psee[i];
            int right=nse[i]-i;
            sum=sum+((long)left*right*nums[i]);
        }
        return sum;
    }
    public int[] findNSE(int[] nums){
        int n=nums.length;
        int[] nse=new int[n];
        Stack<Integer> st=new Stack<>();
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && nums[st.peek()]>=nums[i]){
                st.pop();
            }
            nse[i]=st.isEmpty()?n:st.peek();
            st.push(i);
        }
        return nse;
    }
    public int[] findPSEE(int[] nums){
        int n=nums.length;
        int[] psee=new int[n];
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && nums[st.peek()]>nums[i]){
                st.pop();
            }
            psee[i]=st.isEmpty()?-1:st.peek();
            st.push(i);
        }
        return psee;
    }
    public long sumMax(int[] nums){
        int[] pgee=findPGEE(nums);
        int[] nge=findNGE(nums);
        long sum=0;
        int n=nums.length;
        for(int i=0;i<n;i++){
            int left=i-pgee[i];
            int right=nge[i]-i;
            sum=sum+((long)left*right*nums[i]);
        }
        return sum;
    }
    public int[] findNGE(int[] nums){
        int n=nums.length;
        int[] nge=new int[n];
        Stack<Integer> st=new Stack<>();
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && nums[st.peek()]<=nums[i]){
                st.pop();
            }
            nge[i]=st.isEmpty()?n:st.peek();
            st.push(i);
        }
        return nge;
    }
    public int[] findPGEE(int[] nums){
        int n=nums.length;
        int[] pgee=new int[n];
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && nums[st.peek()]<nums[i]){
                st.pop();
            }
            pgee[i]=st.isEmpty()?-1:st.peek();
            st.push(i);
        }
        return pgee;
    }
}