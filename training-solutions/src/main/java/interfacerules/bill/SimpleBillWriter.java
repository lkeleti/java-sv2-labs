package interfacerules.bill;

import java.util.List;

public class SimpleBillWriter implements BillWriter{
    @Override
    public String writeBill(List<String> billItems) {
        StringBuilder sb = new StringBuilder();
        for (String item: billItems){
            String[] data = item.split(";");
            sb.append(data[0]);
            sb.append(", ");
            sb.append(data[2]);
            sb.append(" * ");
            sb.append(data[1]);
            sb.append(" = ");
            sb.append(Integer.parseInt(data[2]) * Integer.parseInt(data[1]));
            sb.append(" Ft\n");
        }
        return sb.toString();
    }
}
