package io.lindstrom.mpd.data.descriptor;
import javax.xml.bind.annotation.XmlAttribute;

public class Scope {

  @XmlAttribute(name = "schemeIdUri")
  private String schemeIdUri;

  public Scope(String schemeIdUri) {
    this.schemeIdUri = schemeIdUri;
  }

  @SuppressWarnings("unused")
  public Scope(){
    schemeIdUri = null;
  }

  public String getSchemeIdUri() {
    return schemeIdUri;
  }

  public void setSchemeIdUri(String schemeIdUri) {
    this.schemeIdUri = schemeIdUri;
  }
}

