import java.util.Random;

public class Main {

    private static double ufTest(UF uf, int m){
        long startTime = System.nanoTime();
        Random random = new Random();
        for (int i = 0; i < m; i++){
            uf.isConnected(random.nextInt(m),random.nextInt(m));
        }
        for (int i = 0; i < m; i++){
            uf.unionElements(random.nextInt(m),random.nextInt(m));
        }
        long endTime = System.nanoTime();
        return (endTime-startTime)/1000000000.0;
    }
    public static void main(String[] args) {
        int size = 1000000;
        int m = 100000;
        UnionFind1 unionFind1 = new UnionFind1(size);
        UnionFind2 unionFind2 = new UnionFind2(size);
        UnionFind3 unionFind3 = new UnionFind3(size);
        System.out.println("unionFind1: " + ufTest(unionFind1, m) + "s");
        System.out.println("unionFind2: " + ufTest(unionFind2,m) + "s");
        System.out.println("unionFind3: " + ufTest(unionFind3,m) + "s");
    }
}
