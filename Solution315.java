class Solution {
  class Element {
    int index;
    int value;
    int counter;

    public Element(int index, int value, int counter) {
      this.index = index;
      this.value = value;
      this.counter = counter;
    }
  }

  public List<Integer> countSmaller(int[] nums) {
    Element[] elements = new Element[nums.length];
    for (int i = 0; i < nums.length; i++) elements[i] = new Element(i, nums[i], 0);

    mergeSort(elements, 0, nums.length - 1);

    int[] results = new int[nums.length];
    for (int i = 0; i < elements.length; i++) results[elements[i].index] = elements[i].counter;

    List<Integer> finalResults = new ArrayList();
    for (int i = 0; i < results.length; i++) {
      finalResults.add(results[i]);
    }
    return finalResults;
  }

  private void mergeSort(Element[] nums, int l, int r) {
    // trick -> don't forget this check for recursive
    if (l >= r) return;

    int mid = l + (r - l) / 2;

    mergeSort(nums, l, mid);
    mergeSort(nums, mid + 1, r);
    merge(nums, l, mid, r);
  }

  private void merge(Element[] nums, int l, int mid, int r) {
    Element[] values = new Element[r - l + 1];

    int p1 = l;
    int p2 = mid + 1;
    int index = 0;
    while (p1 <= mid && p2 <= r) {
      // trick -> be careful when nums[p1].value == nums[p2].value
      //          we need to put p1 in first to get the right counting
      // trick -> we also need to remember to add counter when nums[p1].value <= nums[p2].value
      //          rather than adding one for each time
      if (nums[p1].value <= nums[p2].value) nums[p1].counter += p2 - mid -1;
      values[index++] = nums[p1].value <= nums[p2].value ? nums[p1++] : nums[p2++];
    }

    while (p1 <= mid) {
      nums[p1].counter += r - mid;
      values[index++] = nums[p1++];
    }

    while (p2 <= r) values[index++] = nums[p2++];

    for (int i = l; i <= r; i++) nums[i] = values[i - l];
  }
}
