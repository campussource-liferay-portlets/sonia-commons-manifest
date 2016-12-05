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

import java.io.IOException;

/**
 *
 * @author Sebastian Sdorra
 */
public class ManifestTestBase
{

  /** Field description */
  private static final String RESOURCE =
    "sonia/commons/manifest/manifest.%s.mf";

  //~--- methods --------------------------------------------------------------

  /**
   * Method description
   *
   *
   * @param nr
   *
   * @return
   *
   * @throws IOException
   */
  protected Manifest read(String nr) throws IOException
  {
    return Manifests.readFromResource(ManifestTestBase.class,
      String.format(RESOURCE, nr));
  }
}
