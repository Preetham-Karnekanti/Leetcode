class Solution {
    public String[] sortPeople(String[] names, int[] height) {
        ArrayList<Person> al = new ArrayList<>();
        for (int i = 0; i < names.length; i++) {
            al.add(new Person(names[i], height[i]));
        }
        Collections.sort(al, (a, b) -> b.height - a.height);
        List<String> ans = al.stream().map(x -> x.name).toList();
        return ans.toArray(new String[ans.size()]);
    }
}

class Person {
    String name;
    int height;

    Person(String name, int height) {
        this.name = name;
        this.height = height;
    }
}