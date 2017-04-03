/**
 * file name : CuttingOutAndAttrHandler.java
 * created at : 6:39:00 PM Mar 24, 2016
 * created by 970655147
 */

package com.hx.attrHandler.attrHandler;

import java.util.List;

import com.hx.attrHandler.attrHandler.adapter.MultiArgsAttrHandler;
import com.hx.attrHandler.attrHandler.interf.AttrHandler;
import com.hx.attrHandler.util.HXAttrHandlerConstants;

// 短路与
// and(left, right), left && right
public class CuttingOutOrAttrHandler<T extends AttrHandler> extends MultiArgsAttrHandler<T> {
	// 初始化
	public CuttingOutOrAttrHandler(List<T> handlers) {
		super(handlers);
	}
	public CuttingOutOrAttrHandler(int initCap) {
		super(initCap);
	}
	public CuttingOutOrAttrHandler() {
		this(HXAttrHandlerConstants.CUTTING_DOOR_HANDLER_DEFAULT_CAP);
	}
	
	@Override
	protected String handle0(String result) {
		for(AttrHandler handler : handlers) {
			if(HXAttrHandlerConstants.TRUE.equals(handler.handle(result)) ) {
				return HXAttrHandlerConstants.TRUE;
			}
		}
		
		return HXAttrHandlerConstants.FALSE;
	}
	
	@Override
	public String name() {
		return HXAttrHandlerConstants.CUTTING_OUT_OR;
	}
	
}
