/**
 * file name : ConcateAttrHandler.java
 * created at : 1:09:46 PM Mar 22, 2016
 * created by 970655147
 */

package com.hx.attr_handler.attr_handler;

import com.hx.attr_handler.attr_handler.adapter.interf.interf.OneBooleanArgsAttrHandler;
import com.hx.attr_handler.util.HXAttrHandlerConstants;

// 将给定的[boo]转换为[!boo]的handler
// map(not('abc') )
public class NotAttrHandler extends OneBooleanArgsAttrHandler {
	// 处理结果得到的常量值
	private boolean boo;
	
	// 初始化
	public NotAttrHandler(boolean  boo) {
		this.boo =  boo;
	}
	public NotAttrHandler() {
		this(false);
	}
	
	@Override
	public String handle0(String result) {
		if(boo) {
			return HXAttrHandlerConstants.FALSE;
		} else {
			return HXAttrHandlerConstants.TRUE;
		}
	}

	@Override
	public String name() {
		return HXAttrHandlerConstants.NOT;
	}

	@Override
	public void setArgs(boolean arg) {
		this.boo = arg;
	}
	
}
