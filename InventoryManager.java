import java.util.*;

public class InventoryManager {

    private HashMap<String,Integer> stock = new HashMap<>();
    private HashMap<String,Queue<Integer>> waiting = new HashMap<>();

    public void addProduct(String id, int quantity){
        stock.put(id,quantity);
        waiting.put(id,new LinkedList<>());
    }

    public synchronized String purchase(String id,int userId){

        int remaining = stock.getOrDefault(id,0);

        if(remaining > 0){

            stock.put(id,remaining-1);
            return "Success: remaining " + (remaining-1);

        } else {

            waiting.get(id).add(userId);
            return "Added to waiting list";

        }

    }

    public int checkStock(String id){
        return stock.getOrDefault(id,0);
    }

    public static void main(String[] args){

        InventoryManager system = new InventoryManager();

        system.addProduct("IPHONE15",5);

        System.out.println(system.purchase("IPHONE15",1));
        System.out.println(system.purchase("IPHONE15",2));

        System.out.println("Stock: " + system.checkStock("IPHONE15"));
    }
}
