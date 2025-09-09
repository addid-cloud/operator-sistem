public class Main {
    public static void main(String[] args) {
        Data datas = new Data();
        // datas.printData();

        FCFS fcfs = new FCFS(datas);
        fcfs.run();
        // SJF sjf = new SJF(datas);
        // sjf.run();
        // datas.printData();
        // RR rr = new RR(datas, 10);
        // rr.run();
    }
}
