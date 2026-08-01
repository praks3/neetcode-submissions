class Solution {
    public boolean isAnagram(String s, String t) {
        int s1=s.length();
        int s2=t.length();
        if(s1!=s2) return false;
        int [] freqCount= new int[26];
        for(int i=0;i<s1;i++){
           freqCount[s.charAt(i)-'a']++;
           freqCount[t.charAt(i)-'a']--;
        }
        for(int num:freqCount){
            if(num!=0) return false;
        }

        return true;
    }
}
