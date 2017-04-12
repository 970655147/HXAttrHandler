/**
 * file name : ConcateAttrHandler.java
 * created at : 1:09:46 PM Mar 22, 2016
 * created by 970655147
 */

package com.hx.attr_handler.attr_handler;

import java.util.List;

import com.hx.attr_handler.attr_handler.adapter.MultiArgsAttrHandler;
import com.hx.attr_handler.attr_handler.interf.AttrHandler;
import com.hx.attr_handler.util.HXAttrHandlerConstants;

// 连接字符串的handler
// map(hello + $this + world)
public class ConcateAttrHandler extends MultiArgsAttrHandler<AttrHandler> {
	// 初始化
	public ConcateAttrHandler(List<AttrHandler> handlers) {
		super(handlers);
	}
	public ConcateAttrHandler(int initCap) {
		super(initCap);
	}
	public ConcateAttrHandler() {
		this(HXAttrHandlerConstants.CONCATE_HANDLER_DEFAULT_CAP);
	}
	
	@Override
	public String handle0(String result) {
		StringBuilder sb = new StringBuilder();
		for(AttrHandler handler : handlers) {
			String res = handler.handle(result);
			if(HXAttrHandlerConstants.RESULT_PROXY.equals(res) ) {
				sb.append(result);
			} else {
				sb.append(res);
			}
		}
		
		return sb.toString();
	}

	@Override
	public String name() {
		return HXAttrHandlerConstants.CONCATE;
	}
	
}
