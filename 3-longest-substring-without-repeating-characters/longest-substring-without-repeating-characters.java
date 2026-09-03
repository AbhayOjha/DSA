class Solution {
    public int lengthOfLongestSubstring(String s) {
        int longest = 0;
        int left = 0;
        HashSet<Character> set = new HashSet<>();
        for(int right = 0; right<s.length(); right++){
            if(!set.contains(s.charAt(right))){
                set.add(s.charAt(right));
                longest = Math.max(longest, right-left+1);
            }
            else{
                while(set.contains(s.charAt(right))){
                    set.remove(s.charAt(left));
                    left++;
                }
                set.add(s.charAt(right));
            }
        }
        return longest;
    }
}