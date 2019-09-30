package io.lindstrom.mpd.data.descriptor;

import io.lindstrom.mpd.data.MPD;
import java.util.Objects;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder = {
    "id",
    "scope",
    "any",
    "any"
})

public class ServiceDescription {

  @XmlAttribute(name = "id")
  private String id;

  @XmlElement(name = "Scope", namespace = MPD.NAMESPACE)
  private Scope scope;

  @XmlElement(name = "Latency", namespace = MPD.NAMESPACE)
  private Latency latency;

  @XmlElement(name = "PlaybackRate", namespace = MPD.NAMESPACE)
  private PlaybackRate playbackRate;

  public ServiceDescription(String id, Scope scope, Latency latency,
      PlaybackRate playbackRate) {
    this.id = id;
    this.scope = scope;
    this.latency = latency;
    this.playbackRate = playbackRate;
  }

  public ServiceDescription() {
    this.id = null;
    this.scope = null;
    this.latency = null;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Scope getScope() {
    return scope;
  }

  public void setScope(Scope scope) {
    this.scope = scope;
  }

  public Latency getLatency() {
    return latency;
  }

  public void setLatency(Latency latency) {
    this.latency = latency;
  }

  public PlaybackRate getPlaybackRate() {
    return playbackRate;
  }

  public void setPlaybackRate(PlaybackRate playbackRate) {
    this.playbackRate = playbackRate;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ServiceDescription that = (ServiceDescription) o;
    return id == that.id &&
        scope.equals(that.scope) &&
        latency.equals(that.latency) &&
        playbackRate.equals(that.playbackRate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, scope, latency, playbackRate);
  }

  public final class Builder {

    private String id;
    private Scope scope;
    private Latency latency;
    private PlaybackRate playbackRate;

    public Builder withId(String id) {
      this.id = id;
      return this;
    }

    public Builder withScope(Scope scope) {
      this.scope = scope;
      return this;
    }

    public Builder withLatency(Latency latency) {
      this.latency = latency;
      return this;
    }

    public Builder withPlaybackRate(PlaybackRate playbackRate) {
      this.playbackRate = playbackRate;
      return this;
    }

    public ServiceDescription build() {
      ServiceDescription serviceDescription = new ServiceDescription();
      serviceDescription.setId(id);
      serviceDescription.setScope(scope);
      serviceDescription.setLatency(latency);
      serviceDescription.setPlaybackRate(playbackRate);
      return serviceDescription;
    }
  }

}
