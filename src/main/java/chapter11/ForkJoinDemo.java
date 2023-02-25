package chapter11;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinWorkerThread;
import java.util.concurrent.RecursiveTask;

public class ForkJoinDemo {
    public static void main(String[] args) {
        int n = 20;

        final ForkJoinPool.ForkJoinWorkerThreadFactory factory = pool -> {
            final ForkJoinWorkerThread worker = ForkJoinPool.defaultForkJoinWorkerThreadFactory.newThread(pool);
            worker.setName("my-thread" + worker.getPoolIndex());
            return worker;
        };
        // 创建分支任务线程池，可以追踪到线程名称
        ForkJoinPool forkJoinPool = new ForkJoinPool(4, factory, null, false);
        // 快读创建ForkJoinPool方法
//        ForkJoinPool forkJoinPool = new ForkJoinPool(4);
        // 创建分支任务
        Fibonacci fibonacci = new Fibonacci(n);
        Integer result = forkJoinPool.invoke(fibonacci);
        System.out.println("Fibonacci: "+n+" 的结果是: "+result);

    }
}


class Fibonacci extends RecursiveTask<Integer> {
    final int n;
    Fibonacci(int n) {
        this.n = n;
    }

    /**
     * The main computation performed by this task.
     *
     * @return the result of the computation
     */
    @Override
    protected Integer compute() {
        // 和递归类似，定义可计算的最小单元
         if (n <= 1) {
             return n;
         }
         // 想查看子线程名称输出的可以打开下面注释
//        log.info(Thread.currentThread().getName());
        Fibonacci f1 = new Fibonacci(n - 1);
         f1.fork();
         // 拆分子任务
        Fibonacci f2 = new Fibonacci(n - 2);
        return f2.compute() + f1.join();
    }
}