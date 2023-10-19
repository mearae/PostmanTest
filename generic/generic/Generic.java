package generic;

public class Generic {
    public static <T> void output(T[] array){
        for (T element : array){
            System.out.print(element + " ");
        }
    }
}
