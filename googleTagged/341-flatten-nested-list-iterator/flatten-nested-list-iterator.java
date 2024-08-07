/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 * // @return true if this NestedInteger holds a single integer, rather than a
 * nested list.
 * public boolean isInteger();
 *
 * // @return the single integer that this NestedInteger holds, if it holds a
 * single integer
 * // Return null if this NestedInteger holds a nested list
 * public Integer getInteger();
 *
 * // @return the nested list that this NestedInteger holds, if it holds a
 * nested list
 * // Return empty list if this NestedInteger holds a single integer
 * public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {
    List<Integer> flattenedList;
    int i;

    public NestedIterator(List<NestedInteger> nestedList) {
        flattenedList = new ArrayList<>();
        i = 0;
        flatten(nestedList);
    }

    public void flatten(List<NestedInteger> nestedList) {
        for (NestedInteger each : nestedList) {
            if (each.isInteger())
                flattenedList.add(each.getInteger());
            else {
                flatten(each.getList());
            }
        }
    }

    @Override
    public Integer next() {
        return flattenedList.get(i++);
    }

    @Override
    public boolean hasNext() {
        return i < flattenedList.size();
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */