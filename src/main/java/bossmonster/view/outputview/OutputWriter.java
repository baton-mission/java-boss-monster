package bossmonster.view.outputview;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public final class OutputWriter {
    private static BufferedWriter bw;

    private OutputWriter() {
    }

    public static void write(String text) {
        try {
            if (bw == null) {
                bw = new BufferedWriter(new OutputStreamWriter(System.out));
            }
            bw.write(text);
        } catch (IOException e) {
            closeWriter();
        }
    }

    public static void writeln(String text) {
        write(text + "\n");
    }

    public static void print() {
        try {
            bw.flush();
        } catch (IOException e) {
            closeWriter();
        }
    }

    private static void closeWriter() {
        try {
            bw.close();
        } catch (IOException e) {
            System.out.println(e.getStackTrace());
        }
    }
}
