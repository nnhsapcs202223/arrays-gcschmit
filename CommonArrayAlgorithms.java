public class CommonArrayAlgorithms
{
    /*
     * Create array of the specified size filled with
     *      random values based on the maximum value.
     */
    public static int[] createRandomArray( int length, int maxValue )
    {
        int[] randomArray = new int[ length ];
        for( int i = 0; i < randomArray.length; i++ )
        {
            randomArray[ i ] = (int)( Math.random() * maxValue );
        }

        return randomArray;
    }

    /*
     * Prints the specified array to System.out
     */
    public static void printArray( int[] array )
    {
        System.out.print("[");

        for(int i = 0; i < array.length; i++)
        {
            System.out.print(array[i]);
            if(i < array.length - 1)
            {
                System.out.print(", ");
            }
        }

        System.out.println("]");
    }

    /*
     * Array Algorithm #0: Sum and Average
     *  creates an array filled with random numbers
     *  calculates the sum and average of the numbers
     *  prints the array and the sum and average
     *  @returns the average
     */
    public static double sumAndAverage()
    {
        double sum = 0;
        double average = 0;

        int[] array = createRandomArray( 10, 50 );

        for( int element : array)
        {
            sum += element;
        }

        average = sum / array.length;

        printArray( array );
        System.out.println( "sum: " + sum + " average: " + average );

        return average;
    }

    /*
     * Array Algorithm #1: Print Element Separators
     *  creates an array filled with random numbers
     *  prints each element of the array with a '|' between each element
     *      but not at the beginning or end of the array
     */
    public static void printElementSeparators(int length, int maxValue)
    {
        int[] randomArray = createRandomArray(length, maxValue);

        for(int i = 0; i < randomArray.length; i++)
        {
            if(i == 0)
            {
                System.out.print(randomArray[i]);
            }
            else
            {
                System.out.print(" | " + randomArray[i]);
            }
        }
    }

    /*
     * Array Algorithm #2: Linear Search
     *  creates an array filled with random numbers
     *  find the index of the first element with the specified value
     *  prints the array and the index (or -1 if not found)
     *    @returns the index of the first element with the specified value (or -1 if not found)
     */
    public static int linearSearch( int valueToFind )
    {
        int[] randArr = createRandomArray(10, 50);
        int index = -1;
        printArray(randArr);
        for (int i = 0; i < randArr.length; i++)
        {
            if (randArr[i] == valueToFind)
            {
                index = i;
                break;
            }
        }
        if (index == -1)
            System.out.println(-1);
        else
            System.out.println("first index of " + valueToFind + ": " + index);

        return index;
    }

    /*
     * Array Algorithm #3: Count Less Than
     *  creates an array filled with random numbers
     *  counts the number of elements that are less than the specified value
     *  prints the array and the count
     *  @return returns the number of elements that are less than the specified value
     */
    public static int countLessThan( int limit )
    {
        int count = 0;
        int[] array = createRandomArray( 10, 50 );

        for( int element : array)
        {
            if(element < limit)
            {
                count++;
            }
        }

        printArray( array );
        System.out.println( "Count: " + count );

        return count;
    }

    /*
     * Array Algorithm #4: findMax
     *  creates an array filled with random numbers
     *  prints the array and the greatest number
     * @return returns the greatest number in the array
     */
    public static int findMax()
    {
        int[] arr = createRandomArray(10, 100);
        printArray(arr);
        int curma = arr[0];     // Integer.MIN_VALUE;
        for(int i = 0; i < arr.length; ++i) {
            if(arr[i] > curma) {
                curma = arr[i];
            }
        }
        System.out.println(curma);
        return curma;
    }

    /*
     * Array Algorithm #5: Reverse Array
     *  creates an array filled with random numbers
     *  creates a new array of the same size
     *  copies elements from the first array into the new array in reverse order
     *  prints the original array and the new array
     *  returns the new array
     */
    public static int[] reverseArray()
    {
        int[] array = createRandomArray(5, 10);

        int length = array.length;
        int[] array2 = new int[length];

        for (int i = length - 1; i >= 0; i--)
        {
            array2[(length - 1) - i] = array[i];
        }

        printArray(array);
        printArray(array2);

        return array2;
    }

    /*
     * Array Algorithm #6: Mode
     *  creates an array filled with random numbers
     *  calculates the mode (most frequent value in the array)
     *  prints the array and the mode
     *  @returns the mode of the elements in the array
     */
    public static int mode()
    {
        /* hint: when creating the random array, specify parameters that will
         *    likely result in a value being repeated multiple times;
         *    create another array to keep track of how many times each value
         *    occurs (index is the number and the value is the number of occurrences)
         */

        int[] x = createRandomArray(10,10);
        int[] countArr = new int[10];

        int maxAmt = 0;
        int mode = 0;
        for(int val: x) {

            countArr[val]++;
            if(countArr[val] > maxAmt) {

                maxAmt = countArr[val];
                mode = val;
            }
        }

        for(int val: x) {

            System.out.print(" " + val);

        }
        System.out.println("-");
        printArray(countArr);
        System.out.println(mode);
        System.out.println(maxAmt);

        return 0;
    }

}