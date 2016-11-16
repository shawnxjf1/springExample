package com.person.io;

import java.io.IOException;
import java.util.jar.JarFile;

/**
 * the plugin interface
 * @author lakala-shawn
 *
 */
public interface IJarProcessor {

    public void process() throws IOException,ClassNotFoundException;
    
    public JarFile getJarFile();
}