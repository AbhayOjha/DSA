class Solution {
    public String smallestSubsequence(String s) {
        boolean[] visited = new boolean[26];
        int[] lastIdx = new int[26];
        int n = s.length();
        for(int i=0; i<n; i++){
            char ch = s.charAt(i);
            lastIdx[ch - 'a'] = i;
        }
        Stack<Character> st = new Stack<>();
        for(int i=0; i<n; i++){
            char ch = s.charAt(i);
            int idx = ch-'a';
            if(visited[idx])
                continue;
            while(!st.isEmpty()){
                if(st.peek() < ch)  break;
                if(lastIdx[st.peek()-'a'] < i)  break;
                char top = st.pop();
                visited[top-'a'] = false;
            }
            st.push(ch);
            visited[idx] = true;
        }
        StringBuffer res = new StringBuffer();
        for(char ch: st){
            res.append(ch);
        }
        return res.toString();
    }
}