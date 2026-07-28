class Solution {
    public String smallestPalindrome(String s) {
        int n = s.length();
        if(n <= 1)
            return s;
        Map<Character, Integer> map = new TreeMap<>();

        for(int i=0; i<n; i++){
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }
        char[] arr = new char[n];
        int i=0;
        for(Map.Entry<Character, Integer> entry: map.entrySet()){
            if(entry.getValue() % 2 == 0){
                for(int j=0; j<entry.getValue()/2; j++){
                    arr[i] = entry.getKey();
                    arr[n-1-i] = entry.getKey();
                    i++;
                }
            }
            else if(entry.getValue() % 2 != 0){
                if(entry.getValue() > 1){
                    for(int j=0; j<entry.getValue()/2; j++){
                        arr[i] = entry.getKey();
                        arr[n-1-i] = entry.getKey();
                        i++;
                    }
                }
                arr[n/2] = entry.getKey();
            }
        }
        String str = new String(arr);
        return str;
    }
}