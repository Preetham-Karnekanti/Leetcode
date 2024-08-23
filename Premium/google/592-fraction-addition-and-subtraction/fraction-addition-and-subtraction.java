class Solution {
    public String fractionAddition(String expression) {
        String numbers[] = splitIntoNumbers(expression);
        System.out.println(Arrays.toString(numbers));
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < numbers.length; i += 2) {
            int denom = Integer.parseInt(numbers[i + 1]);
            int num = Integer.parseInt(numbers[i]);
            hm.put(denom, hm.getOrDefault(denom, 0) + num);
        }
        ArrayList<Integer> denoms = new ArrayList<>(hm.keySet());
        int lcm = lcmOfArray(denoms);
        int numeratorSum = 0;
        for (int key : hm.keySet()) {
            int multiplier = lcm / key;
            numeratorSum += hm.get(key) * multiplier;
        }

        int gcd = findgcd(Math.abs(numeratorSum), lcm);
        int pos = Math.abs(numeratorSum);
        pos /= gcd;
        lcm /= gcd;
        return (numeratorSum < 0 ? "-" : "") + pos + "/" + lcm;
    }

    public static int lcmOfArray(ArrayList<Integer> arr) {
        int result = arr.get(0);
        for (int i = 1; i < arr.size(); i++) {
            result = lcm(result, arr.get(i));
        }
        return result;
    }

    public static int lcm(int a, int b) {
        return Math.abs(a * b) / findgcd(a, b);
    }

    public static int findgcd(int a, int b) {
        if (b == 0)
            return a;
        return findgcd(b, a % b);
    }

    public String[] splitIntoNumbers(String input) {
        List<String> result = new ArrayList<>();

        String[] parts = input.split("(?=[+-])");

        for (String part : parts) {
            if (part.contains("/")) {
                String[] subParts = part.split("/");
                result.add(subParts[0]); // Add the signed number
                result.add(subParts[1]); // Add the second part
            } else {
                result.add(part);
            }
        }
        return result.toArray(new String[0]);
    }
}