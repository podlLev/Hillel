import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {

        Stack<String> stringStack = new Stack<>();
        Queue<String> stringQueue = new LinkedList<>();

        System.out.println(fillStack(8, stringStack));
        System.out.println(fillQueue(10, stringQueue));

        System.out.println(remove(stringStack, stringQueue));
    }

    public static String fillStack(Integer size, Stack<String> stringStack){
        for (int i = 0; i < size; i++) {
            stringStack.push(String.valueOf(i));
        }
        return "The Stack is now filled with " + stringStack.size() + " items";
    }

    public static String fillQueue(Integer size, Queue<String> stringQueue){
        for (int i = 0; i < size; i++) {
            stringQueue.offer(String.valueOf(i));
        }
        return "The Queue is now filled with " + stringQueue.size() + " items";
    }

    public static String remove(Stack<String> stringStack, Queue<String> stringQueue){
        int biggerSize = Math.max(stringStack.size(), stringQueue.size());
        System.out.print("\nStack   Queue");
        for (int i = 0; i < biggerSize; i++) {

            if(stringStack.size() == 0){
                System.out.printf("%n  %-8s%-8s", " ", stringQueue.poll());
            }
            else if(stringQueue.size() == 0){
                System.out.printf("%n  %-8s%-8s", stringStack.pop(), " ");
            }
            else{
                System.out.printf("%n  %-8s%-8s", stringStack.pop(), stringQueue.poll());
            }
        }
        return "\nStack and Queue empty";
    }
}
