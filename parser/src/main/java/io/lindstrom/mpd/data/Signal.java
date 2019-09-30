package io.lindstrom.mpd.data;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class Signal {

  @XmlAttribute (name =  "xmlns")
  private String xmlns;

  @XmlElement (name = "Binary")
  private Binary binary;

  public Signal() {
  }

  public String getXmlns() {
    return xmlns;
  }

  public void setXmlns(String xmlns) {
    this.xmlns = xmlns;
  }

  public Binary getBinary() {
    return binary;
  }

  public void setBinary(Binary binary) {
    this.binary = binary;
  }
}
