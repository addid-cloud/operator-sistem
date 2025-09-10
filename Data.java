class Data {
    int n = 100;
    int process[] = new int[n];
    int burstTime[] = new int[n];
    int burstTimesec[] = new int[n];
    int arrivTime[] = new int[n];
    int arrivTimesec[] = new int[n];
    int[] ct = new int[n];
    int[] ctsec = new int[n];
    int[] tat = new int[n];
    int[] tatsec = new int[n];
    int[] wt = new int[n];
    int[] wtsec = new int[n];
    int[] remainingTime = new int[n];
    int[] remainingTimesec = new int[n];
    double avgWt = 0;
    double avgWtsec = 0;
    boolean[] done = new boolean[n];
    boolean[] donesec = new boolean[n];

    public Data() {
        for (int i = 0; i < n; i++) {
            process[i] = i + 1;
            arrivTime[i] = (int) (Math.random() * 51);
            arrivTimesec[i] = arrivTime[i];
            burstTime[i] = 1 + (int) (Math.random() * 10);
            burstTimesec[i] = burstTime[i];
            ct[i] = 0;
            ctsec[i] = ct[i];
            tat[i] = 0;
            tatsec[i] = tat[i];
            wt[i] = 0;
            wtsec[i] = wt[i];
            done[i] = false;
            donesec[i] = done[i];
            remainingTime[i] = burstTime[i];
            remainingTimesec[i] = remainingTime[i];
        }
    }

    public Data(int ar) {
        for (int i = 0; i < n; i++) {
            process[i] = i + 1;
            arrivTime[i] = ar;
            burstTime[i] = 1 + (int) (Math.random() * 10);
            ct[i] = 0;
            tat[i] = 0;
            wt[i] = 0;
        }
    }

    public void printData() {
        System.out.println("=======================================================================");
        System.out.println("Data\t|Process|\t|AT|\t|BT|\t|CT|\t|WT|");
        System.out.println("=======================================================================");
        for (int i = 0; i < process.length; i++) {
            System.out.print("\t| p-" + process[i] + "\t\t " + arrivTime[i] + "\t " + burstTime[i] + "\t " + ct[i]
                    + "\t " + wt[i] + "\t |");
            System.out.println();
        }
        System.out.println("=======================================================================");
        System.out.println("rata rata wt = " + avgWt);
    }

    public void sort() {
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arrivTime[j] > arrivTime[j + 1]) {
                    // Tukar arrival time
                    int temp = arrivTime[j];
                    arrivTime[j] = arrivTime[j + 1];
                    arrivTime[j + 1] = temp;

                    // Tukar burst time biar tetap sesuai
                    temp = burstTime[j];
                    burstTime[j] = burstTime[j + 1];
                    burstTime[j + 1] = temp;

                    // Tukar process id juga
                    temp = process[j];
                    process[j] = process[j + 1];
                    process[j + 1] = temp;
                }
            }
        }
    }

    public void reset() {
        for (int i = 0; i < n; i++) {
            arrivTime[i] = arrivTimesec[i];
            burstTime[i] = burstTimesec[i];
            ct[i] = 0;
            tat[i] = 0;
            wt[i] = 0;
            remainingTime[i] = burstTimesec[i];
            done[i] = false;
        }
        avgWt = 0;
    }

}