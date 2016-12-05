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

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import java.net.URL;

import java.util.Enumeration;
import java.util.jar.JarFile;

/**
 *
 * @author Sebastian Sdorra
 */
public final class Manifests
{

  /**
   * Constructs ...
   *
   */
  private Manifests() {}

  //~--- methods --------------------------------------------------------------

  /**
   * Method description
   *
   *
   * @param path
   * @param name
   * @param value
   *
   * @return
   *
   * @throws IOException
   */
  public static Manifest findManifest(String path, String name, String value)
    throws IOException
  {
    ClassLoader classLoader = Thread.currentThread().getContextClassLoader();

    if (classLoader == null)
    {
      classLoader = Manifest.class.getClassLoader();
    }

    return findManifest(classLoader, path, null, name, value);
  }

  /**
   * Method description
   *
   *
   * @param classLoader
   * @param path
   * @param name
   * @param value
   *
   * @return
   *
   * @throws IOException
   */
  public static Manifest findManifest(ClassLoader classLoader, String path,
    String name, String value)
    throws IOException
  {
    return findManifest(classLoader, path, null, name, value);
  }

  /**
   * Method description
   *
   *
   * @param classLoader
   * @param path
   * @param sectionName
   * @param name
   * @param value
   *
   * @return
   *
   * @throws IOException
   */
  public static Manifest findManifest(ClassLoader classLoader, String path,
    String sectionName, String name, String value)
    throws IOException
  {
    Manifest manifest = null;
    Enumeration<URL> resources = classLoader.getResources(path);

    while (resources.hasMoreElements())
    {
      URL resource = resources.nextElement();
      Manifest m = readFromUrl(resource);

      if (m != null)
      {
        ManifestSection section;

        if (sectionName == null)
        {
          section = m.getMainSection();
        }
        else
        {
          section = m.getSection(sectionName);
        }

        if ((section != null) && section.hasAttribute(name)
          && value.equals(section.getAttributeValue(name)))
        {
          manifest = m;

          break;
        }
      }
    }

    return manifest;
  }

  /**
   * Method description
   *
   *
   * @param file
   *
   * @return
   *
   * @throws IOException
   */
  public static Manifest readFromArchive(File file) throws IOException
  {
    Manifest manifest = null;
    JarFile jar = null;

    try
    {
      jar = new JarFile(file);
      manifest = new Manifest(jar.getManifest());
    }
    finally
    {
      if (jar != null)
      {
        jar.close();
      }
    }

    return manifest;
  }

  /**
   * Method description
   *
   *
   * @param file
   *
   * @return
   *
   * @throws IOException
   */
  public static Manifest readFromFile(File file) throws IOException
  {
    Manifest manifest = null;
    InputStream content = null;

    try
    {
      content = new FileInputStream(file);
      manifest = readFromStream(content);
    }
    finally
    {
      if (content != null)
      {
        content.close();
      }
    }

    return manifest;
  }

  /**
   * Method description
   *
   *
   * @param path
   *
   * @return
   *
   * @throws IOException
   */
  public static Manifest readFromResource(String path) throws IOException
  {
    return readFromResource(Manifests.class, path);
  }

  /**
   * Method description
   *
   *
   * @param classLoader
   * @param path
   *
   * @return
   *
   * @throws IOException
   */
  public static Manifest readFromResource(ClassLoader classLoader, String path)
    throws IOException
  {
    return readFromUrl(classLoader.getResource(path));
  }

  /**
   * Method description
   *
   *
   * @param contextClass
   * @param path
   *
   * @return
   *
   * @throws IOException
   */
  public static Manifest readFromResource(Class contextClass, String path)
    throws IOException
  {
    return readFromResource(contextClass.getClassLoader(), path);
  }

  /**
   * Method description
   *
   *
   * @param stream
   *
   * @return
   *
   * @throws IOException
   */
  public static Manifest readFromStream(InputStream stream) throws IOException
  {
    return new Manifest(new java.util.jar.Manifest(stream));
  }

  /**
   * Method description
   *
   *
   * @param url
   *
   * @return
   *
   * @throws IOException
   */
  public static Manifest readFromUrl(URL url) throws IOException
  {
    Manifest manifest = null;
    InputStream content = null;

    try
    {
      content = url.openStream();
      manifest = readFromStream(content);
    }
    finally
    {
      if (content != null)
      {
        content.close();
      }
    }

    return manifest;
  }
}
