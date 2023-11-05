package seminar05;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Homework01 {
    public static void main(String[] args) {
        try {
            backupFile(new File("./src/main/java/seminar05"), new File("./src/main/java/seminar05_backup"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void backupFile(File source, File dest) throws IOException {
        File[] files = source.listFiles();
        if (!dest.exists()) {
            dest.mkdir();
        }
        for (File item : files) {
            Files.copy(item.toPath(), Path.of(dest.toString() + "\\" + item.getName()));
        }
    }
}