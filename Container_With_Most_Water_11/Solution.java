package Container_With_Most_Water_11;

class Solution {
    // Approach is to use two pointers and find max area
    public static int maxArea(int[] height) {
        int i = 0, max = 0, j = height.length - 1;
        while(i < j){
            int h1 = height[i], h2 = height[j];
            // Calculate area with the smallest line
            int a = Math.min(h1,h2) * (j - i);
            max = Math.max(max, a);
            if(h1 > h2) {
                j--;
            }else{
                i++;
            }
        }
        return max;
    }
}