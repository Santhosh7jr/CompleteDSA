import java.util.* ;
import java.io.*;
public class Solution {

    public static void main(String[] args) {

        System.out.println(countStories(2, 1, 4));

    }

    public static int countStories(int x, int y, int z) {

        int storyCount = 0;
        int storySum = 0;

        while (z / y != 0) {

            if (z / y > 0) {
                z -= y;
                storySum++;
                storyCount++;
            }

            if (storySum >= x) {
                storyCount++;
                storySum = 0;
            }

        }

        return storyCount;

    }
}
