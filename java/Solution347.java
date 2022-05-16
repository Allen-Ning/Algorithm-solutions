class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap();
        List<Integer> result = new ArrayList();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        PriorityQueue<Map.Entry<Integer, Integer>> q = new PriorityQueue<>((a, b) -> (a.getValue() - b.getValue())); 
        for (Map.Entry<Integer, Integer> record : map.entrySet()) {
            q.offer(record);
            if (q.size() > k) {
                q.poll();
            }
        }

        for (Map.Entry<Integer, Integer> value : q) result.add(value.getKey());
        return result;
    }
}

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap();
        for (int num : nums) map.put(num, map.getOrDefault(num, 0) + 1);

        Element[] elements = new Element[map.size()];
        int index = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) elements[index++] = new Element(entry.getKey(), entry.getValue());

        int freq = helper(elements, 0, elements.length - 1, k);

        List<Integer> results = new ArrayList();
        for (int i = 0; i < elements.length; i++) {
            if (elements[i].freq < freq) continue;

            results.add(elements[i].value);
        }

        int[] finalResults = new int[results.size()];
        for (int i = 0; i < results.size(); i++) finalResults[i] = results.get(i);
        return finalResults;
    }

    private int helper(Element[] elements, int start, int end, int k) {
        int i = start;
        int j = end;
        int p = i + (j - i) / 2;
        int t = start;
        int pivot = elements[p].freq;
        while (t <= j) {
            if (elements[t].freq < pivot) {
                swap(elements, t, i);
                i++;
                t++;
            } else if (elements[t].freq > pivot) {
                swap(elements, t, j);
                j--;
            } else {
                t++;
            }
        }

        if (end - j >= k) {
            return helper(elements, j + 1, end, k);
        } else if (end - i + 1 >= k) {
            return pivot;
        } else {
            return helper(elements, start, i - 1, k - (end - i + 1));
        }
    }

    private void swap(Element[] elements, int i, int j) {
        Element temp = elements[i];
        elements[i] = elements[j];
        elements[j] = temp;
    }

    class Element {
        int value;
        int freq;

        public Element(int value, int freq) {
            this.value = value;
            this.freq = freq;
        }
    }
}