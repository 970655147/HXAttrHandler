/**
 * file name : IndexAttrHandler.java
 * created at : 1:12:29 PM Mar 22, 2016
 * created by 970655147
 */

package com.hx.attr_handler.attr_handler;

import com.hx.attr_handler.attr_handler.adapter.interf.OneOrTwoStringIntArgsAttrHandler;
import com.hx.attr_handler.util.AttrHandlerConstants;

// lastIndexOf关联的AttrHandler
// map(lastIndexOf(hello[, 2]) )
public class LastIndexAttrHandler extends OneOrTwoStringIntArgsAttrHandler {
	// 初始化
	public LastIndexAttrHandler(String target, String idxStr, int from) {
		super(target, idxStr, from);
	}
	public LastIndexAttrHandler(String target, String idxStr) {
		this(target, idxStr, AttrHandlerConstants.TARGET_UNDEFINED);
	}
	public LastIndexAttrHandler(String idxStr, int from) {
		super(AttrHandlerConstants.HANDLER_UNDEFINED, idxStr, from);
	}
	public LastIndexAttrHandler(String idxStr) {
		this(AttrHandlerConstants.HANDLER_UNDEFINED, idxStr, AttrHandlerConstants.TARGET_UNDEFINED);
	}
	public LastIndexAttrHandler() {
		this(AttrHandlerConstants.HANDLER_UNDEFINED, "", AttrHandlerConstants.TARGET_UNDEFINED);
	}
	
	@Override
	public String name() {
		return AttrHandlerConstants.LAST_INDEX_OF;
	}
	
	@Override
	protected String gotResult(String target, String idxStr, int from, String result) {
		if(from == AttrHandlerConstants.TARGET_UNDEFINED) {
			from = target.length();
		}
		return String.valueOf(target.lastIndexOf(idxStr, from) );
	}
	
}
