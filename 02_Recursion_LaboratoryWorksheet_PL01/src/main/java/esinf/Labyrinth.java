package esinf;



public class Labyrinth {
    
    /**
     *
     * @param actual the labyrinth in its actual (marked) form
     * @param y coordinate y in the labyrinth
     * @param x coordinate x in the labyrinth
     * @return the marked labyrinth or null if there is no way
     */
    //EX 2
    public static int [][] check(int [][] actual, int y, int x) {

        if (x < 0 || x >= actual.length || y < 0 || y >= actual[x].length) {
            return null;
        }

        if (actual[x][y] != 1) {
            return null;
        }

        actual[x][y] = 9;

        int[][] result = check(actual, y, x-1);

        if (result != null){
            return result;
        }

        result = check(actual, y+1 , x);
        if (result != null){
            return  result;
        }

        result = check(actual, y , x+1);
        if (result != null){
            return  result;
        }

        result = check(actual, y -1, x);
        if (result != null){
            return  result;
        }

        if (x == actual.length - 1 && y == actual[x].length - 1) {
            actual[x][y] = 9;
            return actual;
        }
        actual[x][y] = 2;
        return null;
    }
    //EX1
    public static void main(String[] args) {

        RecursiveAlg recursiveAlg = new RecursiveAlg();

        String result = recursiveAlg.reverseStringOrder("RODRIGO");

        System.out.println(result);

        int resultInt = recursiveAlg.productOfTwoIntegers(3,10);
        System.out.println(resultInt);

        int resultGretCommnDividor = recursiveAlg.greatestCommonDivisor(105,40);
        System.out.println(resultGretCommnDividor);

        String numericString = "13531";
        int convertStringInt = recursiveAlg.convertStringDigitsToInt(numericString);
        System.out.println(convertStringInt);

        System.out.println(recursiveAlg.isPalindrome(123));
        System.out.println(recursiveAlg.isPalindrome(222));
        System.out.println(recursiveAlg.isPalindrome(767));

        int[][] data = { { 1, 2 }, { 3,4} };
        System.out.println(recursiveAlg.sumElementsArray(data));
    }

}
