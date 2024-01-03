public class NumberOfLaserBeamsInABank {
    public int numberOfBeams(String[] bank) {
        int totalBeams = 0;
        int r1Lasers = 0;
        int r2Lasers = 0;

        int idx1 = 0;
        int idx2 = 1;

        while (idx2 < bank.length) {
            String r1 = bank[idx1];
            while (!r1.contains("1") && idx1 < bank.length - 1)
                r1 = bank[++idx1];

            idx2 = idx1 + 1;
            if (idx2 == bank.length)
                break;

            String r2 = bank[idx2];
            while (!r2.contains("1") && idx2 < bank.length - 1)
                r2 = bank[++idx2];

            for (char ch : r1.toCharArray()) {
                if (ch == '1')
                    r1Lasers++;
            }

            for (char ch : r2.toCharArray()) {
                if (ch == '1')
                    r2Lasers++;
            }

            totalBeams = totalBeams + (r1Lasers * r2Lasers);
            r1Lasers = 0;
            r2Lasers = 0;

            idx1 = idx2;
            idx2++;
        }

        return totalBeams;
    }

    public int numberOfBeams2(String[] bank) {
        if (bank.length < 2) {
            return 0;
        }

        int totalBeams = 0;
        int lasersInPrevRow = 0;
        int lasersInCurrentRow = 0;

        for (String row : bank) {
            lasersInCurrentRow = 0;
            for (char ch : row.toCharArray()) {
                if (ch == '1') {
                    lasersInCurrentRow++;
                }
            }

            totalBeams += lasersInCurrentRow * lasersInPrevRow;
            lasersInPrevRow = lasersInCurrentRow != 0 ? lasersInCurrentRow : lasersInPrevRow;
        }

        return totalBeams;
    }
}
