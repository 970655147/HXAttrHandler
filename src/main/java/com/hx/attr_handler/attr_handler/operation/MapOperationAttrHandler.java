/**
 * file name : MapOperationAttrHandler.java
 * created at : 12:28:38 PM Mar 26, 2016
 * created by 970655147
 */

package com.hx.attr_handler.attr_handler.operation;

import com.hx.attr_handler.attr_handler.StandardHandlerParser.Types;
import com.hx.attr_handler.attr_handler.interf.AttrHandler;
import com.hx.attr_handler.attr_handler.operation.interf.OperationAttrHandler;
import com.hx.attr_handler.util.AttrHandlerConstants;

// mapHandler
public class MapOperationAttrHandler extends OperationAttrHandler {
	// 组合的核心业务的handler
	private AttrHandler handler;
	
	// 初始化
	public MapOperationAttrHandler(AttrHandler handler, Types operationReturn ) {
		super();
		this.handler = handler;
		operationType(AttrHandlerConstants.MAP_OPERATION);
		operationReturn(operationReturn);
	}

	@Override
	protected String handle0(String result) {
		return handler.handle(result);
	}

	@Override
	public String name() {
		return AttrHandlerConstants.MAP_OPERATION;
	}

}
