public class Main {
  public static void main (String[] args) {
    
    Parcel testParcel = new Parcel(2000000, 8.3, 0.12, "1");
    Tariff testTariff = new Tariff(2000);
    Currencies testCurrencies = new Currencies(1186, 8153);
    Customer testIvan = new Customer(5);

    double printCost2Huzhou = testTariff.getCost2Huzhou()/100;
    System.out.format("Доставка до Хучжоу: %.2f CNY \n", printCost2Huzhou);

    int cartons = (int)Math.ceil(testParcel.countCartons());
    double cartonsCost = cartons * 65;
    System.out.format("Стоимость коробок: %.2f CNY \n", cartonsCost);    

    double packagedWeight = testParcel.getWeight() + cartons;

    double inboarderCost = Math.max(packagedWeight * 2, testParcel.getVolume() * 2 * 200);
    System.out.format("Доставка до Иу: %.2f CNY \n", inboarderCost);

    System.out.format("Стоимость страховки: %.2f RUR \n", testParcel.insuranceCost());

    double crossboarderCost = 0;
    double cratedWeight = 0;
    double cratedVolume = 0;

    if (testParcel.getPackageType().equals("1")) {
      if (packagedWeight/testParcel.getVolume() <= 105) {
       crossboarderCost = testParcel.getVolume() * testTariff.getTariffByVolume() / 100;
      } else {
         crossboarderCost = packagedWeight * testTariff.getTariffByWeight() / 100;
      }
    }
    else {
      if(testParcel.getPackageType().equals("2")) {
        cratedWeight = packagedWeight * 1.25;
        cratedVolume = testParcel.getVolume() * 1.25;
      } else if (testParcel.getPackageType().equals("3")) {
        cratedWeight = packagedWeight * 1.7;
        cratedVolume = testParcel.getVolume() * 1.4;
      }
      double crateCost = cratedVolume * 45;
      crossboarderCost = Math.max(cratedWeight * testTariff.getTariffByWeight(), cratedVolume * testTariff.getTariffByVolume());
      System.out.format("Объем после обрешетки: %.2f \n", cratedVolume);
      System.out.format("Вес после обрешетки: %.2f \n", cratedWeight);
      System.out.format("Стоимость обрешетки: %.2f \n", crateCost);
    } 
      System.out.format("Стоимость доставки до РФ: %.2f USD \n", crossboarderCost);

      double total = (((cartonsCost + inboarderCost + testTariff.getCost2Huzhou()/100)*testCurrencies.getCNY()/100) + 
      (crossboarderCost * testCurrencies.getUSD()/100) +
      testParcel.insuranceCost()) * testIvan.customerMargin();
      System.out.format("Итого: %.2f RUR, ", total);
      System.out.format("%.2f USD", (total/(testCurrencies.getUSD()/100)));
  }
}


