class Solution {
    public String smallestSubsequence(String s) {
        boolean[] visited = new boolean[26];
        int[] lastIdx = new int[26];
        int n = s.length();
        for(int i=0; i<n; i++){
            char ch = s.charAt(i);
            lastIdx[ch - 'a'] = i;
        }
        StringBuffer str = new StringBuffer();
        for(int i=0; i<n; i++){
            char ch = s.charAt(i);
            int idx = ch-'a';
            if(visited[idx])
                continue;
            while(str.length()>0 && str.charAt(str.length()-1) > ch && lastIdx[str.charAt(str.length()-1) - 'a'] > i){
                visited[str.charAt(str.length()-1)-'a'] = false;
                str.deleteCharAt(str.length()-1);
            }
            str.append(ch);
            visited[ch-'a'] = true;
        }
        return str.toString();
    }
}