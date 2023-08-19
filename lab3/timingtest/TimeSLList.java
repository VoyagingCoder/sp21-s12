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
        // TODO: YOUR CODE HERE
        SLList<Integer> TestList = new SLList<Integer>();

        // 确定列表的长度
        int[] NsTmp = {0,1000,2000,4000,8000,16000,32000,64000,128000};
        AList<Integer> Ns = new AList<>();
        for(int i=1; i < NsTmp.length; i++) Ns.addLast(NsTmp[i]);//把开头的0去掉

        // 确定对于每个列表getlast的次数
        AList<Integer> opCounts = new AList<>();
        for(int i=1; i < NsTmp.length; i++) opCounts.addLast(10000);
        //计算得到所需的时长
        AList<Double> UsedTime = new AList<Double>();
        for(int i=0; i < NsTmp.length-1; i++){
            //生成一个对应长度的列表，
            for(int j=NsTmp[i]+1; j <= NsTmp[i+1]; j++) TestList.addLast(0);
            Stopwatch timer = new Stopwatch();
            for(int counter=1; counter<=10000; counter++) TestList.getLast();
            UsedTime.addLast(timer.elapsedTime());
        }

        //打印输出结果
        printTimingTable(Ns,UsedTime,opCounts);
    }

}
