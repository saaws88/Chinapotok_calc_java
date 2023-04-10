public class Main {
    public static void main (String[] args) {
        Parcel testParcel = new Parcel(2000000, 3.0, 0.12, "box");
        Tariff rates = new Tariff(3000);
        double packagedWeight = testParcel.getWeight() + testParcel.countCartons(testParcel.getWeight(), testParcel.getVolume());
        double density = packagedWeight / testParcel.getVolume();
        //if (density <= 105) {
    System.out.println(rates.getTariffByVolume() + ", " + rates.getTariffByWeight());
  }
}

