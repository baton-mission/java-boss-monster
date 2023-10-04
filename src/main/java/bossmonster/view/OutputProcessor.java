package bossmonster.view;

public interface OutputProcessor {
    void print(Object result);
    void printError(Exception e);
    default void printDecoration(){
        System.out.println("============================\n");
    }
}
