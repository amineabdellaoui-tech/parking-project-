package parking;

import java.io.FileWriter;
import java.io.IOException;
import java.io.UncheckedIOException;

public class FileReceiptLog implements ReceiptLog {
    private final String fileName;

    public FileReceiptLog(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void log(String line) {
        try (FileWriter w=new FileWriter(fileName, true)) {
            w.write(line+System.lineSeparator());
        }catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}
