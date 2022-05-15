// Make a table 0f 255 array size and store all set bits from 1 to 255 in their corresponding index

// Important --> table[i] = (i & 1) + table[i / 2];
class Solution {
    public static int[] countBits(int n) {
        int[] table = new int[256];
        int[] countArray = new int[n + 1];
        for (int i = 1; i < 256; i++) {
            table[i] = (i & 1) + table[i / 2];
        }
        for (int j = 1; j <= n; j++) {
            int value = j;
            countArray[j] += table[value & 0xff];

            for (int k = 0; k < 3; k++) {
                value = value >> 8;
                countArray[j] += table[value & 0xff];
            }
            // System.out.println( countArray[value]);
        }
        return countArray;
    }
}
// @lc code=end
