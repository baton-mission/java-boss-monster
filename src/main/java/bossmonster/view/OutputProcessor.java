package bossmonster.view;

public interface OutputProcessor {
    void print(Object result);

    void printError(String errMsg);

    default void printDecoration(){
        System.out.println("============================\n");
    }
}
