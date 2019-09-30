package io.lindstrom.mpd.data.descriptor;

public class Latency {

  private final int target;
  private final int max;
  private final int min;

  public Latency() {
    this.target = 0;
    this.max = Integer.MAX_VALUE;
    this.min = Integer.MIN_VALUE;
  }

  public Latency(int target, int max, int min) {
    this.target = target;
    this.max = max;
    this.min = min;
  }

  public int getTarget() {
    return target;
  }

  public int getMax() {
    return max;
  }

  public int getMin() {
    return min;
  }


}
