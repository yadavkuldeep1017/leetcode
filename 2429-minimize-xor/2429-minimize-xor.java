class Solution {
    public int minimizeXor(int num1, int num2) {
        int countOne1 = 0;
        int countOne2 = 0;
        int temp1 = num1, temp2 = num2;
        while (temp1 > 0) {
            countOne1 += temp1 & 1;
            temp1 = temp1 >> 1;
        }
        while (temp2 > 0) {
            countOne2 += temp2 & 1;
            temp2 = temp2 >> 1;
        }
        if (countOne1 == countOne2) {
            return num1;
        }
        int num = num1;
        int ans = num1;
        int x = 1;
        if (countOne1 < countOne2) {
            while (countOne2 > countOne1) {
                if ((num & 1) == 0) {
                    ans += x;
                    countOne2--;
                }
                num = num >> 1;
                x = x << 1;
            }
            return ans;
        }
        while (countOne1 > countOne2) {
            if ((num & 1) == 1) {
                ans -= x;
                countOne2++;
            }
            num = num >> 1;
            x = x << 1;
        }
        return ans;
    }
}