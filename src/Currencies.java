public class Currencies {
    private int rateCNY;
    private int rateUSD;

    Currencies(int rateCNY, int rateUSD){
        this.rateCNY = rateCNY;
        this.rateUSD = rateUSD;
    }

    public int getCNY() {
        return rateCNY;
    }

    public int getUSD() {
        return rateUSD;
    }
}