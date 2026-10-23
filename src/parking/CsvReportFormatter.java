package parking;

import java.util.List;

public class CsvReportFormatter implements ReportFormatter {
    @Override
    public String receiptLine(Receipt r) {
        return String.join(",",r.plate(),r.type(),String.valueOf(r.hours()),
                String.valueOf(r.amount()),r.method());
    }

    @Override
    public String dailyReport(List<Receipt> receipts,double total) {
        StringBuilder stringBuilder=new StringBuilder("plate,type,hours,amount,method\n");
        for (Receipt r : receipts) stringBuilder.append(receiptLine(r)).append("\n");
        return stringBuilder.append("TOTAL,,,").append(total).append(",").toString();
    }
}
