package bench;

import ZipBench.CountingVisitor;
import ZipBench.util.Util;
import org.openjdk.jmh.Main;
import org.openjdk.jmh.annotations.Benchmark;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.zip.ZipFile;

public class BenchMain {
    public static void main(String[] args) throws Exception {
        Main.main(args);
        var zipCount = countZip();
        var dirCount = countDir();

        System.out.println("Zip: " + zipCount + "\tDir: " + dirCount);
    }

    @Benchmark
    public static long countZip() throws Exception {
        var zipFile = new ZipFile("node_modules.zip");

        var total = 0L;

        var entries = zipFile.entries();
        while (entries.hasMoreElements()) {
            var entry = entries.nextElement();
            if (entry.isDirectory()) {
                continue;
            }

            var stream = zipFile.getInputStream(entry);
            total += Util.countLines(stream);
        }

        return total;
    }

    @Benchmark
    public static long countDir() throws Exception {
        var visitor = new CountingVisitor();

        var dirPath = Paths.get("node_modules");
        Files.walkFileTree(dirPath, visitor);

        return visitor.getCount();
    }
}
