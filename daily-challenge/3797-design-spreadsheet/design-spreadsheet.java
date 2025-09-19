class Spreadsheet {
    int sheet[][];

    public Spreadsheet(int rows) {
        sheet = new int[rows + 1][26];
    }

    public void setCell(String cell, int value) {
        int col = cell.charAt(0) - 'A';
        int row = Integer.parseInt(cell.substring(1));
        sheet[row][col] = value;
    }

    public void resetCell(String cell) {
        int col = cell.charAt(0) - 'A';
        int row = Integer.parseInt(cell.substring(1));
        sheet[row][col] = 0;
    }

    public int getValue(String formula) {
        formula = formula.substring(1);
        String[] values = formula.split("\\+");
        int v1 = getCellValue(values[0]);
        int v2 = getCellValue(values[1]);
        return v1 + v2;
    }

    private int getCellValue(String s) {
        if (s.charAt(0) >= 'A' && s.charAt(0) <= 'Z') {
            int col = s.charAt(0) - 'A';
            int row = Integer.parseInt(s.substring(1));
            return sheet[row][col];
        }
        return Integer.parseInt(s);
    }
}

/**
 * Your Spreadsheet object will be instantiated and called as such:
 * Spreadsheet obj = new Spreadsheet(rows);
 * obj.setCell(cell,value);
 * obj.resetCell(cell);
 * int param_3 = obj.getValue(formula);
 */