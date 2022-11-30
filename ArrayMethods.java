import java.util.Arrays;


/**
 * Array Operations 2 Programming Activity
 *
 * @author @gcschmit
 * @version 21 November 2017
 */
public class ArrayMethods
{
    private int[] values;
    public ArrayMethods(int[] initialValues)
    {
        this.values = initialValues;
    }

    /*
     * 1. Swap the first and last elements in the array.
     */
    public void swapFirstAndLast()
    {
        int lastIndex = this.values.length - 1;
        int temp = this.values[0];

        this.values[0] = this.values[lastIndex];
        this.values[lastIndex] = temp;
    }

    /*
     * 2. Shift all elements by one to the right and move the last element into
     *      the first position. For example, 1 4 9 16 25 would be transformed into
     *      25 1 4 9 16.
     */
    public void shiftRight()
    {
        int temp = this.values[this.values.length - 1];

        for( int i = this.values.length - 1; i > 0; i-- )
        {
            this.values[i] = this.values[i - 1];
        }

        this.values[0] = temp;
    }

    /*
     * 3. Reverse the elements in the array
     */
    public void reverseElements()
    {
        int lastIndex = this.values.length - 1;
        
        for( int i = 0; i < this.values.length / 2; i++ )
        {
            int temp = this.values[i];
            this.values[i] = this.values[lastIndex - i];
            this.values[lastIndex - i] = temp;
        }
    }
    
    /*
     * 4. Replace all even elements with 0.
     */
    public void replaceEvens()
    {
        for( int i = 0; i < this.values.length; i++ )
        {
            if( this.values[i] % 2 == 0 ) // Number is even
            {
                this.values[i] = 0;
            }
        }
    }

    /*
     * 5. Return the second-largest element in the array.
     */
    public int getSecondLargest()
    {
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for( int i = 0; i < this.values.length; i++ )
        {
            if( this.values[i] >= largest )
            {
                secondLargest = largest;
                largest = this.values[i];
            }
        }

        return secondLargest;
    }

    /*
     * 6. Return true if the array is currently sorted in increasing order.
     */
    public boolean isSortedIncreasing()
    {
        boolean isSortedIncreasing = true;

        for( int i = 1; i < this.values.length; i++ )
        {
            if( this.values[i - 1] > this.values[i] )
            {
                isSortedIncreasing = false;
            }
        }

        return isSortedIncreasing;
    }

    /*
     * 7. Return true if the array contains two adjacent duplicate elements.
     */
    public boolean hasDuplicateAdjacentElements()
    {
        for( int i = 1; i < this.values.length; i++ )
        {
            if( this.values[i - 1] == this.values[i] )
            {
                return true;
            }
        }

        return false;
    }

    /*
     * 8. Return true if the array contains duplicate elements (which need not
     *     be adjacent).
     */
    public boolean hasDuplicateElements()
    {
        for( int i = 0; i < this.values.length; i++ )
        {
            for( int j = i + 1; j < this.values.length; j++ )
            {
                if( this.values[i] == this.values[j] )
                {
                    return true;
                }
            }
        }

        return false;
    }
    
    /*
     * E1. Replace each element except the first and last by the larger of its
     *      two neighbors.
     */
    public void replaceWithLargestNeighbor()
    {
        int prevValue = this.values[0];

        // Start loop at one, and stop before the end
        for( int i = 1; i < this.values.length - 1; i++ )
        {
            int temp = this.values[i];
            if (prevValue > this.values[i + 1])
            {
                this.values[i] = prevValue;
            }
            else
            {
                this.values[i] = this.values[i + 1];
            }
            prevValue = temp;
        }
    }

    /*
     * E2. Remove the middle element if the array length is odd, or the middle
     *      two elements if the length is even. (Tip: create a new array and
     *      update the values instance variable to refer to it.)
     */
    public void removeMiddle()
    {
        int size = this.values.length;
        int[] newValues;
        int firstIndexToRemove;
        int numberOfElementsToRemove;

        if( size % 2 == 0 )  // Size is even
        {
            firstIndexToRemove = size / 2 - 1;
            numberOfElementsToRemove = 2;
        }
        else  // Size is odd
        {
            firstIndexToRemove = size / 2;
            numberOfElementsToRemove = 1;
        }

        newValues = new int[this.values.length - numberOfElementsToRemove];

        // copy the elements before the middle two
        for( int i = 0; i < firstIndexToRemove; i++ )
        {
            newValues[i] = this.values[i];
        }

        // copy the elements after the middle two
        // the indicies for the two arrays will differ by 2
        for( int i = firstIndexToRemove + numberOfElementsToRemove;
                i < size;
                i++ )
        {
            newValues[i - numberOfElementsToRemove] = this.values[i];
        }

        this.values = newValues;
    }

