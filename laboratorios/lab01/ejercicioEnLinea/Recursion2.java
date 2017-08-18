
/**
 * Write a description of class Recursion2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Recursion2
{
    /*
     * Given an array of ints, is it possible to choose a group of some of the ints, such that the group sums to the given target with these additional constraints: 
     * all multiples of 5 in the array must be included in the group. 
     * If the value immediately following a multiple of 5 is 1, it must not be chosen. 
     * (No loops needed.)
     */
    public static boolean groupSum5(int start, int[] nums, int target){
        if(start>=nums.length){
            if(target==0){
                return true;
            }
            return false;
        }
        if(nums[start]%5==0){
            if(start<nums.length-1 && nums[start+1]==1){
                return groupSum5(start+2, nums, target-nums[start]);
            }
            return groupSum5(start+1, nums, target-nums[start]);
        }
        if(groupSum5(start+1, nums, target-nums[start])){
            return true;
        }
        return groupSum5(start+1, nums, target);
    }
    
    /*
     * Given an array of ints, is it possible to choose a group of some of the ints, beginning at the start index, such that the group sums to the given target? 
     * However, with the additional constraint that all 6's must be chosen. 
     * (No loops needed.)
     */
    public static boolean groupSum6(int start, int[] nums, int target){
        if(start==nums.length){
            if(target==0){
                return true;
            }
            return false;
        }
        if(nums[start]==6){
            return groupSum6(start+1, nums, target-nums[start]);
        }
        if(groupSum6(start+1, nums, target-nums[start])){
            return true;
        }
        return groupSum6(start+1, nums, target);
    }
    
    /*
     * Given an array of ints, is it possible to choose a group of some of the ints, such that the group sums to the given target with this additional constraint: 
     * If a value in the array is chosen to be in the group, the value immediately following it in the array must not be chosen. 
     * (No loops needed.)
     */
    public static boolean groupNoAdj(int start, int[] nums, int target){
        if(target==0){
            return true;
        }
        if(start>=nums.length){
            return false;
        }
        if(groupNoAdj(start+2, nums, target-nums[start])){
            return true;
        }
        return groupNoAdj(start+1, nums, target);
    }
    
    /*
     * Given an array of ints, is it possible to choose a group of some of the ints, such that the group sums to the given target, with this additional constraint: 
     * if there are numbers in the array that are adjacent and the identical value, they must either all be chosen, or none of them chosen. 
     * For example, with the array {1, 2, 2, 2, 5, 2}, either all three 2's in the middle must be chosen or not, all as a group.
     */
    public static boolean groupSumClump(int start, int[] nums, int target){
        if(start>=nums.length){
            return target==0;
        }
        if(start<nums.length-1 && nums[start]==nums[start+1]){
            return groupSumClump(start+2, nums, target);
        }
        if(groupSumClump(start+1, nums, target)){
            return true;
        }
        if(groupSumClump(start+1, nums, target-nums[start])){
            return true;
        }
        return false;
    }
    
    /*
     * Given an array of ints, is it possible to divide the ints into two groups, so that the sums of the two groups are the same. 
     * Every int must be in one group or the other. 
     * Write a recursive helper method that takes whatever arguments you like, and make the initial call to your recursive helper from splitArray(). 
     * (No loops needed.)
     */
    public static boolean splitArray(int[] nums){
        return helper(nums, 0, 0);
    }
    public static boolean helper(int[] nums, int i, int sum){
        if(i==nums.length){
            return sum==0;
        }
        if(helper(nums, i+1, sum+nums[i])){
            return true;
        }
        return helper(nums, i+1, sum-nums[i]);
    }
}
