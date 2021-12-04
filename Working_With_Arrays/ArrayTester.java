import java.util.Arrays;
import java.util.*;

public class ArrayTester {
    private int[] nums;
    private int[] nums2;
    private int[] modes;
    int minnum;
    int maxnum;
    public static void main(String[] args){
        ArrayTester at = new ArrayTester();
        at.makeRandoms();
        at.print();
        int min = at.findMin();
        int max = at.findMax();
        System.out.println("The min is: "+min+ " and the max is: "+max);

        double mean = at.findMean();
        System.out.println("The mean is: "+mean);

        int odds = at.countOdds();
        System.out.println("The number of odd elements is: " + odds);

        double stdDev = at.calcStandardDev();
        System.out.println("The standard deviation is: "+stdDev);

        double pct = at.percentWithinStdDev(1);
        System.out.println("Percent: " + pct);
        
        int[] modes = at.findModes();
        System.out.println("The modes are: "+Arrays.toString(modes));

        double median = at.findMedian();
        System.out.println("The median is: "+median);

        

    }
    /**
     * Print the contents of nums in a pretty way
     */
    private void print() {
        String printing = "Nums are: ";
        int count = nums.length-1;
        for (int i = 0; i < nums.length; i++){
            printing += nums[i];
            if (count > 0){
                printing += ", ";
                count--;
            }
            
        }
        System.out.println(printing);
    }
    /**prompt the user for the number of elements, the min element and 
     * max element to create.  Then create an array with that number of 
     * elements randomly ranging from min to max value.  Assign that
     * array  to nums (private instance field)
     */
    private void makeRandoms() {
        int numberofelements;
        int minnumber;
        int maxnumber;
        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter the number of elements: ");
        numberofelements = myObj.nextInt();
        while (true){
            if (numberofelements > 0){
                break;
            } else {
                System.out.println("It has to be a positive integer. Please try again.");
                System.out.println("Enter the number of elements: ");
                numberofelements = myObj.nextInt();
            }
        }

        System.out.println("Enter the minimum element: ");
        minnumber = myObj.nextInt();
        while (true){
            if (minnumber > 0){
                break;
            } else {
                System.out.println("It has to be a positive integer. Please try again.");
                System.out.println("Enter the minimum element: ");
                minnumber = myObj.nextInt();
            }
        }

        System.out.println("Enter the maximum element which is greater than " + minnumber + ": ");
        maxnumber = myObj.nextInt();
        while (true){
            if (maxnumber > 0 && maxnumber > minnumber){
                break;
            } else {
                System.out.println("It has to be a positive integer and greater than the minimum number. Please try again.");
                System.out.println("Enter the maximum element which is greater than " + minnumber + ": ");
                maxnumber = myObj.nextInt();
            }
        }
        nums = new int[numberofelements];
        nums2 = new int[numberofelements];
        int randomNumber;
        for (int i = 0; i < numberofelements; i++){
            randomNumber = genRandom(minnumber, maxnumber);
            nums[i] = randomNumber;
            nums2[i] = randomNumber;
        }
        
        
        
    }
    public static int genRandom(int min, int max) {
		int range = (max - min) + 1;
		return (int)(Math.random() * range) + min;
	}
    /** find and return the minimum element in nums */
    private int findMin(){
        minnum = nums[0];
        for (int i = 1; i < nums.length; i++){
            if (nums[i] < minnum){
                minnum = nums[i];
            }
        }
        return minnum;
    }
    /** find and return the maximum element in nums */
    private int findMax(){
        maxnum = nums2[0];
        for (int i = 1; i < nums2.length; i++){
            if (nums2[i] > maxnum){
                maxnum = nums2[i];
            }
        }
        return maxnum;
    }
    /** find and return the mean of the elements in nums */
    private double findMean(){
        double sum = 0;
        for (int i = 0; i < nums2.length; i++){
            sum += nums2[i];
        }
        return sum/nums2.length;
    }
    /** find and return the mode(s) of the elements in nums 
     * Use the following algorithm:
     * 1.  find the min and max elements
     * 2.  starting with the min, count how many times it occurred
     * 3.  if it is best so far, make it the mode
     * 4.  if it ties the best so far, "add" this element to the returned array
     * 5.  either way, go on to the next number until we pass up max
     * @return an array with the modes.  If there is only one mode, the
     * array will have length 1
    */
    private int[] findModes(){
        int maxnumber = 0;
        modes = new int[1];
        for (int i = 0; i < nums.length; i++){
            if (nums[i] > maxnumber){
                maxnumber = nums[i];
            }
        }
        int minnumber = maxnumber + 1;
        int count;
        int highest = 0;
        for (int abc = 0; abc < nums.length; abc++){
            count = 0;
            for (int i = 0; i < nums.length; i++){
                if (nums[i] < minnumber && nums[i] > 0){
                    minnumber = nums[i];
                }
            }
            if (minnumber == maxnumber+1){
                break;
            }
            for (int i = 0; i < nums.length; i++){
                if (nums[i] == minnumber){
                    count++;
                }
            }
            if (highest == 0){
                modes[0] = minnumber;
                highest = count;
            }
            else if (count > highest){
                modes = resizearray(modes, 1);
                modes[0] = minnumber;
                highest = count;
            } else if (count == highest){
                modes = resizearray(modes, modes.length+1);
                modes[modes.length-1] = minnumber;
            }
            for (int i = 0; i < nums.length; i++){
                if (nums[i] == minnumber){
                    nums[i] = 0;
                }
            }
            minnumber = maxnumber+1;
        }
        return modes;
    }
    private static int[] resizearray(int[] array, int num){
        int[] array1 = new int[num];
        for (int i = 0; i < num; i++){
            if (i >= array.length){
                break;
            }
            array1[i] = array[i];
        }
        return array1;  
    }
    /** find and return the median of the elements in nums 
     * Use the following algorithm:
     * 1.  starting with min, count how many times it occurs. 
     * 2.  If at any time you reach the halfway point of the array, you have    * 
     *     found the median (middle number)
     * 3.  In the case of an array with an even number of elements, then you 
     *     will return the mean of the two middle elements.
    */
    private double findMedian(){
        
        int maxnumber = 0;
        for (int i = 0; i < nums2.length; i++){
            if (nums2[i] > maxnumber){
                maxnumber = nums2[i];
            }
        }
        int minnumber = maxnumber+1;
        int count = 0;
        int number = 0;
        double x = 0;
        if (nums2.length % 2 == 1){
            number = (nums2.length+1)/2;
        } else {
            number = nums2.length/2+1;
            x = number-1;
        }

        while (true){
            for (int i = 0; i < nums2.length; i++){
                if (nums2[i] < minnumber && nums2[i] > 0){
                    minnumber = nums2[i];
                }
            }
            for (int i =0; i < nums.length; i++){
                if (nums2[i] == minnumber){
                    
                    count++;
                    if (nums2.length %2 == 0 && x == count){
                        x = nums2[i];
                    }
                    if (number == count && nums2.length % 2 == 1){
                        return nums2[i];
                    } else if (number == count && nums2.length%2 == 0){
                        return (x+nums2[i])/2;
                    }
                    nums2[i] = 0;
                    

                }
            }
            minnumber = maxnumber+1;
            
        }
    }
    private int countOdds(){
        int oddnumber = 0;
        for (int i = 0; i < nums2.length; i++){
            if (nums2[i] % 2 != 0){
                oddnumber++;
            }
        }
        return oddnumber;
    }
    /** Returns the standard deviation of the data set
     * Use the following algorithm:
     * 1. find the mean
     * 2. for each element - 
     *    a)  find the difference between the element 
     *        and the mean
     *    b)  square the difference
     *    c)  add the square to a running total
     * 3.  Take the running total of squares of differences 
     *     from the mean and divide by number of elements
     * 4.  Take the square root of that number, that is the 
     *     standard deviation.  So, return it!
    */
    private double calcStandardDev(){
        double sum = 0;
        for (int i = 0; i < nums2.length; i++){
            sum += nums2[i];
        }
        double mean = sum/nums2.length;

        double total = 0;
        double diff;
        for (int i = 0; i < nums.length; i++){
            diff = (mean - nums[i])*(mean - nums[i]);
            total += diff;
        }

        total /= nums.length;
        return Math.sqrt(total);
    }
    /** Returns the percent of data within the specified number
     * of standard deviations from the mean of the data set
     * Use the following algorithm:
     * 1. find the mean
     * 2. find the standard deviation
     * 3. calculate how far away an element has to be
     *    to be at least the specified number of standards
     *    of deviation
     * 4. for each element - 
     *    a)  check to see if it is within the specified number 
     *        of deviations.  If so, count it.
     * 
     * 5.  return the percent 
     *     (num within stds of dev / size of array * 100)
    */
    private double percentWithinStdDev(double devs){
        double sum = 0;
        for (int i = 0; i < nums2.length; i++){
            sum += nums2[i];
        }
        double mean = sum/nums2.length;

        double total = 0;
        double diff;
        for (int i = 0; i < nums.length; i++){
            diff = (mean - nums[i])*(mean - nums[i]);
            total += diff;
        }

        total /= nums.length;

        total = Math.sqrt(total);

        double min = total - devs;
        double max = total+devs;
        double count = 0;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] > min && max > nums[i]){
                count++;
            }
        }
        return 100*count/(nums.length);

    }
    

}
