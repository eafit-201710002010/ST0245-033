
/**
 * Write a description of class Recursion1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Recursion1
{
    /*
     * Given a non-negative int n, return the count of the occurrences of 7 as a digit, so for example 717 yields 2. (no loops). 
     * Note that mod (%) by 10 yields the rightmost digit (126 % 10 is 6), while divide (/) by 10 removes the rightmost digit (126 / 10 is 12).
     */
    public static int count7(int n){
        int count=0;
        if(n%10==7){
            count++;
        }
        if(n/10==0){
            return count;
        }
        return count+count7(n/10);
    }
    
    /*
     * We have triangle made of blocks. 
     * The topmost row has 1 block, the next row down has 2 blocks, the next row has 3 blocks, and so on. 
     * Compute recursively (no loops or multiplication) the total number of blocks in such a triangle with the given number of rows.
     */
    public static int triangle(int rows){
        if(rows==0 || rows==1){
            return rows;
        }
        return rows+triangle(rows-1);
    }
    
    /*
     * We have a number of bunnies and each bunny has two big floppy ears. 
     * We want to compute the total number of ears across all the bunnies recursively (without loops or multiplication).
     */
    public static int bunnyEars(int bunnies){
        if(bunnies==0){
            return bunnies;
        }
        return 2+bunnyEars(bunnies-1);
    }
    
    /*
     * Given an array of ints, compute recursively if the array contains a 6. 
     * We'll use the convention of considering only the part of the array that begins at the given index. 
     * In this way, a recursive call can pass index+1 to move down the array. 
     * The initial call will pass in index as 0.
     */
    public static boolean array6(int[] nums, int index){
        if(index==nums.length){
            return false;
        }
        if(nums[index]==6){
            return true;
        }
        return array6(nums, index+1);
    }
    
    /*
     * Given an array of ints, compute recursively if the array contains somewhere a value followed in the array by that value times 10.
     * We'll use the convention of considering only the part of the array that begins at the given index. 
     * In this way, a recursive call can pass index+1 to move down the array. The initial call will pass in index as 0.
     */
    public static boolean array220(int[] nums, int index){
        if(nums.length-1<=index){
            return false;
        }
        if(nums[index]*10==nums[index+1]){
            return true;
        }
        return array220(nums, index+1);
    }
}
