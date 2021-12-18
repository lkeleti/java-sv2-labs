package masodik_reszvizsga_potvizsga.filemanipulation;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ProductFileManager {
    List<Product> products = new ArrayList<>();

    public List<Product> getProducts() {
        return products;
    }

    public void readProductsFromFile(Path path) {
        List<String> lines = readfromFile(path);
        readFromLines(lines);
    }

    private void readFromLines(List<String> lines) {
        for (String line : lines) {
            String[] datas = line.split(";");
            products.add(new Product(datas[0], datas[1], Integer.parseInt(datas[2])));
        }
    }

    private List<String> readfromFile(Path path) {
        List<String> lines;
        try {
            lines = Files.readAllLines(path);
            return lines;
        } catch (IOException ioe) {
            throw new IllegalStateException("Can't read file!", ioe);
        }
    }

    public void writePriceOverToFile(Path path, int price) {
        List<String> lines = findProductToLines(price);
        try {
            Files.write(path,lines);
        }
        catch (IOException ioe) {
            throw  new IllegalStateException("Can't write file!", ioe);
        }
    }

    private List<String> findProductToLines(int price) {
        List<String> lines = new ArrayList<>();
        for (Product product: products) {
            if (product.getPrice() > price) {
                StringBuilder sb = new StringBuilder();
                sb.append(product.getId());
                sb.append(";");
                sb.append(product.getName());
                sb.append(";");
                sb.append(product.getPrice());
                lines.add(sb.toString());
            }
        }
        return lines;
    }
}
