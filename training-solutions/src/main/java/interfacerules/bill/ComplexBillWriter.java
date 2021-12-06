package interfacerules.bill;

import java.util.List;

public class ComplexBillWriter implements BillWriter{
    @Override
    public String writeBill(List<String> billItems) {
        //kenyér; darabszám: 1, egységár: 400, összesen: 400 Ft
        StringBuilder sb = new StringBuilder();
        for (String item: billItems) {
            String[] data = item.split(";");
            sb.append(data[0]);
            sb.append("; ");
            sb.append("darabszám: ");
            sb.append(data[2]);
            sb.append(", egységár: ");
            sb.append(data[1]);
            sb.append(", összesen: ");
            sb.append(Integer.parseInt(data[2]) * Integer.parseInt(data[1]));
            sb.append(" Ft\n");
        }
        return sb.toString();
    }
}
