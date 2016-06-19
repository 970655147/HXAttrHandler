/**
 * file name : GetStrInRangeHandler.java
 * created at : 11:49:20 PM May 20, 2016
 * created by 970655147
 */

package com.hx.attrHandler.attrHandler;

import com.hx.attrHandler.attrHandler.adapter.interf.TwoOrThreeStringTwoBooleanArgsAttrHandler;
import com.hx.attrHandler.util.HXAttrHandlerConstants;
import com.hx.attrHandler.util.HXAttrHandlerTools;

// getStrIn('hello', 'e', 'o')
public class GetStrInRangeHandler extends TwoOrThreeStringTwoBooleanArgsAttrHandler  {

	// ≥ı ºªØ
	public GetStrInRangeHandler(String target, String start, String end, boolean includeStart, boolean includeEnd) {
		super(target, start, end, includeStart, includeEnd);
	}
	public GetStrInRangeHandler(String start, String end, boolean includeStart, boolean includeEnd) {
		this(HXAttrHandlerConstants.HANDLER_UNDEFINED, start, end, includeStart, includeEnd);
	}
	public GetStrInRangeHandler(String target, String start, String end) {
		this(target, start, end, false, false);
	}
	public GetStrInRangeHandler(String start, String end) {
		this(HXAttrHandlerConstants.HANDLER_UNDEFINED, start, end, false, false);
	}
	public GetStrInRangeHandler() {
		this(HXAttrHandlerConstants.HANDLER_UNDEFINED, HXAttrHandlerConstants.HANDLER_UNDEFINED, HXAttrHandlerConstants.HANDLER_UNDEFINED, false, false);
	}

	@Override
	protected String gotResult(String target, String start, String end, boolean includeStart, boolean includeEnd, String result) {
		return HXAttrHandlerTools.getStrInRange(target, start, end, includeStart, includeEnd);
	}

	@Override
	public String name() {
		return HXAttrHandlerConstants.GET_STR_IN_RANGE;
	}

}
