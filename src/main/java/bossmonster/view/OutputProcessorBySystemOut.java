package bossmonster.view;

public class OutputProcessorBySystemOut implements OutputProcessor {
    @Override
    public void printResult(Object result) {
        System.out.println(result);
    }

    @Override
    public void printError(Exception e) {
        System.out.println(String.format("[ERROR] %s",e.getMessage()));
    }
}
