/**
 * file name : CuttingOutAndAttrHandler.java
 * created at : 6:39:00 PM Mar 24, 2016
 * created by 970655147
 */

package com.hx.attrHandler.attrHandler;

import java.util.List;

import com.hx.attrHandler.attrHandler.adapter.MultiArgsAttrHandler;
import com.hx.attrHandler.attrHandler.interf.AttrHandler;
import com.hx.attrHandler.util.Constants;

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
		this(Constants.CUTTING_DOOR_HANDLER_DEFAULT_CAP);
	}
	
	@Override
	protected String handle0(String result) {
		for(AttrHandler handler : handlers) {
			if(Constants.FALSE.equals(handler.handle(result)) ) {
				return Constants.FALSE;
			}
		}
		
		return Constants.TRUE;
	}
	
	@Override
	public String name() {
		return Constants.CUTTING_OUT_AND;
	}
	
}
