package edu.princeton.cs.algs4.util;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import edu.princeton.cs.algs4.fundamentals.section2.Interval1D;
import edu.princeton.cs.algs4.fundamentals.section2.Interval2D;

public class Interval2DTest {

    @Test
    public void contains() {
        Interval1D x1 = new Interval1D(11, 16);
        Interval1D y1 = new Interval1D(7, 18);
        Interval2D x = new Interval2D(x1, y1);

        Interval1D x2 = new Interval1D(15, 16);
        Interval1D y2 = new Interval1D(13, 14);
        Interval2D y = new Interval2D(x2, y2);

        assertThat(x.contains(y)).isEqualTo(true);
    }
}
