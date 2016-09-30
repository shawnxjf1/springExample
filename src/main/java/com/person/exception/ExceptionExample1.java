package com.person.exception;

/**
 * 参考：http://www.cnblogs.com/focusj/archive/2011/12/26/2301524.html
 * 
 * 参考：http://stackoverflow.com/questions/11524627/how-are-runtimeexceptions-not-checked-by-compiler-even-though-they-extend-excep/11524741#11524741
 * Why Runtime Exceptions are Not Checked The runtime exception classes
 * (RuntimeException and its subclasses) are exempted from compile-time checking
 * because, in the judgment of the designers of the Java programming language,
 * having to declare such exceptions would not aid significantly in establishing
 * the correctness of programs. Many of the operations and constructs of the
 * Java programming language can result in runtime exceptions. The information
 * available to a compiler, and the level of analysis the compiler performs, are
 * usually not sufficient to establish that such run-time exceptions cannot
 * occur, even though this may be obvious to the programmer. Requiring such
 * exception classes to be declared would simply be an irritation to
 * programmers.
 * 
 * @author lakala-shawn
 *
 */
public class ExceptionExample1 {

}
