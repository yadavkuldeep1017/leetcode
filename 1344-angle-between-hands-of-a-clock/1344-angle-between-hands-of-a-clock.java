class Solution {
    public double angleClock(int hour, int minutes) {
        hour = hour % 12;
        double plusAngle = minutes/12.0;
        double hrAngle = hour * 5 +  plusAngle;
        // System.out.println(plusAngle+ " "+ hrAngle);
        double angle;
        if(minutes == hrAngle){
            return 0;
        }
        else if(minutes > hrAngle){
            angle = 6 * (minutes - hrAngle);
        }
        else{
            angle = 6 * (hrAngle - minutes);
        }
        if(angle > 180.0){
            return 360.0 - angle;
        }
        return angle;
    }
}