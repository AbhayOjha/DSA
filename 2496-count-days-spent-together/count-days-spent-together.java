class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        
        int[] alice = findDays(arriveAlice, leaveAlice);
        int[] bob = findDays(arriveBob, leaveBob);

        int commonDays = Math.min(alice[1], bob[1]) - Math.max(alice[0], bob[0]) + 1;
        return commonDays > 0 ? commonDays : 0;
    }

    public int[] findDays(String arrival, String leave){
        int[] monthDays = {31,28,31,30,31,30,31,31,30,31,30,31};
        int aMonth = Integer.parseInt(arrival.substring(0,2));
        int aDay = Integer.parseInt(arrival.substring(3));
        int dMonth = Integer.parseInt(leave.substring(0,2));
        int dDay = Integer.parseInt(leave.substring(3));
        int[] days = new int[2];
        int sum = 0;
        for(int i=0; i<aMonth-1; i++){
            sum += monthDays[i];
        }
        days[0] = sum+aDay;
        sum = 0;
        for(int i=0; i<dMonth-1; i++){
            sum += monthDays[i];
        }
        days[1] = sum+dDay;
        return days;
    }
}