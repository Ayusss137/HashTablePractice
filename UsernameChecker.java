import java.util.*;

public class UsernameChecker {

    private HashMap<String, Integer> users = new HashMap<>();
    private HashMap<String, Integer> attempts = new HashMap<>();

    public boolean checkAvailability(String username) {

        attempts.put(username, attempts.getOrDefault(username, 0) + 1);

        return !users.containsKey(username);
    }

    public List<String> suggestAlternatives(String username) {

        List<String> suggestions = new ArrayList<>();

        for(int i = 1; i <= 3; i++){
            suggestions.add(username + i);
        }

        suggestions.add(username.replace("_","."));

        return suggestions;
    }

    public void registerUser(String username, int id){
        users.put(username, id);
    }

    public String getMostAttempted(){

        String popular = "";
        int max = 0;

        for(Map.Entry<String,Integer> e : attempts.entrySet()){

            if(e.getValue() > max){
                max = e.getValue();
                popular = e.getKey();
            }

        }

        return popular;
    }

    public static void main(String[] args){

        UsernameChecker system = new UsernameChecker();

        system.registerUser("john_doe",1);

        System.out.println(system.checkAvailability("john_doe"));
        System.out.println(system.checkAvailability("jane_smith"));

        System.out.println(system.suggestAlternatives("john_doe"));
    }
}
