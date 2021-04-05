import org.junit.Test;

import java.util.Random;

public class Main {

    @Test
    public void test1() {
        Array<Integer> array = new Array<>(10);
        for (int i = 0; i < 10; i++) {
            array.addLast(i);
        }
        System.out.println(array);

        array.addFirst(100);
        array.add(5, 30);
        System.out.println(array);

        array.remove(2);
        array.removeElement(3);
        array.removeFirst();
        array.removeLast();
        System.out.println(array);
    }

    @Test
    public void test2() {
        ArrayStack<Integer> arrayStack = new ArrayStack<>();
        for (int i = 0; i < 5; i++) {
            arrayStack.push(i);
        }
        System.out.println(arrayStack);
        arrayStack.pop();
        System.out.println(arrayStack);
    }

    @Test
    public void test3() {
        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
        for (int i = 0; i < 10; i++) {
            arrayQueue.enqueue(i);
            System.out.println(arrayQueue);
            if (i % 3 == 2) {
                System.out.println(arrayQueue);
            }
        }
    }

    @Test
    public void test4() {
        LoopQueue<Integer> loopQueue = new LoopQueue<>();
        for (int i = 0; i < 10; i++) {
            loopQueue.enqueue(i);
            System.out.println(loopQueue);
            if (i % 3 == 2) {
                loopQueue.dequeue();
                System.out.println(loopQueue);
            }
        }
    }

    @Test
    public void test5() {
        int count = 10000;
        LoopQueue<Integer> loopQueue = new LoopQueue<>();
        double time = queueTest(loopQueue, count);
        System.out.println("LoopQueue: "+ time + "s");

        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
        time = queueTest(arrayQueue,count);
        System.out.println("ArrayQueue: "+ time + "s");
    }

    @Test
    public void test6() {
        int count = 1000000;
        ArrayStack<Integer> arrayStack = new ArrayStack<>();
        double time = stackTest(arrayStack, count);
        System.out.println("arrayStack: "+ time + "s");

        //栈的复杂度和ArrayStack基本一致，主要用时花在了new对象的过程(寻找内存空间)中
        LinkedListStack<Integer> linkedListStack = new LinkedListStack<>();
        time = stackTest(linkedListStack,count);
        System.out.println("linkedListStack: "+ time + "s");
    }

    private double queueTest(Queue<Integer> queue, int count){
        Random random = new Random();
        long startTime = System.nanoTime();
        for (int i = 0; i < count; i++){
            queue.enqueue(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < count; i++){
            queue.dequeue();
        }
        long endTime = System.nanoTime();
        return (endTime - startTime)/1000000000.0;
    }

    private double stackTest(Stack<Integer> stack, int count){
        Random random = new Random();
        long startTime = System.nanoTime();
        for (int i = 0; i < count; i++){
            stack.push(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < count; i++){
            stack.pop();
        }
        long endTime = System.nanoTime();
        return (endTime - startTime)/1000000000.0;
    }
}
