class Logger {

    HashMap<String, Integer> limiter;

    public Logger() {
        this.limiter = new HashMap();
    }

    public boolean shouldPrintMessage(int timestamp, String message) {
        if (timestamp < limiter.getOrDefault(message, -1))
            return false;

        limiter.put(message, timestamp + 10);
        return true;
    }
}


/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */