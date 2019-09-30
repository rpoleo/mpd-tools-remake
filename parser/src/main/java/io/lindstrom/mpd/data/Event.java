package io.lindstrom.mpd.data;

import javax.xml.bind.annotation.XmlAttribute;
import java.util.Objects;
import javax.xml.bind.annotation.XmlElement;

public class Event {
    @XmlAttribute(name = "presentationTime")
    private final Long presentationTime;

    @XmlAttribute(name = "duration")
    private final Long duration;

    @XmlAttribute(name = "id")
    private final Long id;

    @XmlAttribute(name = "messageData")
    private final String messageData;

    @XmlElement (name = "Signal")
    private final Signal signal;

    private Event(Long presentationTime, Long duration, Long id, String messageData, Signal signal) {
        this.presentationTime = presentationTime;
        this.duration = duration;
        this.id = id;
        this.messageData = messageData;
        this.signal = signal;
    }

    @SuppressWarnings("unused")
    private Event() {
        this.presentationTime = null;
        this.duration = null;
        this.id = null;
        this.messageData = null;
        this.signal = null;
    }

    public Long getPresentationTime() {
        return presentationTime;
    }

    public Long getDuration() {
        return duration;
    }

    public Long getId() {
        return id;
    }

    public String getMessageData() {
        return messageData;
    }

    public Signal getSignal() {
        return signal;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public Builder buildUpon() {
        return new Builder()
                .withPresentationTime(presentationTime)
                .withDuration(duration)
                .withId(id)
                .withMessageData(messageData)
                .withSignal(signal);
    }

    public static class Builder {
        private Long presentationTime;
        private Long duration;
        private Long id;
        private String messageData;
        private Signal signal;

        public Builder withPresentationTime(Long presentationTime) {
            this.presentationTime = presentationTime;
            return this;
        }

        public Builder withDuration(Long duration) {
            this.duration = duration;
            return this;
        }

        public Builder withId(Long id) {
            this.id = id;
            return this;
        }

        public Builder withMessageData(String messageData) {
            this.messageData = messageData;
            return this;
        }

        public Builder withSignal(Signal signal) {
            this.signal = signal;
            return this;
        }

        public Event build() {
            return new Event(presentationTime, duration, id, messageData, signal);
        }
    }
}
