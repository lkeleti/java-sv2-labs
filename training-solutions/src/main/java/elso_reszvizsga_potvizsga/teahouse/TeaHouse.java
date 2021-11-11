package elso_reszvizsga_potvizsga.teahouse;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TeaHouse {
    private String name;
    private List<Tea> teas = new ArrayList<>(Arrays.asList(new Tea("Kamillavirágzat", 1256, Sort.HERBAL_TEA), new Tea("Cseresznyés álom", 1745, Sort.FRUIT_TEA)));
    private LocalTime openTime;
    private LocalTime closeTime;

    public TeaHouse(String name, LocalTime openTime, LocalTime closeTime) {
        this.name = name;
        this.openTime = openTime;
        this.closeTime = closeTime;
    }

    public String getName() {
        return name;
    }

    public List<Tea> getTeas() {
        return teas;
    }

    public LocalTime getOpenTime() {
        return openTime;
    }

    public LocalTime getCloseTime() {
        return closeTime;
    }

    public void addTea(Tea tea) {
        teas.add(tea);
    }

    public void setActionPrices(Sort sort, int percent) {
        for (Tea tea: teas) {
            if (tea.getSort().equals(sort)) {
                int newPrice = tea.getPrice();
                newPrice = (int)(newPrice * (100-percent)/100d);
                tea.setPrice(newPrice);
            }
        }
    }

    public double getAveragePrice() {
        double avgPrice = 0;

        for (Tea tea: teas) {
            avgPrice += tea.getPrice();
        }

        return avgPrice/teas.size();
    }
}
