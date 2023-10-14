package bossmonster.view;

public class OutputProcessorBySystemOut implements OutputProcessor {
    @Override
    public void print(Object result) {
        System.out.println(result);
    }

    @Override
    public void printError(String errMsg) {
        System.out.println(String.format("[ERROR] %s", errMsg));
    }
}
