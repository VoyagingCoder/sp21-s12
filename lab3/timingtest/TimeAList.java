package timingtest;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeAList {
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
;
    public static void main(String[] args) {
        timeAListConstruction();
    }

    public static void timeAListConstruction() {
        // TODO: YOUR CODE HERE
        // AList构造过程已经被优化
        AList<Integer> TestList = new AList<Integer>();

        // 确定列表的长度
        int[] NsTmp = {0,1000,2000,4000,8000,16000,32000,64000,128000};
        AList<Integer> Ns = new AList<>();
        for(int i=1; i < NsTmp.length; i++) Ns.addLast(NsTmp[i]);//把开头的0去掉

        //计算得到所需的时长
        Stopwatch timer = new Stopwatch();
        AList<Double> UsedTime = new AList<Double>();
        for(int i=0; i < NsTmp.length-1; i++){
            for(int j=NsTmp[i]+1; j <= NsTmp[i+1]; j++) TestList.addLast(0);
            UsedTime.addLast(timer.elapsedTime());
        }

        //打印输出结果
        printTimingTable(Ns,UsedTime,Ns);
    }
}
