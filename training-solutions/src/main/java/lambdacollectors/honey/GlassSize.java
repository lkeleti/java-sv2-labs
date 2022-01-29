package lambdacollectors.honey;

public enum GlassSize {
    BIG(1.0), SMALL(0.5), TASTER_SIZE(0.05);

    private double kilogramCanFitIn;

    GlassSize(double kilogramCanFitIn) {
        this.kilogramCanFitIn = kilogramCanFitIn;
    }

    public double getKilogramCanFitIn() {
        return kilogramCanFitIn;
    }
}
