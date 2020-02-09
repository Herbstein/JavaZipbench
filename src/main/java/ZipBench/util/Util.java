package ZipBench.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Util {
    public static long countLines(InputStream stream) throws IOException {
        var reader = new InputStreamReader(stream);
        var bufferedReader = new BufferedReader(reader);

        var total = 0L;

        var data = bufferedReader.read();
        while (data != -1) {
            var ch = (char) data;
            if (ch == '\n') {
                total += 1;
            }

            data = bufferedReader.read();
        }

        return total;
    }
}
