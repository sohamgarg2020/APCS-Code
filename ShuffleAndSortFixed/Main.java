class Main {
    
  public static void main(String[] args) {
    new Main().start();
  }
  public void start(){
    int[] nums;
    nums = fillArray(25, 10, 30);// fills nums with 25 numbers from 10 to 30
    System.out.println(print(nums));
    int min = findMin(nums);
    System.out.println(min);
    int maxIndex = findMax(nums);
    System.out.println(maxIndex);
    int[] sorted =  sort(nums);
    System.out.println(print(sorted));
    shuffle(sorted);
    System.out.println(print(sorted));
    
  }
  // print the contents of nums
  public String print(int[] bob1){
      String printing = "";
      int count = bob1.length-1;
      for (int i = 0; i < bob1.length; i++){
          printing += bob1[i];
          if (count > 0){
              printing += ",";
              count--;
          }
      }
    return printing;
  }
  // fills nums with n ints ranging from low to high inclusive
  // must use Math.random
  private int[] fillArray(int n, int low, int high){
      int[] bob = new int[n];
      for (int i = 0; i < n; i++){
          bob[i] = (int)(Math.random()*(high -low))+low;
      }
      return bob;
  }
  // returns the min element
  private int findMin(int[] nums){
    int minnum = Integer.MAX_VALUE;
    for (int i = 0; i < nums.length; i++){
      if (nums[i] < minnum){
        minnum = nums[i];
      }
    }
    return minnum;
  }
  // returns the INDEX of the max element
  private int findMax(int[] nums){
    int maxnum = 0;
    int ind = 0;
    for (int i = 0; i < nums.length; i++){
      if (nums[i] > maxnum){
        maxnum = nums[i];
        ind = i;
      }
    }
    return ind;
  }
  // returns an array that has the element at specified index 
  // removed from arr.  
  // Assume arr has length > 0 and index is valid
  private int[] removeElement(int index, int[] arr){

    int[] removed = new int[arr.length-1];

    for (int i = 0; i < index; i++){
      removed[i] = arr[i];
    }
    for (int i = index+1; i < arr.length; i++){
      removed[i-1] = arr[i];
    }

    return removed;
  }
// sorts nums using the following algorithm:
//1.  make a new array with the same length as nums.
//2.  while nums has elements
//    find the max
//    place the max at the "end" of the new array from step 1
//    remove the max from nums
//3.  nums has length 0, the new array will have the sorted 
//    elements, so point nums at the new array
  private int[] sort(int[] nums){
    int[] sorted = new int[nums.length];
    int max = 0;
    int ind = 0;
    while (nums.length > 0){
      for (int i = 0; i < nums.length; i++){
        if (nums[i] > max){
          max = nums[i];
          ind = i;
        }
      }
      sorted[nums.length-1] = nums[ind];
      nums = removeElement(ind, nums);
      max = 0;
    }
    

    return sorted;
  }
// shuffle the array using the following algorithm:
// 1. find two random indexes
// 2. swap the elements
// 3. repeat a bunch of times.
  public void shuffle(int[] nums){
    int num1 = 0;
    int num2 = 0;
    for (int i =0; i < 21; i++){
      num1 = (int)(Math.random()*(nums.length));
      num2 = (int)(Math.random()*(nums.length));
      while (num1 == num2){
        num1 = (int)(Math.random()*(nums.length));
        num2 = (int)(Math.random()*(nums.length));
      }
      int num3 = nums[num1];
      int num4 = nums[num2];
      nums[num1] = num4;
      nums[num2] = num3;

    }
  }
}