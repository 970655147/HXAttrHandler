/**
 * file name : CuttingOutAndAttrHandler.java
 * created at : 6:39:00 PM Mar 24, 2016
 * created by 970655147
 */

package com.hx.attr_handler.attr_handler;

import java.util.List;

import com.hx.attr_handler.attr_handler.adapter.MultiArgsAttrHandler;
import com.hx.attr_handler.attr_handler.interf.AttrHandler;
import com.hx.attr_handler.util.AttrHandlerConstants;

// 短路与
// and(left, right), left && right
public class CuttingOutAndAttrHandler<T extends AttrHandler> extends MultiArgsAttrHandler<T> {
	// 初始化
	public CuttingOutAndAttrHandler(List<T> handlers) {
		super(handlers);
	}
	public CuttingOutAndAttrHandler(int initCap) {
		super(initCap);
	}
	public CuttingOutAndAttrHandler() {
		this(AttrHandlerConstants.CUTTING_DOOR_HANDLER_DEFAULT_CAP);
	}
	
	@Override
	protected String handle0(String result) {
		for(AttrHandler handler : handlers) {
			if(AttrHandlerConstants.FALSE.equals(handler.handle(result)) ) {
				return AttrHandlerConstants.FALSE;
			}
		}
		
		return AttrHandlerConstants.TRUE;
	}
	
	@Override
	public String name() {
		return AttrHandlerConstants.CUTTING_OUT_AND;
	}
	
}
