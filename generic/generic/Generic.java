package generic;

public class Generic<T> {

    private T value;

    public T output(T t){
        value = t;
        return value;
    }

    public static class Inner<U>{
        private U innerValue;

        public U output(U u){
            innerValue = u;
            return innerValue;
        }
    }

}
