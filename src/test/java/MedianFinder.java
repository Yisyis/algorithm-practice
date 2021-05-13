import java.util.*;

/**
 * @author YeShuai
 * @date 2021/4/27
 */
public class MedianFinder {

    public void moveZeroes(int[] nums) {
        int fast = 0;
        int slow = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[fast] != 0) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        // Arrays.fill(nums,slow,nums.length,0);
        for (int i = slow; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    public static void main(String[] args) {
        String s = "pwwkew";
        String t = "abc";
        int[] a = {0,1,0,3,12};
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.moveZeroes(a);
        // medianFinder.addNum(2);
        // double median = medianFinder.findMedian();
        // System.out.println(median);

    }
}
