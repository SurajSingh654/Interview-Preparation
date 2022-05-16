// Algorithm
// -> XOR all numbers and store in 'n'
// -> n & -n {gives you binary of only one set bit }
// -> create two variables x and y
// -> Xor x and array value whose bit at position corresponding to set bit of n & -n is same
// -> else XOR x and remaining array elements
// -> return x and y 
package GFG;

class Solution {
    static int Log(int value, int base) {
        return (int) (Math.log(value) / Math.log(base));
    }

    public static int[] singleNumber(int[] nums) {
        // Code here
        int values[] = new int[2];
        int twoNumberXOR = 0;
        for (int num : nums) {
            twoNumberXOR ^= num;
        }
        int posRightSetBit = Log((twoNumberXOR & (twoNumberXOR - 1)) ^ twoNumberXOR, 2);
        int zeroAtPos = 0;
        int oneAtPos = 0;
        for (int num : nums) {
            int masking = 1 << posRightSetBit;
            if ((num & masking) == 0) {
                zeroAtPos ^= num;
            } else {
                oneAtPos ^= num;
            }
        }

        if (oneAtPos > zeroAtPos) {
            values[1] = oneAtPos;
            values[0] = zeroAtPos;
        } else {
            values[0] = oneAtPos;
            values[1] = zeroAtPos;
        }

        return values;
    }

    public static void main(String[] args) {
        int[] a = { 3, 2, 2, 3, 1, 8 };
        System.out.println(singleNumber(a));
    }
}
