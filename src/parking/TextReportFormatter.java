package parking;

import java.util.List;

public class TextReportFormatter implements ReportFormatter {
    @Override
    public String receiptLine(Receipt r) {
        return r.plate()+" | "+r.type()+" | "+r.hours()+" h | "
                +r.amount()+" MAD | " +r.method();
    }

    @Override
    public String dailyReport(List<Receipt> receipts, double total) {
        StringBuilder stringBuilder = new StringBuilder("=== Daily report ===\n");
        for (Receipt r : receipts) stringBuilder.append(receiptLine(r)).append("\n");
        return stringBuilder.append("Total: ").append(total).append(" MAD").toString();
    }
}
