public class FCFS {
    Data data;

    public FCFS(Data data) {
        this.data = data;
    }

    public void run() {
        data.sort();
        data.ct[0] = data.burstTime[0] + data.arrivTime[0];
        for (int i = 1; i < data.ct.length; i++) {
            if (data.arrivTime[i] < data.ct[i - 1]) {
                data.ct[i] = data.burstTime[i] + data.ct[i - 1];
            } else {
                data.ct[i] = data.arrivTime[i] + data.burstTime[i];
            }
            data.done[i] = true;
        }
        for (int i = 0; i < data.wt.length; i++) {
            data.tat[i] = data.ct[i] - data.arrivTime[i];
            data.wt[i] = data.ct[i] - data.burstTime[i] - data.arrivTime[i];
        }
        double totWt = 0;
        for (int i = 0; i < data.n; i++) {
            totWt += data.wt[i];
        }
        data.avgWt = totWt / data.n;
        // data.printData();
    }
}