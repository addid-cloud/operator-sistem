public class RR {
    Data data;
    int quantum;

    public RR(Data data, int quantum) {
        this.data = data;
        this.quantum = quantum;
    }

    public void run() {
        int n = data.arrivTime.length;
        int completed = 0;
        int currentTime = 0;

        while (completed < n) {
            boolean executed = false;
            for (int i = 0; i < n; i++) {
                if (data.remainingTime[i] > 0 && data.arrivTime[i] <= currentTime) {
                    executed = true;
                    int execTime = Math.min(quantum, data.remainingTime[i]);
                    data.remainingTime[i] -= execTime;
                    currentTime += execTime;

                    if (data.remainingTime[i] == 0) {
                        data.ct[i] = currentTime;
                        data.tat[i] = data.ct[i] - data.arrivTime[i];
                        data.wt[i] = data.ct[i] - data.arrivTime[i] - data.burstTime[i];
                        completed++;
                    }
                }
            }

            if (!executed) {
                currentTime++;
            }
        }

        data.printData();
    }
}
