package Interview.General;

/*
Previously, algorithm will first search the maximal bar in the heights and then do two traverse -
one from the leftmost bar to the highest bar and another one from the rightmost to the highest bar.
This solution combine these three steps in a very clever way so I modified my code as following:
 */
public class TrappingRainWater {
    public int trap(int[] heights) {

        if ( heights.length <= 2 ) { return 0; }

        int left = 0, right = heights.length-1, totalArea = 0;
        int leftMaxHeight = heights[left], rightMaxHeight = heights[right];

        while ( left < right ) {
            if ( heights[left] < heights[right] ) {
                leftMaxHeight = Math.max(leftMaxHeight, heights[++left]);
                totalArea += leftMaxHeight-heights[left];
            } else {
                rightMaxHeight = Math.max(rightMaxHeight, heights[--right]);
                totalArea += rightMaxHeight-heights[right];
            }
        }
        return totalArea;
    }
}