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

import java.io.Serializable;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Date;

/**
 *
 * @author Sebastian Sdorra
 */
public final class ManifestAttribute implements Serializable
{

  /** Field description */
  private static final long serialVersionUID = -8510383632124599655L;

  //~--- constructors ---------------------------------------------------------

  /**
   * Constructs ...
   *
   *
   * @param name
   * @param value
   */
  ManifestAttribute(String name, String value)
  {
    this.name = name;
    this.value = value;
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
  public Boolean getBooleanValue()
  {
    Boolean v = null;

    if (hasValue())
    {
      v = Boolean.parseBoolean(value);
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
  public Class getClassValue()
  {
    Class v = null;

    if (hasValue())
    {
      try
      {
        v = Class.forName(value);
      }
      catch (ClassNotFoundException ex)
      {
        throw new ManifestException("could not find class", ex);
      }
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
  public Double getDoubleValue()
  {
    Double v = null;

    if (hasValue())
    {
      v = Double.parseDouble(value);
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
  public Float getFloatValue()
  {
    Float v = null;

    if (hasValue())
    {
      v = Float.parseFloat(value);
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
  public Integer getIntegerValue()
  {
    Integer v = null;

    if (hasValue())
    {
      v = Integer.parseInt(value);
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
  public Long getLongValue()
  {
    Long v = null;

    if (hasValue())
    {
      v = Long.parseLong(value);
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
  public Date getMavenDateValue()
  {
    Date v = null;

    if (hasValue())
    {
      SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd-HHmm");

      try
      {
        v = sdf.parse(value);
      }
      catch (ParseException ex)
      {
        throw new ManifestException("could not parse maven date", ex);
      }
    }

    return v;
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
  public String getValue()
  {
    return value;
  }

  /**
   * Method description
   *
   *
   * @return
   */
  public boolean hasValue()
  {
    return (value == null) || (value.trim().length() > 0);
  }

  //~--- fields ---------------------------------------------------------------

  /** Field description */
  private String name;

  /** Field description */
  private String value;
}
