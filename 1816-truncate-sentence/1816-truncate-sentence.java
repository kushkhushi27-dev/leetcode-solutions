class Solution {
    public String truncateSentence(String s, int k) {
        String[] st=s.split(" ");
        String ans="";
        for(int i=0;i<k;i++){
            ans+=st[i];
            if(i!=k-1) ans=ans+" ";
        }
        return ans;
    }
}