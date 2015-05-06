package hazelcast_test;

import java.util.Map;

import com.codahale.metrics.Meter;
import com.codahale.metrics.MetricRegistry;

public class TestMetrics {
    public static void main(String[] args) {
        MetricRegistry metrics = new MetricRegistry();
        Meter meter = metrics.meter(metrics.name("111", null));
        meter.mark(11);
        for (Map.Entry<String, Meter> entry : metrics.getMeters().entrySet()) {
            metrics.remove("111");
        }
        System.out.println(metrics.getMeters().get("111"));
        metrics.remove("111");
        System.out.println(metrics.getMeters().get("111"));
        System.out.println(meter.getCount());
        meter.mark();
        System.out.println(meter.getCount());
    }
}
