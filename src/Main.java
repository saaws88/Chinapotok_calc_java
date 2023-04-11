public class Main {
  public static void main (String[] args) {
    
    Parcel testParcel = new Parcel(2000000, 3.0, 0.12, "3");
    
    Tariff rates = new Tariff(3000);
    
    double costToHuzhou = rates.getCost2Huzhou() / 100;
    System.out.format("Доставка до Эми: %.2f CNY \n", costToHuzhou);
    
    double packagedWeight = testParcel.getWeight() + testParcel.countCartons();
    //System.out.println(packagedWeight);

   double density = packagedWeight / testParcel.getVolume();

    double inBoarderCost;
    if (packagedWeight * 2 >= testParcel.getVolume() * 2 * 200) {
      inBoarderCost = packagedWeight * 2;
    } else {
      inBoarderCost = testParcel.getVolume() * 2 * 200;
    }
    System.out.format("Доставка до Иу: %.2f CNY \n", inBoarderCost);

    double cartonsCost = Math.ceil(testParcel.countCartons() * 65);
    System.out.format("Стоимость коробок: %.2f CNY \n", cartonsCost);

    double insurance = testParcel.insuranceCost();
    System.out.format("Стоимость страховки: %.2f RUR\n", insurance);

    double crossboarderCost;
    double cratedWeight = 0;
    double cratedVolume = 0;    
    if (testParcel.getPackageType().equals("1")) {
      if (density <= 105) {
       crossboarderCost = testParcel.getVolume() * rates.getTariffByVolume() / 100;
      } else {
         crossboarderCost = packagedWeight * rates.getTariffByWeight() / 100;
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
      crossboarderCost = Math.max(cratedWeight, cratedVolume);
      System.out.format("Объем после обрешетки: %.2f \n", cratedVolume);
      System.out.format("Вес после обрешетки: %.2f \n", cratedWeight);
      System.out.format("Стоимость обрешетки: %.2f \n", crateCost);
    } 
      System.out.format("Стоимость доставки до РФ: %.2f USD \n", crossboarderCost);
  }
}


