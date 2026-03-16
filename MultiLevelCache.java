import java.util.*;

public class MultiLevelCache {

    Map<String,String> L1 = new HashMap<>();
    Map<String,String> L2 = new HashMap<>();

    public String getVideo(String id){

        if(L1.containsKey(id)){
            return "L1 HIT";
        }

        if(L2.containsKey(id)){
            L1.put(id,L2.get(id));
            return "L2 HIT -> promoted";
        }

        String data = "VideoData";

        L2.put(id,data);

        return "Database HIT";
    }

    public static void main(String[] args){

        MultiLevelCache cache = new MultiLevelCache();

        System.out.println(cache.getVideo("video1"));
        System.out.println(cache.getVideo("video1"));
    }
}
