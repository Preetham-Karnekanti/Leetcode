/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    Map<Integer, Employee> map;

    int importance(int id) {
        Employee employee = map.get(id);
        int imp = employee.importance;
        for (int i : employee.subordinates) {
            imp += importance(i);
        }
        return imp;
    }

    public int getImportance(List<Employee> employees, int id) {
        map = new HashMap<>();
        for (Employee e : employees) {
            map.put(e.id, e);
        }
        return importance(id);
    }
}