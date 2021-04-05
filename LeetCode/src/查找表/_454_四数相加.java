package 查找表;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定四个包含整数的数组列表A , B , C , D ,计算有多少个元组 (i, j, k, l)，使得A[i] + B[j] + C[k] + D[l] = 0。
 *
 * 为了使问题简单化，所有的 A, B, C, D 具有相同的长度N，且 0 ≤ N ≤ 500 。所有整数的范围在 -228 到 228 - 1 之间，最终结果不会超过231 - 1 。
 *

 */

public class _454_四数相加 {
}


class Solution454 {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        //建立一个组合的查找表，C+D
        Map<Integer,Integer> comSheet = new HashMap<>();
        for(int i = 0; i < C.length; i++){
            for(int j = 0; j < D.length; j++){
                //comSheet中存放每一个组合出现的频率
                comSheet.put(C[i]+D[j],comSheet.getOrDefault(C[i]+D[j],0)+1);
            }
        }

        int res = 0;
        for(int i = 0; i < A.length; i++){
            for(int j =0; j < B.length; j++){
                //在查找表中查找满足条件的C[i]+D[j]的个数，何谓满足条件呢? 就是C[i]+D[j] = target-(A[i]+B[j])
                if(comSheet.containsKey(-A[i] - B[j])){
                    res += comSheet.get(-A[i] - B[j]);
                }
            }
        }
        return res;
    }
}