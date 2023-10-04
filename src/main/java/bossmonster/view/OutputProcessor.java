package bossmonster.view;

public interface OutputProcessor {
    void printResult(Object result);
    void printError(Exception e);
    default void printSectionBar(){
        System.out.println("____________________________");
    }
}
