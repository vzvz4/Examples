package CollectionsExample.concurent.delayList;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class DelayObject implements Delayed {
    private String data;
    private long time;

    public DelayObject(String data, long delayInMilliseconds) {
        this.data = data;
        this.time = System.currentTimeMillis() + delayInMilliseconds;
    }

    @Override
    public long getDelay(TimeUnit timeUnit) {
        long diff = time - System.currentTimeMillis();
        return timeUnit.convert(diff, TimeUnit.MILLISECONDS);
    }

    @Override
    public int compareTo(Delayed delayed) {
        if (delayed == this) return 0;
        else if (delayed instanceof DelayObject) {
            return (int) (this.time - ((DelayObject) delayed).time);
        } else {
            long d = this.getDelay(TimeUnit.NANOSECONDS) - delayed.getDelay(TimeUnit.NANOSECONDS);
            return Long.compare(d, 0L);
        }
    }
}
