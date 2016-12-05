/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



package sonia.commons.manifest;

//~--- JDK imports ------------------------------------------------------------

import java.io.Serializable;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.jar.Attributes;

/**
 *
 * @author Sebastian Sdorra
 */
public final class Manifest implements Serializable
{

  /** Field description */
  public static final String RESOURCE_PATH = "META-INF/MANIFEST.MF";

  /** Field description */
  private static final String SECTION_MAIN = "";

  /** Field description */
  private static final long serialVersionUID = -7284052313839596231L;

  //~--- constructors ---------------------------------------------------------

  /**
   * Constructs ...
   *
   *
   * @param manifest
   */
  Manifest(java.util.jar.Manifest manifest)
  {
    Map<String, ManifestSection> map = new HashMap<String, ManifestSection>();

    map.put(SECTION_MAIN,
      new ManifestSection(SECTION_MAIN, manifest.getMainAttributes()));

    for (Entry<String, Attributes> e : manifest.getEntries().entrySet())
    {
      map.put(e.getKey(), new ManifestSection(e.getKey(), e.getValue()));
    }

    this.sections = Collections.unmodifiableMap(map);
  }

  //~--- get methods ----------------------------------------------------------

  /**
   * Method description
   *
   *
   * @return
   */
  public ManifestSection getMainSection()
  {
    return sections.get(SECTION_MAIN);
  }

  /**
   * Method description
   *
   *
   * @param name
   *
   * @return
   */
  public ManifestSection getSection(String name)
  {
    return sections.get(name);
  }

  /**
   * Method description
   *
   *
   * @return
   */
  public Collection<ManifestSection> getSections()
  {
    return sections.values();
  }

  //~--- fields ---------------------------------------------------------------

  /** Field description */
  private Map<String, ManifestSection> sections;
}
