public class PalindromeNumber2 {
    /**
     * @param n: non-negative integer n.
     * @return: return whether a binary representation of a non-negative integer n is a palindrome.
     */
    public boolean isPalindrome(int n) {
        // Write your code here
        int[] binary = new int[32];
        int init = n;
        int i = 0;
        while (n != 0) {
            binary[i] = n % 2;
            n = n / 2;
            i++;
        }
        return checkSymetric(binary, i);
    }
    
    private boolean checkSymetric(int[] array, int lens) {
        int start = 0;
        int end = lens - 1; 
        while (start < end) {
            if (array[start] != array[end]) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}