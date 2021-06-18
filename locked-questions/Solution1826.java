class Solution {
    public int badSensor(int[] sensor1, int[] sensor2) {
        boolean result1 = hasDefect(sensor1, sensor2);
        boolean result2 = hasDefect(sensor2, sensor1);

        if (result1 && result2) {
            return -1;
        } else if (result1) {
            return 2;
        } else if (result2) {
            return 1;
        } else {
            return -1;
        }
    }

    private boolean hasDefect(int[] goodSensor, int[] checkedSensor) {
        int i = 0;
        while (i < goodSensor.length) {
            if (goodSensor[i] != checkedSensor[i]) break;
            i++;
        }

        if (i >= goodSensor.length - 1) return true;

        int droppedValue = goodSensor[i];
        i++;

        while (i < goodSensor.length) {
            if (goodSensor[i] != checkedSensor[i - 1]) return false;
            i++;
        }

        return checkedSensor[checkedSensor.length - 1] != droppedValue;
    }
}