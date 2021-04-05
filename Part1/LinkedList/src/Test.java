public class Test {

    @org.junit.Test
    public void test1(){
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < 5; i++){
            list.addFirst(i);
            System.out.println(list);
        }
        list.add(2,666);
        System.out.println(list);

        list.remove(2);
        System.out.println(list);

        list.removeFirst();
        System.out.println(list);

    }

    @org.junit.Test
    public void test2(){
        LinkedListStack<Integer> stack = new LinkedListStack<>();
        for (int i = 0; i < 5; i++){
            stack.push(i);
            System.out.println(stack);
        }

        stack.pop();
        System.out.println(stack);
    }



    @org.junit.Test
    public void test3() {
        LinkedListQueue<Integer> linkedListQueue = new LinkedListQueue<>();
        for (int i = 0; i < 10; i++) {
            linkedListQueue.enqueue(i);
            System.out.println(linkedListQueue);
            if (i % 3 == 2) {
                linkedListQueue.dequeue();
                System.out.println(linkedListQueue);
            }
        }
    }
}
