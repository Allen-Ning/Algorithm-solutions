public class Solution {
    public String nextClosestTime(String time) {
        Set<Integer> set = new HashSet();
        int[] target = new int[4];
        int index = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < time.length(); i++) {
            char c = time.charAt(i);
            if (c == ':') continue;
            target[index++] = c - '0';
            set.add(c - '0');
            min = Math.min(min, c - '0');
        }

        int[] result = new int[] { min, min, min, min };
        int targetMinutes = getHours(target) * 60 + getMinutes(target);
        helper(set, targetMinutes, new int[4], 0, result);
        return getResultString(result);
    }

    private void helper(Set<Integer> set, int targetMinutes, int[] current, int index, int[] result) {
        if (index == 4) {
            if (isValidResult(current)) setResult(targetMinutes, current, result);
            return;
        }

        for (int value : set) {
            current[index] += value;
            helper(set, targetMinutes, current, index + 1, result);
            current[index] -= value;
        } 
    }

    private void setResult(int targetMinutes, int[] current, int[] result) {
        int currentMinutes = getHours(current) * 60 + getMinutes(current);
        if (currentMinutes == targetMinutes) return;
        // trick -> change from hours and minutes to only minutes for easy comparison
        int resultMinutes = getHours(result) * 60 + getMinutes(result);

        // trick -> use + 24 * 60 to avoid get negative value
        //          e.g t1: target
        //              t2: next
        //              if t2 > t1, (t2 - t1 + 24 * 60) % (24 * 60) is same as from t1 clockwise rotate to t2 (t2 - t1)
        //              if t1 > t2, (t2 - t1 + 24 * 60) % (24 * 60) is same as from t1 clockwise rotate to t2
        int value = (currentMinutes - targetMinutes + 24 * 60) % (24 * 60);
        int value2 = (resultMinutes - targetMinutes + 24 * 60) % (24 * 60);

        if (value < value2) {
            result[0] = current[0];
            result[1] = current[1];
            result[2] = current[2];
            result[3] = current[3];
        }
    }
    
    private int getHours(int[] data) {
        return data[0] * 10 + data[1];
    }
    
    private int getMinutes(int[] data) {
        return data[2] * 10 + data[3];
    }
    
    private boolean isValidResult(int[] result) {
        int hours = getHours(result);
        int minutes = getMinutes(result);
        if (hours > 23) return false;
        if (minutes > 59) return false;
        return true;
    }

    private String getResultString(int[] result) {
        StringBuilder sb = new StringBuilder();
        sb.append(result[0]);
        sb.append(result[1]);
        sb.append(":");
        sb.append(result[2]);
        sb.append(result[3]);
        return sb.toString();
    }
}