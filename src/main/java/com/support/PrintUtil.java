package com.support;

import java.util.Arrays;

public class PrintUtil {
	
	public static void SysOut(String prefix,Object o)
	{
		if (null != prefix)
		{
			System.out.println(prefix + o);
		}else
		{
			System.out.println(o);
		}
	}
	
	public static void SysOutArr(String prefix,Object... o )
	{
		Object[] oArr = o;
		if (null != prefix)
		{
			System.out.println(prefix + Arrays.asList(oArr));
		}else
		{
			System.out.println(Arrays.asList(oArr));
		}
	}

}
