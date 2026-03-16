import java.util.*;

class TokenBucket {

    int tokens;
    long lastRefill;
    int maxTokens;
    int refillRate;

    TokenBucket(int maxTokens, int refillRate){
        this.tokens = maxTokens;
        this.maxTokens = maxTokens;
        this.refillRate = refillRate;
        this.lastRefill = System.currentTimeMillis();
    }

    synchronized boolean allowRequest(){

        long now = System.currentTimeMillis();
        long seconds = (now - lastRefill) / 1000;

        tokens = Math.min(maxTokens, tokens + (int)(seconds * refillRate));
        lastRefill = now;

        if(tokens > 0){
            tokens--;
            return true;
        }

        return false;
    }
}

public class RateLimiter {

    private Map<String, TokenBucket> clients = new HashMap<>();

    public boolean check(String clientId){

        clients.putIfAbsent(clientId,new TokenBucket(5,1));

        return clients.get(clientId).allowRequest();
    }

    public static void main(String[] args){

        RateLimiter limiter = new RateLimiter();

        System.out.println(limiter.check("client1"));
        System.out.println(limiter.check("client1"));
        System.out.println(limiter.check("client1"));
    }
}
