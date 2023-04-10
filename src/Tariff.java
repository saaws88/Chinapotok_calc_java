public class Tariff {
    private long cost2Huzhou;
    private long crossBoarderByWeight = 350;
    private long crossBoarderbyVolume = 38000;

    Tariff(long cost2Huzhou) {
        this.cost2Huzhou = cost2Huzhou;
    }

    public long getCost2Huzhou() {
        return cost2Huzhou;
    }
    public long getTariffByWeight() {
        return crossBoarderByWeight;
    }
    public long getTariffByVolume (){
        return crossBoarderbyVolume;
    }
}

