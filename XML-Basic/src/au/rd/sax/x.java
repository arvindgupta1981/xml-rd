package au.rd.sax;

import au.com.dom.Test;

public class x extends Test{
	private int y=9;
	public x(){
		x t = new x();
		System.out.println(t.y);
	}
}