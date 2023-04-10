public class Parcel {
        private long orderCost; //RUR
        private double weight;
        private double volume;
        private String packageType;

        Parcel(long orderCost, double weight, double volume, String packageType) {
            this.orderCost = orderCost;
            this.weight = weight;
            this.volume = volume;
            this.packageType = packageType;
        }
        
        public double countCartons(double weight, double volume) {
            double cartons;
            double cartonMaxWeight = 3.5;
            double cartonMaxVolume = 0.11;
            if (weight/cartonMaxWeight >= volume/cartonMaxVolume) {
                cartons = Math.ceil(weight/cartonMaxWeight);
                return cartons;
            } else {
                cartons = Math.ceil(volume/cartonMaxVolume);
                return cartons;
            }  
        }

        public double getWeight() {
            return weight;
        }

        public double getVolume() {
            return volume;
        }
}