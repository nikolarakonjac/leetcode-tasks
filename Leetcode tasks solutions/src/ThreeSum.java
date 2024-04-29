import java.util.*;

public class ThreeSum {

    public static List<List<Integer>>  threeSum1(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> setLists = new HashSet<>();
        for(int i=0;i<nums.length;i++){ //fix one by one element
            int target = nums[i] * (-1);    //the rest is 2 sum problem
            HashMap<Integer, Integer> map = new HashMap<>();
            for(int j=i+1; j< nums.length;j++){
                int temp = target - nums[j];
                if(map.containsKey(temp)){
                    List<Integer> sublist = new ArrayList<>();
                    sublist.add(nums[i]);
                    sublist.add(temp);
                    sublist.add(nums[j]);
                    setLists.add(sublist);
                }
                else{
                    map.put(nums[j], j);
                }
            }
        }

        return new ArrayList<>(setLists);
    }

    public static List<List<Integer>>  threeSum2(int[] nums){
        Arrays.sort(nums);
        List<List<Integer>> result = new LinkedList<>();

        for(int i=0;i<nums.length-2;i++){
            if(i == 0 || (i > 0 && nums[i] != nums[i-1])){
                //nums[i] != nums[i-1] uslov da ne ponavljamo za duplikate
                int low = i + 1;
                int high = nums.length - 1;
                int sum = nums[i] * (-1);

                while(low < high){
                    if(nums[low] + nums[high] == sum){
                        result.add(Arrays.asList(nums[i], nums[low], nums[high]));
                        while(low < high && nums[low] == nums[low+1]) low++;
                        while(low < high && nums[high] == nums[high-1]) high--;
                        low++;
                        high--;
                    }
                    else if(nums[low] + nums[high] > sum){
                        high--;
                    }
                    else{
                        low++;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        List<List<Integer>> lists = threeSum2(nums);

        for(List x: lists){
            for(Object y: x){
                System.out.print(" " + y + " ");
            }
            System.out.print("\n");
        }




    }


}
