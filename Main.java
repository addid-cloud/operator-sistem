public class Main {
    public static void main(String[] args) {
        Data datas[] = new Data[100];
        FCFS fcfs[] = new FCFS[100];
        SJF sjf[] = new SJF[100];
        RR rr[] = new RR[100];
        double totAvgFCFS = 0;
        double totAvgRR = 0;
        double totAvgSJF = 0;

        for (int i = 0; i < datas.length; i++) {
            datas[i] = new Data();
            fcfs[i] = new FCFS(datas[i]);
            fcfs[i].run();
            totAvgFCFS += datas[i].avgWt;
        }
        totAvgFCFS /= datas.length;
        System.out.println("avg FCFS = " + totAvgFCFS);

        for (int i = 0; i < datas.length; i++) {
            datas[i].reset();
            sjf[i] = new SJF(datas[i]);
            sjf[i].run();
            totAvgSJF += datas[i].avgWt;
        }
        totAvgSJF /= datas.length;
        System.out.println("avg SJF = " + totAvgSJF);

        for (int i = 0; i < datas.length; i++) {
            datas[i].reset();
            rr[i] = new RR(datas[i], 2);
            rr[i].run();
            totAvgRR += datas[i].avgWt;
        }
        totAvgRR /= datas.length;
        System.out.println("avg RR = " + totAvgRR);
    }
}
