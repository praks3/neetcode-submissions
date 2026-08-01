
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

    boolean [] visited = new boolean[strs.length];
    List<List<String>> result = new ArrayList<>();

    for(int i=0;i<strs.length;i++){
        if(visited[i]) continue;
        List<String> group = new ArrayList<>();
        char [] strArr= strs[i].toCharArray();
        Arrays.sort(strArr);
        visited[i]=true;
        group.add(strs[i]);
        for(int j=i+1;j<strs.length;j++){
            char [] newStrArr= strs[j].toCharArray();
            Arrays.sort(newStrArr);
            if(Arrays.equals(strArr,newStrArr)){
                visited[j]=true;
                group.add(strs[j]);
            }
        }
        result.add(group);
    }




    return result;
    }
}
