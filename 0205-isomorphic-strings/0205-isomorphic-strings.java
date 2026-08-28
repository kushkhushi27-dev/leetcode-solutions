class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length()!=t.length()) return false;
        HashMap<Character, Character> mapst=new HashMap<>();
        HashMap<Character, Character> mapts=new HashMap<>();
        for(int i=0;i<s.length();i++){
            char ch1=s.charAt(i);
            char ch2=t.charAt(i);
            if(mapst.containsKey(ch1) && mapst.get(ch1)!=ch2) return false;
            if(mapts.containsKey(ch2) && mapts.get(ch2)!=ch1) return false;
            mapst.put(ch1,ch2);
            mapts.put(ch2,ch1);
        }
        return true;
    }
}