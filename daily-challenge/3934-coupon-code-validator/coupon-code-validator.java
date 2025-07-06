class Solution {
    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        List<Coupon> activeCoupons = new ArrayList<>();
        for (int i = 0; i < code.length; i++) {
            if (isActive[i] && isValidCode(code[i]) && isValidBusinessLine(businessLine[i]))
                activeCoupons.add(new Coupon(code[i], businessLine[i]));
        }

        Collections.sort(activeCoupons, (a, b) -> {
            if (a.businessLine.equals(b.businessLine))
                return a.code.compareTo(b.code);
            return a.businessLine.compareTo(b.businessLine);
        });
        List<String> activeCodes = new ArrayList<>();
        for (Coupon c : activeCoupons) {
            activeCodes.add(c.code);
        }
        return activeCodes;
    }

    public boolean isValidCode(String code) {
        if (code.isEmpty())
            return false;
        for (int i = 0; i < code.length(); i++) {
            char ch = code.charAt(i);
            if (ch >= 'a' && ch <= 'z')
                continue;
            else if (ch >= 'A' && ch <= 'Z')
                continue;
            else if (ch >= '0' && ch <= '9')
                continue;
            else if (ch == '_')
                continue;
            return false;
        }
        return true;
    }

    public boolean isValidBusinessLine(String businessLine) {
        Set<String> immutableSet = Set.of("electronics", "grocery", "pharmacy", "restaurant");
        return immutableSet.contains(businessLine);
    }
}

class Coupon {
    String code;
    String businessLine;

    Coupon(String code, String businessLine) {
        this.code = code;
        this.businessLine = businessLine;
    }
}