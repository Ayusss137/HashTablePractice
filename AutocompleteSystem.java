import java.util.*;

public class AutocompleteSystem {

    private Map<String,Integer> queries = new HashMap<>();

    public void addQuery(String query){
        queries.put(query, queries.getOrDefault(query,0)+1);
    }

    public List<String> search(String prefix){

        List<String> results = new ArrayList<>();

        for(String q : queries.keySet()){
            if(q.startsWith(prefix)){
                results.add(q);
            }
        }

        results.sort((a,b)->queries.get(b)-queries.get(a));

        return results.size()>5 ? results.subList(0,5) : results;
    }

    public static void main(String[] args){

        AutocompleteSystem system = new AutocompleteSystem();

        system.addQuery("java tutorial");
        system.addQuery("java tutorial");
        system.addQuery("javascript course");

        System.out.println(system.search("jav"));
    }
}
