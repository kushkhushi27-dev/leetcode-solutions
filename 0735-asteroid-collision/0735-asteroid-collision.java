class Solution {
    public int[] asteroidCollision(int[] asteroid) {
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<asteroid.length;i++){
            if(asteroid[i]>0) st.push(asteroid[i]);
            else{
                while(!st.isEmpty() && st.peek()>0 && st.peek()<Math.abs(asteroid[i])){
                    st.pop();
                }
                if(!st.isEmpty() && st.peek()==Math.abs(asteroid[i])){
                    st.pop();
                }
                else if(st.isEmpty() || st.peek()<0) st.push(asteroid[i]);
            }
        }
        int[] ans=new int[st.size()];
        for(int i=ans.length-1;i>=0;i--){
            ans[i]=st.pop();
        }
        return ans;
    }
}