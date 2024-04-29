import java.util.HashMap;

public class TwoSum {

    public static int[] twoSum(int[] nums, int target){
        int result[] = {-1, -1};
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<nums.length; i++){
            int temp = target - nums[i];
            if(map.containsKey(temp)){
                result[0] = map.get(temp);
                result[1] = i;
                break;
            }
            map.put(nums[i], i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {3,3};
        int target = 6;
        int[] result = twoSum(nums, target);
        System.out.println(result[0] + " " + result[1]);
    }

}
