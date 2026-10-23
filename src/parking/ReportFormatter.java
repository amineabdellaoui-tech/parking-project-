package parking;

import java.util.List;

public interface ReportFormatter {
    String receiptLine(Receipt receipt);

    String dailyReport(List<Receipt> receipts,double total);
}
