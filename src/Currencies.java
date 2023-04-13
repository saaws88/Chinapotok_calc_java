public class Currencies {
    private long rateCNY;
    private long rateUSD;    

    Currencies(long rateCNY, long rateUSD){
        this.rateCNY = rateCNY;
        this.rateUSD = rateUSD;
    }

    public double getCNY() {
        return rateCNY / 100;
    }

    public double getUSD() {
        return rateUSD / 100;
    }

}