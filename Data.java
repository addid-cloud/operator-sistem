class Data {
    int n = 100;
    int process[] = new int[n];
    int burstTime[] = new int[n];
    int arrivTime[] = new int[n];
    int[] ct = new int[n];
    int[] tat = new int[n];
    int[] wt = new int[n];
    int[] remainingTime = new int[n];
    double avgWt = 0;
    boolean[] done = new boolean[n];

    public Data() {
        for (int i = 0; i < n; i++) {
            process[i] = i + 1;
            arrivTime[i] = (int) (Math.random() * 51);
            burstTime[i] = 1 + (int) (Math.random() * 10);
            ct[i] = 0;
            tat[i] = 0;
            wt[i] = 0;
            done[i] = false;
            remainingTime[i] = burstTime[i];
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

}