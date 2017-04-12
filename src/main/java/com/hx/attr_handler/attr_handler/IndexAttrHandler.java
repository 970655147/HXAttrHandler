/**
 * file name : IndexAttrHandler.java
 * created at : 1:12:29 PM Mar 22, 2016
 * created by 970655147
 */

package com.hx.attr_handler.attr_handler;

import com.hx.attr_handler.attr_handler.adapter.interf.OneOrTwoStringIntArgsAttrHandler;
import com.hx.attr_handler.util.HXAttrHandlerConstants;

// indexOf关联的AttrHandler
// map(indexOf(hello[, 2]) )
public class IndexAttrHandler extends OneOrTwoStringIntArgsAttrHandler {
	// 初始化
	public IndexAttrHandler(String target, String idxStr, int from) {
		super(target, idxStr, from);
	}
	public IndexAttrHandler(String target, String idxStr) {
		this(target, idxStr, HXAttrHandlerConstants.TARGET_UNDEFINED);
	}
	public IndexAttrHandler(String idxStr, int from) {
		super(HXAttrHandlerConstants.HANDLER_UNDEFINED, idxStr, from);
	}
	public IndexAttrHandler(String idxStr) {
		this(HXAttrHandlerConstants.HANDLER_UNDEFINED, idxStr, HXAttrHandlerConstants.TARGET_UNDEFINED);
	}
	public IndexAttrHandler() {
		this(HXAttrHandlerConstants.HANDLER_UNDEFINED, "", HXAttrHandlerConstants.TARGET_UNDEFINED);
	}
	
	@Override
	public String name() {
		return HXAttrHandlerConstants.INDEX_OF;
	}
	
	@Override
	protected String gotResult(String target, String idxStr, int from, String result) {
		if(from == HXAttrHandlerConstants.TARGET_UNDEFINED) {
			from = 0;
		}
		return String.valueOf(target.indexOf(idxStr, from) );
	}
	
}
