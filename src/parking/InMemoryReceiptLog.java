package parking;

import java.util.ArrayList;
import java.util.List;

public class InMemoryReceiptLog implements ReceiptLog {
    public final List<String> lines = new ArrayList<>();

    @Override
    public void log(String line) {
        lines.add(line);
    }
}
