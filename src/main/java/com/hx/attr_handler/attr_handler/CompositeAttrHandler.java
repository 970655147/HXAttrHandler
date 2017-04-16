/**
 * file name : CompositeAttrHandler.java
 * created at : 1:14:46 PM Mar 22, 2016
 * created by 970655147
 */

package com.hx.attr_handler.attr_handler;

import java.util.List;

import com.hx.attr_handler.attr_handler.adapter.MultiArgsAttrHandler;
import com.hx.attr_handler.attr_handler.interf.AttrHandler;
import com.hx.attr_handler.util.AttrHandlerConstants;

// 包含一个attrHandler链的AttrHandler
public class CompositeAttrHandler extends MultiArgsAttrHandler<AttrHandler> {
	// 初始化
	public CompositeAttrHandler(List<AttrHandler> handlerChain) {
		super(handlerChain);
	}
	public CompositeAttrHandler(int initCap) {
		super(initCap);
	}
	public CompositeAttrHandler() {
		super(AttrHandlerConstants.COMPOSITE_HANDLER_DEFAULT_CAP);
	}
	
	@Override
	public String handle0(String result) {
		String res = result;
		for(AttrHandler handler : handlers) {
			res = handler.handle(res);
		}
		
		return res;
	}
	
	@Override
	public String name() {
		return AttrHandlerConstants.COMPOSITE;
	}

}
