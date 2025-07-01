class Solution {
    public int substrCount(String s, int k) {
        // code here
        Map<Character,Integer>mp = new HashMap<>();
        int f = k-1;
        for(int i = 0;i<k;i++){
            if(mp.containsKey(s.charAt(i))){
                mp.put(s.charAt(i),mp.get(s.charAt(i))+1);
            }
            else{
                mp.put(s.charAt(i),1);
            }
        }
        int ans = 0;
        if(mp.size() == f) ans++;
        for(int i = k;i<s.length();i++){
            if(mp.containsKey(s.charAt(i-k))){
                mp.put(s.charAt(i-k),mp.get(s.charAt(i-k))-1);
                mp.entrySet().removeIf(entry->entry.getValue() == 0);
            }
            if(mp.containsKey(s.charAt(i))) mp.put(s.charAt(i),mp.get(s.charAt(i))+1);
            else mp.put(s.charAt(i),1);
            if(mp.size() == f) ans++;
        }
        return ans;
    }
}