    /*
     * E3. Move all even elements to the front, otherwise preserving the order
     *      of the elements.
     */
    public void moveEvens()
    {
        int endOfEvensIndex = 0;
        int temp;

        for( int i = 0; i < this.values.length; i++ )
        {
            if( this.values[i] % 2 == 0 ) // Even
            {
                temp = this.values[i];  // Save the even number

                /*
                 * shift all elements from the end of the evens at the front
                 *      of the array to this element to the right to make
                 *      room to insert this element
                 */ 
                for( int j = i; j > endOfEvensIndex; j-- )
                {
                    this.values[j] = this.values[j - 1];
                }

                this.values[endOfEvensIndex] = temp;
                endOfEvensIndex++;
            }
        }
    }
    
    public String toString()
    {
        return Arrays.toString( this.values );
    }

    public static void main( String[] args )
    {
        int[] testValues = new int[] { 3, 5, 6, 1, 11, 15, 2, 7, 6, 7 };
        ArrayMethods tester = new ArrayMethods( testValues );
        System.out.println("Swap First and Last");
        System.out.println( tester );
        tester.swapFirstAndLast();
        System.out.println( tester );

        testValues = new int[] { 3, 5, 6, 1, 11, 15, 2, 7, 6, 7 };
        tester = new ArrayMethods( testValues );
        System.out.println("Shift Right");
        System.out.println( tester );
        tester.shiftRight();
        System.out.println( tester );
        
        testValues = new int[] { 3, 5, 6, 1, 11, 15, 2, 7, 6, 7 };
        tester = new ArrayMethods( testValues );
        System.out.println( "Reverse elements");
        System.out.println( tester );
        tester.reverseElements();
        System.out.println( tester );
        
        testValues = new int[] { 3, 5, 6, 1, 11, 15, 2, 7, 6, 7 };
        tester = new ArrayMethods( testValues );
        System.out.println( "Replace Evens with Zeroes");
        System.out.println( tester );
        tester.replaceEvens();
        System.out.println( tester );
        
        testValues = new int[] { 3, 5, 6, 1, 11, 15, 2, 7, 6, 7 };
        tester = new ArrayMethods( testValues );
        System.out.println( "Get Second Largest: ");
        System.out.println( tester );
        System.out.println( tester.getSecondLargest());
        
        testValues = new int[] { 3, 5, 6, 1, 11, 15, 2, 7, 6, 7 };
        tester = new ArrayMethods( testValues );
        System.out.println( "Is Sorted Increasing: ");
        System.out.println( tester );
        System.out.println( tester.isSortedIncreasing());
        
        testValues = new int[] { 3, 5, 6, 8, 11, 15, 22, 37, 37, 47 };
        tester = new ArrayMethods( testValues );
        System.out.println( "Is Sorted Increasing: ");
        System.out.println( tester );
        System.out.println( tester.isSortedIncreasing());
        
        testValues = new int[] { 3, 5, 6, 8, 11, 15, 22, 37, 37, 47 };
        tester = new ArrayMethods( testValues );
        System.out.println( "Has Duplicate Adjacent Elements: ");
        System.out.println( tester );
        System.out.println( tester.hasDuplicateAdjacentElements());
        
        testValues = new int[] { 3, 5, 6, 8, 11, 15, 22, 37, 38, 47 };
        tester = new ArrayMethods( testValues );
        System.out.println( "Has Duplicate Adjacent Elements: ");
        System.out.println( tester );
        System.out.println( tester.hasDuplicateAdjacentElements());
        
        testValues = new int[] { 3, 5, 6, 8, 11, 15, 22, 37, 38, 47 };
        tester = new ArrayMethods( testValues );
        System.out.println( "Has Duplicate Elements: ");
        System.out.println( tester );
        System.out.println( tester.hasDuplicateElements());
        
        testValues = new int[] { 3, 11, 6, 8, 10, 11, 22, 37, 37, 47 };
        tester = new ArrayMethods( testValues );
        System.out.println( "Has Duplicate Elements: ");
        System.out.println( tester );
        System.out.println( tester.hasDuplicateElements());
        
        testValues = new int[] { 3, 5, 6, 1, 11, 15, 2, 7, 6, 7 };
        tester = new ArrayMethods( testValues );
        System.out.println( "Replace with Largest Neighbor");
        System.out.println( tester );
        tester.replaceWithLargestNeighbor();
        System.out.println( tester );
        
        testValues = new int[] { 3, 5, 6, 1, 11, 15, 2, 7, 6, 7 };
        tester = new ArrayMethods( testValues );
        System.out.println( "Remove Middle");
        System.out.println( tester );
        tester.removeMiddle();
        System.out.println( tester );
        
        testValues = new int[] { 3, 5, 6, 1, 11, 15, 2, 7, 6, 7 };
        tester = new ArrayMethods( testValues );
        System.out.println( "Move Evens to Front");
        System.out.println( tester );
        tester.moveEvens();
        System.out.println( tester );
        
        
    }
}
