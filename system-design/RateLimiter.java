import java.util.HashMap;
import java.util.Queue;

class RateLimiter implements Runnable {

    private LeakyBucket lb;

    public RateLimiter() {
        this.lb = new LeakyBucket(0, 5, 2);
    }

    public static void main(String[] args) {
        RateLimiter limiter = new RateLimiter();
        for (int i = 0; i < 10; i++) {
            if (i == 5) {
                try {
                    Thread.sleep(1000);
                    System.out.println("++++++++");
                } catch (InterruptedException e) {
                    System.out.println("error");
                }

            }
            Thread t1 = new Thread(limiter); // Using the constructor Thread(Runnable r)
            t1.start();

        }
    }

    public void run() {
        System.out.println(lb.call(1));
    }

}

// https://segmentfault.com/a/1190000016212726
class LeakyBucket {
    private long capacity;
    private int maxCapacity;
    private long droppingRate; // 100 leak / millisionseocnds
    private long lastCheckTimestamp;

    public LeakyBucket(int used, int maxCapacity, int droppingRate) {
        this.capacity = used;
        this.maxCapacity = maxCapacity;
        this.droppingRate = droppingRate;
        this.lastCheckTimestamp = System.currentTimeMillis();
    }

    public synchronized boolean call(int drop) {
        leak();

        // first difference between LeakyBucket and TokenBucket
        if (this.capacity + drop > this.maxCapacity)
            return false;
        this.capacity += drop;
        return true;
    }

    private void leak() {
        long now = System.currentTimeMillis();
        long timePassedInSecond = (now - this.lastCheckTimestamp) / 1000;
        this.lastCheckTimestamp = now;

        long drop = timePassedInSecond * droppingRate;
        // second difference between LeakyBucket and TokenBucket
        this.capacity = Math.max(0, capacity - drop);
    }

    public void run() {
        System.out.println("thread is running...");
    }
}

class TokenBucket {
    private long capacity;
    private int maxCapacity;
    private long refillRate; // 100 token / millisionseocnds
    private long lastCheckTimestamp;

    public TokenBucket(int capactiy, int maxCapacity, int refillRate) {
        this.capacity = capactiy;
        this.maxCapacity = maxCapacity;
        this.refillRate = refillRate;
        this.lastCheckTimestamp = System.currentTimeMillis();
    }

    public synchronized boolean call(int pick) {
        refill();

        // first difference between LeakyBucket and TokenBucket
        if (this.capacity < pick)
            return false;
        this.capacity -= pick;
        return true;
    }

    private void refill() {
        long now = System.currentTimeMillis();
        long timePassedInSecond = (now - this.lastCheckTimestamp) / 1000;
        this.lastCheckTimestamp = now;

        long added = timePassedInSecond * refillRate;

        // second difference between LeakyBucket and TokenBucket
        this.capacity = Math.min(this.maxCapacity, capacity + added);
    }
}

// sliding window without weight
class SlidingWindow {
    private int maxCapacity;
    private long windowInSeconds;
    private Queue<Long> queue;

    public SlidingWindow(int maxCapacity, int windowInSeconds) {
        this.maxCapacity = maxCapacity;
        this.windowInSeconds = windowInSeconds;
    }

    public synchronized boolean call(int pick) {
        long now = System.currentTimeMillis();
        clean(now);

        if (this.queue.size() > maxCapacity)
            return false;
        queue.offer(now);
        return true;
    }

    private void clean(long now) {
        while (queue.size() > 0 &&
                queue.peek() < now - this.windowInSeconds * 1000) {
            queue.poll();
        }
    }
}

// sliding window with weight
class SlidingWindow2 {
    private HashMap<Long, Long> counter = new HashMap<>();
    private int maxCapacity;

    public SlidingWindow2(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public synchronized boolean call(int pick) {
        long now = System.currentTimeMillis();
        long nowInSecond = now / 1000;
        long nowMillsecond = now % 1000;

        long prevSecond = nowInSecond - 1;
        Long prevCounter = counter.get(prevSecond);
        Long currentCounter = counter.getOrDefault(nowInSecond, (long) 0) + pick;

        // no prevCounter
        if (prevCounter == null) {
            if (currentCounter > this.maxCapacity)
                return false;

            counter.put(nowInSecond, currentCounter);
            return true;
        }

        double percentage = (1 - nowMillsecond) / 1000;
        double value = prevCounter * percentage + currentCounter;

        if (value > this.maxCapacity)
            return false;

        counter.put(nowInSecond, currentCounter);
        return true;
    }
}
