import java.util.*;

public class TwoSumFraudDetector {

    public static void findTwoSum(int[] nums, int target){

        Map<Integer,Integer> map = new HashMap<>();

        for(int i=0;i<nums.length;i++){

            int complement = target - nums[i];

            if(map.containsKey(complement)){
                System.out.println("Pair found: " + nums[i] + " + " + complement);
                return;
            }

            map.put(nums[i],i);
        }

        System.out.println("No pair found");
    }

    public static void main(String[] args){

        int[] transactions = {500,300,200,700};

        findTwoSum(transactions,500);
    }
}
