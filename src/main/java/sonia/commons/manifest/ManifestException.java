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

/**
 *
 * @author Sebastian Sdorra
 */
public class ManifestException extends RuntimeException
{

  /** Field description */
  private static final long serialVersionUID = 1584829439764310109L;

  //~--- constructors ---------------------------------------------------------

  /**
   * Constructs ...
   *
   */
  public ManifestException() {}

  /**
   * Constructs ...
   *
   *
   * @param message
   */
  public ManifestException(String message)
  {
    super(message);
  }

  /**
   * Constructs ...
   *
   *
   * @param cause
   */
  public ManifestException(Throwable cause)
  {
    super(cause);
  }

  /**
   * Constructs ...
   *
   *
   * @param message
   * @param cause
   */
  public ManifestException(String message, Throwable cause)
  {
    super(message, cause);
  }
}
