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
    public static void printElementSeparators()
    {
        int[] randomArray = createRandomArray( 10, 50 );

        for(int x = 0;x<randomArray.length;x++){
            if(x>0){
                System.out.print("|"+randomArray[x]);
            }
            else{
                System.out.print(randomArray[x]);
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
        int[] array = createRandomArray( 50, 50 );
        boolean has_number =  false;
        int index = -1;
        int counter = 0;
        for(int i : array){
            if(i == valueToFind && !has_number){
                index = counter;
                has_number = true;
            }
            counter++;
        }
        for(int i : array){
            System.out.println(i);
        }
        System.out.println(index);
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
        int[] array = createRandomArray( 10, 50);

        int count = 0;

        for(int i : array)
        {
            if(i < limit)
            {
                count += 1;
            }
        }

        System.out.print("array: ");
        printArray(array);

        System.out.print("\ncount: " + count);
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
        int[] array = createRandomArray(10, 50);
        int greatest = 0;
        for(int i = 0; i<array.length; i++)
        {
            if (array[i]> greatest)
            {
                greatest = array[i];
            }
        }
        printArray(array);
        System.out.println(greatest);
        return greatest;
    }

    /*
     * Array Algorithm #5: Reverse Array
     *  creates an array filled with random numbers
     *  creates a new array of the same size
     *  copies elements from the first array into the new array in reverse order
     *  prints the original array and the new array
     *  returns the new array
     */
    public static int[] reverseArray(int size)
    {
        int[] array = createRandomArray(size, 50);
        int[] newArray = new int[size];
        int index = 0;
        for (int i = size - 1; i >= 0; i--)
        {
            newArray[index] = array[i];
            index++;
        }
        printArray(array);
        printArray(newArray);
        return newArray;
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

        int[] array = createRandomArray (20,5);
        int[] array2 = new int[5];
        int num = 0;

        int mode = 0;

        for (int element : array)
        {
            array2[element] += 1;
        }

        for (int i=0; i< array2.length; i++)
        {
            int newMode = array2[i];
            if (mode < newMode)
            {
                mode = newMode;
            }
        }

        for (int a = 0; a< array2.length; a++)
        {
            if (array2[a] == mode)
            {
                num = a;
            }
        }

        printArray(array);
        printArray(array2);
        System.out.println(num);

        return num;
    }

}