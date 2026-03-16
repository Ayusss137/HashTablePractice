import java.util.*;

public class ParkingLotHashing {

    String[] spots;
    int capacity;

    public ParkingLotHashing(int capacity){
        this.capacity = capacity;
        spots = new String[capacity];
    }

    int hash(String plate){
        return Math.abs(plate.hashCode()) % capacity;
    }

    public void park(String plate){

        int index = hash(plate);

        while(spots[index] != null){
            index = (index + 1) % capacity;
        }

        spots[index] = plate;

        System.out.println(plate + " parked at " + index);
    }

    public static void main(String[] args){

        ParkingLotHashing lot = new ParkingLotHashing(10);

        lot.park("ABC123");
        lot.park("XYZ999");
    }
}
