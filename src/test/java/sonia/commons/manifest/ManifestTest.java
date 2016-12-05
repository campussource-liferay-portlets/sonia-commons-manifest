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

//~--- non-JDK imports --------------------------------------------------------

import org.junit.Test;

import static org.junit.Assert.*;

//~--- JDK imports ------------------------------------------------------------

import java.io.IOException;

import java.text.SimpleDateFormat;

import java.util.Collection;
import java.util.Date;

/**
 *
 * @author Sebastian Sdorra
 */
public class ManifestTest extends ManifestTestBase
{

  /**
   * Method description
   *
   *
   * @throws IOException
   */
  @Test
  public void testBooleanRead() throws IOException
  {

    ManifestSection m = read("001").getMainSection();

    assertEquals(Boolean.TRUE, m.getAttributeBooleanValue("Sonia-Unit-Test"));
  }

  /**
   * Method description
   *
   *
   * @throws IOException
   */
  @Test
  public void testGetAttributes() throws IOException
  {
    ManifestSection m = read("001").getMainSection();

    Collection<ManifestAttribute> attributes = m.getAttributes();

    assertNotNull(attributes);
    assertEquals(11, attributes.size());
  }

  /**
   * Method description
   *
   *
   * @throws IOException
   */
  @Test
  public void testGetSection() throws IOException
  {
    ManifestSection s =
      read("001").getSection("sonia/commons/manifest/Manifest");

    assertNotNull(s);

    assertEquals("Section test", s.getAttributeValue("Description"));
  }

  /**
   * Method description
   *
   *
   * @throws IOException
   */
  @Test
  public void testGetSections() throws IOException
  {
    Manifest m = read("001");

    assertNotNull(m);
    assertNotNull(m.getMainSection());
    assertNotNull(m.getSections());
    assertEquals(2, m.getSections().size());
  }

  /**
   * Method description
   *
   *
   * @throws IOException
   */
  @Test
  public void testIntegerRead() throws IOException
  {

    ManifestSection m = read("001").getMainSection();

    assertEquals(Integer.valueOf(7),
      m.getAttributeIntegerValue("Sonia-Build-Number"));
  }

  /**
   * Method description
   *
   *
   * @throws IOException
   */
  @Test
  public void testMavenDateValue() throws IOException
  {
    ManifestSection m = read("001").getMainSection();
    Date d = m.getAttributeMavenDateValue("Sonia-Build-Timestamp");

    assertEquals("2013-04-12 10:58",
      new SimpleDateFormat("yyyy-MM-dd HH:mm").format(d));
  }

  /**
   * Method description
   *
   *
   * @throws IOException
   */
  @Test
  public void testSimpleRead() throws IOException
  {

    ManifestSection m = read("001").getMainSection();

    assertNotNull(m);

    assertEquals("1.0", m.getAttributeValue("Manifest-Version"));
    assertEquals("rzsci2.ostfalia.de", m.getAttributeValue("Sonia-Build-Node"));
  }
}
