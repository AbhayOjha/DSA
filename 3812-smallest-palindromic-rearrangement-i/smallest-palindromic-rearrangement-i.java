class Solution {
    public String smallestPalindrome(String s) {
        int n = s.length();
        int mid = n/2;
        StringBuffer sb = new StringBuffer();
        for(int i=0; i<mid; i++){
            sb.append(s.charAt(i));
        }
        char[] ch = sb.toString().toCharArray();
        Arrays.sort(ch);
        sb.setLength(0);
        sb.append(ch);
        if(n%2 != 0){
            sb.append(s.charAt(mid));
        }
        for(int i=mid-1; i>=0; i--){
            sb.append(sb.charAt(i));
        }
        return sb.toString();
    }
}