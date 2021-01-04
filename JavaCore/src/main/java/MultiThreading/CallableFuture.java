package MultiThreading;

import java.util.Random;
import java.util.concurrent.*;

public class CallableFuture {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService es  = Executors.newFixedThreadPool(1);
        //мы можем возвращать значения из потока по его завершению
        Future<Integer> future = es.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                System.out.println("Starting Thread");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Finished");
                Random random = new Random();

                //бросаем исключение для примера
                if (random.nextInt(8) < 4) {
                    //мы можем ловить любые исключения в потоках с помощью
                    //catch(ExecutionException), обычно потоки выбрасывают
                    //только InterruptedException
                    throw new IllegalArgumentException("Something wrong");
                }
                return random.nextInt(10);
            }
        });
        es.shutdown();
        try {
            int result = future.get(); //get дожидается окончание потока
            System.out.println(result);
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

}
