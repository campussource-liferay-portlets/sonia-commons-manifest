/**
 * OSTFALIA CONFIDENTIAL
 *
 * 2010 - 2013 Ostfalia University of Applied Sciences All Rights Reserved.
 *
 * NOTICE: All information contained herein is, and remains the property of
 * Ostfalia University of Applied Sciences and its suppliers, if any. The
 * intellectual and technical concepts contained herein are proprietary to
 * Ostfalia University of Applied Sciences and its suppliers and may be covered
 * by U.S. and Foreign Patents, patents in process, and are protected by trade
 * secret or copyright law. Dissemination of this information or reproduction of
 * this material is strictly forbidden unless prior written permission is
 * obtained from Ostfalia University of Applied Sciences.
 */



package sonia.commons.manifest;

//~--- JDK imports ------------------------------------------------------------

import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.jar.Attributes;

/**
 *
 * @author Sebastian Sdorra
 */
public final class ManifestSection implements Iterable<ManifestAttribute>
{

  /**
   * Constructs ...
   *
   *
   * @param name
   * @param attributes
   */
  ManifestSection(String name, Attributes attributes)
  {
    this.name = name;

    Map<String, ManifestAttribute> map = new HashMap<String,
                                           ManifestAttribute>();

    for (Entry<Object, Object> e : attributes.entrySet())
    {
      String n = e.getKey().toString();
      String v = (String) e.getValue();

      map.put(n, new ManifestAttribute(n, v));
    }

    this.attributes = Collections.unmodifiableMap(map);
  }

  //~--- methods --------------------------------------------------------------

  /**
   * Method description
   *
   *
   * @return
   */
  @Override
  public Iterator<ManifestAttribute> iterator()
  {
    return getAttributes().iterator();
  }

  //~--- get methods ----------------------------------------------------------

  /**
   * Method description
   *
   *
   * @param name
   *
   * @return
   */
  public ManifestAttribute getAttribute(String name)
  {
    return attributes.get(name);
  }

  /**
   * Method description
   *
   *
   * @param name
   *
   * @return
   */
  public Boolean getAttributeBooleanValue(String name)
  {
    Boolean v = null;
    ManifestAttribute a = attributes.get(name);

    if (a != null)
    {
      v = a.getBooleanValue();
    }

    return v;
  }

  /**
   * Method description
   *
   *
   * @param name
   *
   * @return
   */
  public Class getAttributeClassValue(String name)
  {
    Class v = null;
    ManifestAttribute a = attributes.get(name);

    if (a != null)
    {
      v = a.getClassValue();
    }

    return v;
  }

  /**
   * Method description
   *
   *
   * @param name
   *
   * @return
   */
  public Double getAttributeDoubleValue(String name)
  {
    Double v = null;
    ManifestAttribute a = attributes.get(name);

    if (a != null)
    {
      v = a.getDoubleValue();
    }

    return v;
  }

  /**
   * Method description
   *
   *
   * @param name
   *
   * @return
   */
  public Float getAttributeFloatValue(String name)
  {
    Float v = null;
    ManifestAttribute a = attributes.get(name);

    if (a != null)
    {
      v = a.getFloatValue();
    }

    return v;
  }

  /**
   * Method description
   *
   *
   * @param name
   *
   * @return
   */
  public Integer getAttributeIntegerValue(String name)
  {
    Integer v = null;
    ManifestAttribute a = attributes.get(name);

    if (a != null)
    {
      v = a.getIntegerValue();
    }

    return v;
  }

  /**
   * Method description
   *
   *
   * @param name
   *
   * @return
   */
  public Long getAttributeLongValue(String name)
  {
    Long v = null;
    ManifestAttribute a = attributes.get(name);

    if (a != null)
    {
      v = a.getLongValue();
    }

    return v;
  }

  /**
   * Method description
   *
   *
   * @param name
   *
   * @return
   */
  public Date getAttributeMavenDateValue(String name)
  {
    Date v = null;
    ManifestAttribute a = attributes.get(name);

    if (a != null)
    {
      v = a.getMavenDateValue();
    }

    return v;
  }

  /**
   * Method description
   *
   *
   * @param name
   *
   * @return
   */
  public String getAttributeValue(String name)
  {
    String v = null;
    ManifestAttribute a = attributes.get(name);

    if (a != null)
    {
      v = a.getValue();
    }

    return v;
  }

  /**
   * Method description
   *
   *
   * @return
   */
  public Collection<ManifestAttribute> getAttributes()
  {
    return attributes.values();
  }

  /**
   * Method description
   *
   *
   * @return
   */
  public String getName()
  {
    return name;
  }

  /**
   * Method description
   *
   *
   * @param name
   *
   * @return
   */
  public boolean hasAttribute(String name)
  {
    return attributes.containsKey(name);
  }

  //~--- fields ---------------------------------------------------------------

  /** Field description */
  private Map<String, ManifestAttribute> attributes;

  /** Field description */
  private String name;
}
