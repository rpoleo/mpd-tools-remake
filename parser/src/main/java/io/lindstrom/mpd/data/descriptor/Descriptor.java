package io.lindstrom.mpd.data.descriptor;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import javax.xml.bind.annotation.XmlAttribute;
import java.util.Objects;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        property = "schemeIdUri",
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        visible = true,
        defaultImpl = GenericDescriptor.class)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Role.class, name = Role.SCHEME_ID_URI)}
)
public abstract class Descriptor {
    @XmlAttribute(name = "schemeIdUri")
    protected final String schemeIdUri;

    @XmlAttribute(name = "id")
    protected final String id;

    @XmlAttribute(name = "reportingUrl")
    protected final String reportingUrl;

    @XmlAttribute(name = "probability")
    protected final String probability;

    protected Descriptor(String schemeIdUri, String id) {
        this.schemeIdUri = schemeIdUri;
        this.id = id;
        this.reportingUrl = null;
        this.probability = null;
    }

    protected Descriptor(String schemeIdUri, String id, String reportingUrl, String probability) {
        this.schemeIdUri = schemeIdUri;
        this.id = id;
        this.reportingUrl = reportingUrl;
        this.probability = probability;
    }

    public String getSchemeIdUri() {
        return schemeIdUri;
    }

    public String getId() {
        return id;
    }

    public String getReportingUrl() {
        return reportingUrl;
    }

    public String getProbability() {
        return probability;
    }

    @JsonIgnore
    public abstract String getValue();

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
