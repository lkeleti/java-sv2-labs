package inheritancemethods.product;

import java.math.BigDecimal;

public class PackedProduct extends Product{
    private int packingUnit;
    private BigDecimal weightOfBox;

    public PackedProduct(String name, BigDecimal unitWeight, int numberOfDecimals, int packingUnit, BigDecimal weightOfBox) {
        super(name, unitWeight, numberOfDecimals);
        this.packingUnit = packingUnit;
        this.weightOfBox = weightOfBox;
    }

    public PackedProduct(String name, BigDecimal unitWeight, int packingUnit, BigDecimal weightOfBox) {
        super(name, unitWeight);
        this.packingUnit = packingUnit;
        this.weightOfBox = weightOfBox;
    }

    public int getPackingUnit() {
        return packingUnit;
    }

    public BigDecimal getWeightOfBox() {
        return weightOfBox;
    }

    @Override
    public BigDecimal totalWeight(int pieces) {
        int numberOfFullBoxes = pieces / packingUnit;
        int piecesInLastBox = pieces - (packingUnit * numberOfFullBoxes);
        BigDecimal weightOfFullBoxes = super.totalWeight(packingUnit).multiply(BigDecimal.valueOf(numberOfFullBoxes));
        weightOfFullBoxes = weightOfFullBoxes.add(weightOfBox.multiply(BigDecimal.valueOf(numberOfFullBoxes)));
        BigDecimal weightOfLastBox = super.totalWeight(piecesInLastBox);
        weightOfLastBox = weightOfLastBox.add(weightOfBox);
        return (weightOfFullBoxes.add(weightOfLastBox)).setScale(getNumberOfDecimals());
    }
}
