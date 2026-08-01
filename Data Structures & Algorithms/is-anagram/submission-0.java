class Solution {
    public boolean isAnagram(String s, String t) {
        int s1=s.length();
        int s2=t.length();

        if(s1!=s2) return false;
        char[] a = s.toCharArray();
        char[] b = t.toCharArray();

    Arrays.sort(a);
    Arrays.sort(b);
    return Arrays.equals(a, b);
    }
}
