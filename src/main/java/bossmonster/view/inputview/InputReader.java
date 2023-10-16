package bossmonster.view.inputview;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public final class InputReader {
    public static String read() {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(System.in));
            return br.readLine();
        } catch (IOException e) {
            closeReader(br);
            return read();
        }
    }

    private static void closeReader(BufferedReader br) {
        try {
            if (br != null) {
                br.close();
            }
        } catch (IOException e) {
            System.out.println(e.getStackTrace());
        }
    }
}
