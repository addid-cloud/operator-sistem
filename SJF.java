public class SJF {
    Data data;

    public SJF(Data data) {
        this.data = data;
    }

    public void run() {
        int totAt = 0;
        for (int i = 0; i < data.arrivTime.length; i++) {
            totAt += data.arrivTime[i];
        }
        if (totAt == 0) {
            for (int i = 1; i < data.burstTime.length; i++) {
                for (int j = 0; j < data.burstTime.length - i; j++) {
                    if (data.burstTime[j] > data.burstTime[j + 1]) {
                        int temp = data.burstTime[j];
                        data.burstTime[j] = data.burstTime[j + 1];
                        data.burstTime[j + 1] = temp;

                        temp = data.process[j];
                        data.process[j] = data.process[j + 1];
                        data.process[j + 1] = temp;
                    }
                }
            }
            data.ct[0] = data.burstTime[0] + data.arrivTime[0];
            for (int i = 1; i < data.ct.length; i++) {
                if (data.arrivTime[i] < data.ct[i - 1]) {
                    data.ct[i] = data.burstTime[i] + data.ct[i - 1];
                } else {
                    data.ct[i] = data.arrivTime[i] + data.burstTime[i];
                }
            }
            for (int i = 0; i < data.wt.length; i++) {
                data.wt[i] = data.ct[i] - data.burstTime[i] - data.arrivTime[i];
            }
        } else {
            data.sort();
            int n = data.arrivTime.length;
            int currentTime = 0, completed = 0;

            while (completed < n) {
                int idx = -1;

                for (int i = 0; i < n; i++) {
                    if (data.arrivTime[i] <= currentTime && data.remainingTime[i] > 0) {
                        if (idx == -1 || data.remainingTime[i] < data.remainingTime[idx]) {
                            idx = i;
                        }
                    }
                }

                if (idx != -1) {
                    data.remainingTime[idx]--;
                    currentTime++;
                    if (data.remainingTime[idx] == 0) {
                        data.ct[idx] = currentTime;
                        data.tat[idx] = data.ct[idx] - data.arrivTime[idx];
                        if (data.tat[idx] - data.burstTime[idx] > 0) {
                            data.wt[idx] = data.tat[idx] - data.burstTime[idx];
                        } else {
                            data.wt[idx] = 0;
                        }
                        completed++;
                    }
                } else {
                    currentTime++;
                }
            }
        }
        double totWt = 0;
        for (int i = 0; i < data.n; i++) {
            totWt += data.wt[i];
        }
        data.avgWt = totWt / data.n;
        // data.printData();
    }
}
