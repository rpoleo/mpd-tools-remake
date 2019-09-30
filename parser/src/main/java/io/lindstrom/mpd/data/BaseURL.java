package io.lindstrom.mpd.data;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlValue;
import java.util.Objects;

public class BaseURL {
    @XmlValue
    private final String value;

    @XmlAttribute(name = "serviceLocation")
    private final String serviceLocation;

    @XmlAttribute(name = "byteRange")
    private final String byteRange;

    @XmlAttribute(name = "availabilityTimeOffset")
    private final Double availabilityTimeOffset;

    @XmlAttribute(name = "availabilityTimeComplete")
    private final Boolean availabilityTimeComplete;

    @XmlAttribute(name = "priority")
    private final int priority;

    @XmlAttribute(name= "weight")
    private final int weight;

    @SuppressWarnings("unused")
    private BaseURL() {
        this.value = null;
        this.serviceLocation = null;
        this.byteRange = null;
        this.availabilityTimeOffset = null;
        this.availabilityTimeComplete = null;
        this.priority = 1;
        this.weight = 1;
    }

    @SuppressWarnings("unused")
    private BaseURL(String value) {
        this.value = value;
        this.serviceLocation = null;
        this.byteRange = null;
        this.availabilityTimeOffset = null;
        this.availabilityTimeComplete = null;
        this.priority = 1;
        this.weight = 1;
    }

    private BaseURL(String value, String serviceLocation, String byteRange, Double availabilityTimeOffset, Boolean availabilityTimeComplete, int priority, int weight) {
        this.value = value;
        this.serviceLocation = serviceLocation;
        this.byteRange = byteRange;
        this.availabilityTimeOffset = availabilityTimeOffset;
        this.availabilityTimeComplete = availabilityTimeComplete;
        this.priority = priority;
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public int getPriority() {
        return priority;
    }

    public String getValue() {
        return value;
    }

    public String getServiceLocation() {
        return serviceLocation;
    }

    public String getByteRange() {
        return byteRange;
    }

    public Double getAvailabilityTimeOffset() {
        return availabilityTimeOffset;
    }

    public Boolean getAvailabilityTimeComplete() {
        return availabilityTimeComplete;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseURL baseURL = (BaseURL) o;
        return Objects.equals(value, baseURL.value) &&
                Objects.equals(serviceLocation, baseURL.serviceLocation) &&
                Objects.equals(byteRange, baseURL.byteRange) &&
                Objects.equals(availabilityTimeOffset, baseURL.availabilityTimeOffset) &&
                Objects.equals(availabilityTimeComplete, baseURL.availabilityTimeComplete);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, serviceLocation, byteRange, availabilityTimeOffset, availabilityTimeComplete);
    }

    @Override
    public String toString() {
        return "BaseURL{" +
                "value='" + value + '\'' +
                ", serviceLocation='" + serviceLocation + '\'' +
                ", byteRange='" + byteRange + '\'' +
                ", availabilityTimeOffset=" + availabilityTimeOffset +
                ", availabilityTimeComplete=" + availabilityTimeComplete +
                ", priority=" + priority +
                ", weight=" + weight +
                '}';
    }

    public Builder buildUpon() {
        return new Builder()
                .withValue(value)
                .withServiceLocation(serviceLocation)
                .withByteRange(byteRange)
                .withAvailabilityTimeOffset(availabilityTimeOffset)
                .withAvailabilityTimeComplete(availabilityTimeComplete)
                .withPriority(priority);
    }

    public static class Builder {
        private String value;
        private String serviceLocation;
        private String byteRange;
        private Double availabilityTimeOffset;
        private Boolean availabilityTimeComplete;
        private int priority;
        private int weight;

        private Builder withValue(String value) {
            this.value = value;
            return this;
        }

        private Builder withServiceLocation(String serviceLocation) {
            this.serviceLocation = serviceLocation;
            return this;
        }

        private Builder withByteRange(String byteRange) {
            this.byteRange = byteRange;
            return this;
        }

        private Builder withAvailabilityTimeOffset(Double availabilityTimeOffset) {
            this.availabilityTimeOffset = availabilityTimeOffset;
            return this;
        }

        private Builder withAvailabilityTimeComplete(Boolean availabilityTimeComplete) {
            this.availabilityTimeComplete = availabilityTimeComplete;
            return this;
        }

        private Builder withPriority(int priority) {
            this.priority = priority;
            return this;
        }

        private Builder withWeight(int weight) {
            this.weight = weight;
            return this;
        }

        public BaseURL build() {
            return new BaseURL(value, serviceLocation, byteRange, availabilityTimeOffset, availabilityTimeComplete, priority, weight);
        }
    }
}
