package com.person.io.nio.core;

/**
 * 1.Java NIO contains the concept of "selectors".<br>
 * A selector is an object that can monitor multiple channels for events (like: connection opened, data arrived etc.). 
 * Thus, a single thread can monitor multiple channels for data.<br>
 * A Selector allows a single thread to handle multiple Channel's. This is handy if your application has many connections (Channels) open, 
 * but only has low traffic on each connection. For instance, in a chat server.<br>
 * @author lakala-shawn
 */
public class SelectorsConcept {

}
