package timingtest;

import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeSLList {
    private static void printTimingTable(AList<Integer> Ns, AList<Double> times, AList<Integer> opCounts) {
        System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
        System.out.printf("------------------------------------------------------------\n");
        for (int i = 0; i < Ns.size(); i += 1) {
            int N = Ns.get(i);
            double time = times.get(i);
            int opCount = opCounts.get(i);
            double timePerOp = time / opCount * 1e6;
            System.out.printf("%12d %12.2f %12d %12.2f\n", N, time, opCount, timePerOp);
        }
    }

    public static void main(String[] args) {
        timeGetLast();
    }

    public static void timeGetLast() {
        AList<Integer> Ns = new AList<Integer>();
        AList<Double> times = new AList<Double>();
        AList<Integer> opCounts = new AList<Integer>();
        for (int i = 0; i < 8; i++) {
            int N = (int) Math.pow(2, i) * 1000;
            Ns.addLast(N);
            SLList<Integer> example = new SLList<Integer>();
            for (int j = 0; j < N; j++) {
                example.addLast(0);
            }
            Stopwatch sw = new Stopwatch();
            for (int k = 0; k < 1000; k++) {
                example.getLast();
            }
            double timeInSeconds = sw.elapsedTime();
            opCounts.addLast(1000);
            times.addLast(timeInSeconds);
        }
        printTimingTable(Ns, times, opCounts);
    }
}
