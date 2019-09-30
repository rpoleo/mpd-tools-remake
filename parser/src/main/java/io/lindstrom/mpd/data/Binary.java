package io.lindstrom.mpd.data;

import javax.xml.bind.annotation.XmlValue;

public class Binary {

  @XmlValue
  private String value;

  public Binary() {
    this.value = null;
  }

  public Binary(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }
}
