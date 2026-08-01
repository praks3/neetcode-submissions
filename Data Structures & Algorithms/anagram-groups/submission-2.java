
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
    /*
    BF: nested +sorting
    1. Nested Loop Comparison + Visited check for deduplication
    2. Sort both the string and compare.
    3. if match visisted= true and add in the ans

    Better: Hashmap + sorting
    1. Sort each string and use the sorted string as the HashMap key.
    2. If the sorted key already exists in the HashMap, add the original 
    string to its list; otherwise, create a new list and add the string.

    Optimal: HashMap + freqCount
    1. Compute the frequency count of each string and convert it into a 
    unique string key.
    2. Use the frequency key as the HashMap key; if the key exists, add 
    the string to its list, otherwise create a new list.
    */
    Map<String,List<String>> map = new HashMap<>();

    for(int i=0;i<strs.length;i++){

        int[] freqCount= new int[26];

        for(char c:strs[i].toCharArray()){
            freqCount[c-'a']++;
        }
        StringBuilder s= new StringBuilder();
        for(int count:freqCount){
            s.append('#').append(count);

        }
        map.computeIfAbsent(s.toString(),k->new ArrayList<>()).add(strs[i]);
    }
    return new ArrayList<>(map.values());
    }
}
