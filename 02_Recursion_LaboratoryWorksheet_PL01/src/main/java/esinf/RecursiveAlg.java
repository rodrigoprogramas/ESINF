package esinf;

//Laboratory Worksheet - Recursion
public class RecursiveAlg {
    //EX1
    //a)
    public String reverseStringOrder(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }
        return s.charAt(s.length() - 1) + reverseStringOrder(s.substring(0, s.length() - 1));
    }

    //b)
    public int productOfTwoIntegers(int m, int n) {
        if (m >= 0 && n >= 0){
            if (n == 0 ) {
                return 0;
            }
            return m + productOfTwoIntegers(m, n - 1);
        }
        return 0;
    }
    //c)
    public int greatestCommonDivisor(int a, int b){
        if( a%b == 0){
            return b;
        }
        int remainder = a%b;
        return greatestCommonDivisor(b,remainder);
    }
    //d)
    public int convertStringDigitsToInt(String s){
        int i = 0;
        return convertStringDigitsToInt(s,i);

    }

    private int convertStringDigitsToInt(String s, int i){
        if (s.isEmpty()) return 0;
        int digit = Character.getNumericValue(s.charAt(0));
        int currentValue = digit * (int) Math.pow(10,s.length()-1);
        return  currentValue + convertStringDigitsToInt(s.substring(1),i+1);
    }
    //e)
    public boolean isPalindrome(int n) {
        if (n < 0) return false;
        return n == reverseRecursive(n, 0);
    }

    private int reverseRecursive(int n, int currentReverse) {
        if (n == 0) return currentReverse;
        return reverseRecursive(n / 10, (currentReverse * 10) + (n % 10));
    }

    //f)
    public int sumElementsArray(int[][] array){
        return sumElementsArray(array,0,0);
    }

    private int sumElementsArray(int[][] array, int row, int col){
        if (row >= array.length) return 0;
        if (col >=array[row].length){
            return sumElementsArray(array, row+1,0);
        }
        return array[row][col] + sumElementsArray(array, row, col + 1);
    }


}
