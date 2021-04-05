package 查找表;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定平面上n对互不相同的点points ，其中 points[i] = [xi, yi] 。回旋镖 是由点(i, j, k) 表示的元组 ，其中i和j之间的距离和i和k之间的距离相等（需要考虑元组的顺序）。
 * 返回平面上所有回旋镖的数量。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-boomerangs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _447_查找距离相同的点 {
}


class Solution447 {
    //时间复杂度O(n^2)
    //空间复杂度O(n)
    public int numberOfBoomerangs(int[][] points) {
        int res = 0;
        //将i点作为枢纽点，遍历每一个i点，将其他点到i点的距离存起来，如果该距离出现的频率>1，则对应点的组合有freq*(freq-1)种
        for(int i = 0; i < points.length; i++){
            //记录所有其他非i点到i的距离
            Map<Integer,Integer> record = new HashMap<>();

            //其他所有点到i点的距离
            for(int j = 0; j < points.length; j++){
                if(j != i){
                    //计算距离，并存到查找表中  points[i] = [xi, yi]
                   int dx = points[i][0] - points[j][0]; //x1-x2
                   int dy = points[i][1] - points[j][1]; //y1-y2
                   int dis = dx * dx + dy * dy; //平方避免浮点数
                   record.put(dis,record.getOrDefault(dis,0)+1);
                }
            }
            //遍历查找表，将距离相同点出现频率大于2的进行计算
            for(int freq: record.values()){
                res += freq * (freq-1); //第一个点有freq种选择，第二个点自然只有freq-1种选择
            }
        }
        return res;
    }
}