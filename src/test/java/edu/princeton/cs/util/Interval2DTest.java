package edu.princeton.cs.util;

import edu.princeton.cs.fundamentals.dataabstraction.Interval1D;
import edu.princeton.cs.fundamentals.dataabstraction.Interval2D;
import org.assertj.core.api.Assertions;
import org.junit.Test;

public class Interval2DTest {

    @Test
    public void contains() {
        Interval1D x1 = new Interval1D(11, 16);
        Interval1D y1 = new Interval1D(7, 18);
        Interval2D x = new Interval2D(x1, y1);

        Interval1D x2 = new Interval1D(15, 16);
        Interval1D y2 = new Interval1D(13, 14);
        Interval2D y = new Interval2D(x2, y2);

        Assertions.assertThat(x.contains(y)).isEqualTo(true);
    }
}
