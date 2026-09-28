class Solution {
    public int maxDepth(String s) {
        int size = 0;
        Stack<Character> st = new Stack<>();
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '('){
                st.push(s.charAt(i));
            }
            else if(s.charAt(i) == ')'){
                size = Math.max(size, st.size());
                st.pop();
            }
        }
        return size;
    }
}