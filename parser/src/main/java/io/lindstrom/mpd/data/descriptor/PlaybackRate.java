package io.lindstrom.mpd.data.descriptor;

public class PlaybackRate {

  private final float max;
  private final float min;

  public PlaybackRate() {
    this.max = Float.MAX_VALUE;
    this.min = Float.MIN_VALUE;
  }

  public PlaybackRate(float max, float min) {
    this.max = max;
    this.min = min;
  }

  public float getMax() {
    return max;
  }

  public float getMin() {
    return min;
  }
}
