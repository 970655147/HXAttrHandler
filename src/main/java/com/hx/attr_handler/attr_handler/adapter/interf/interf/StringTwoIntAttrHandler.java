/**
 * file name : StringOneOrTwoIntAttrHandler.java
 * created at : 3:17:03 AM May 21, 2016
 * created by 970655147
 */

package com.hx.attr_handler.attr_handler.adapter.interf.interf;

import com.hx.attr_handler.attr_handler.interf.AttrHandler;

public abstract class StringTwoIntAttrHandler extends AttrHandler {

	// 配置两个参数
	public abstract void setArgs(String str, int start, int end);
	
}
