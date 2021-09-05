import java.util.HashMap;
import java.util.Map;

/**
 * @program: untitled
 * @description: 正态分布
 * @author: YOUNG
 * @create: 2021-09-05 00:19
 */
public class normalDistribution {

    public static double avg(int[] elements) {
        int sum = 0;
        for (int element : elements)
            sum += element;
        return sum / (double) elements.length;
    }

    public static double avg(double[] elements) {
        double sum = 0;
        for (double element : elements)
            sum += element;
        return sum / elements.length;
    }

    public static double D(int[] elements) {
        double avg = avg(elements);
        double sum = 0;
        for (int element : elements)
            sum += Math.pow(element - avg, 2.0);
        return sum / elements.length;
    }

    public static double D(double[] elements) {
        double avg = avg(elements);
        double sum = 0;
        for (double element : elements)
            sum += Math.pow(element - avg, 2.0);
        return sum / elements.length;
    }

    public static double E(int[] elements) {
        Map<Integer, Double> num = new HashMap<>();
        for (int element : elements)
            if (!num.containsKey(element))
                num.put(element, 1.0 / elements.length);
            else
                num.put(element, num.get(element) + 1.0 / elements.length);
        double[] variance = {0.0};
        num.forEach((k, v) -> variance[0] += k * v);
        return variance[0];
    }

    public static double E(double[] elements) {
        Map<Double, Double> num = new HashMap<>();
        for (double element : elements)
            if (!num.containsKey(element))
                num.put(element, 1.0 / elements.length);
            else
                num.put(element, num.get(element) + 1.0 / elements.length);
        double[] variance = {0.0};
        num.forEach((k, v) -> variance[0] += k * v);
        return variance[0];
    }

    public static double f(int[] elements, double x) {
        double variance = D(elements);
        return 1 / Math.pow(2 * Math.PI * variance, 0.5) * Math.exp(-Math.pow(x - E(elements), 2.0) / 2 / variance);
    }

    public static double standardF(double x) {
        return 1 / Math.pow(2 * Math.PI, 0.5) * Math.exp(-(x * x / 2.0));
    }
}
