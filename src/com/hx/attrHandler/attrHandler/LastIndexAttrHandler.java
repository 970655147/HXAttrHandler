/**
 * file name : IndexAttrHandler.java
 * created at : 1:12:29 PM Mar 22, 2016
 * created by 970655147
 */

package com.hx.attrHandler.attrHandler;

import com.hx.attrHandler.attrHandler.adapter.interf.OneOrTwoStringIntArgsAttrHandler;
import com.hx.attrHandler.util.HXAttrHandlerConstants;

// lastIndexOf关联的AttrHandler
// map(lastIndexOf(hello[, 2]) )
public class LastIndexAttrHandler extends OneOrTwoStringIntArgsAttrHandler {
	// 初始化
	public LastIndexAttrHandler(String target, String idxStr, int from) {
		super(target, idxStr, from);
	}
	public LastIndexAttrHandler(String target, String idxStr) {
		this(target, idxStr, HXAttrHandlerConstants.TARGET_UNDEFINED);
	}
	public LastIndexAttrHandler(String idxStr, int from) {
		super(HXAttrHandlerConstants.HANDLER_UNDEFINED, idxStr, from);
	}
	public LastIndexAttrHandler(String idxStr) {
		this(HXAttrHandlerConstants.HANDLER_UNDEFINED, idxStr, HXAttrHandlerConstants.TARGET_UNDEFINED);
	}
	public LastIndexAttrHandler() {
		this(HXAttrHandlerConstants.HANDLER_UNDEFINED, "", HXAttrHandlerConstants.TARGET_UNDEFINED);
	}
	
	@Override
	public String name() {
		return HXAttrHandlerConstants.LAST_INDEX_OF;
	}
	
	@Override
	protected String gotResult(String target, String idxStr, int from, String result) {
		if(from == HXAttrHandlerConstants.TARGET_UNDEFINED) {
			from = target.length();
		}
		return String.valueOf(target.lastIndexOf(idxStr, from) );
	}
	
}
