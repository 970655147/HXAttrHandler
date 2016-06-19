/**
 * file name : MapOperationAttrHandler.java
 * created at : 12:28:38 PM Mar 26, 2016
 * created by 970655147
 */

package com.hx.attrHandler.attrHandler.operation;

import com.hx.attrHandler.attrHandler.StandardHandlerParser.Types;
import com.hx.attrHandler.attrHandler.interf.AttrHandler;
import com.hx.attrHandler.attrHandler.operation.interf.OperationAttrHandler;
import com.hx.attrHandler.util.HXAttrHandlerConstants;

// mapHandler
public class MapOperationAttrHandler extends OperationAttrHandler {
	// 组合的核心业务的handler
	private AttrHandler handler;
	
	// 初始化
	public MapOperationAttrHandler(AttrHandler handler, Types operationReturn ) {
		super();
		this.handler = handler;
		operationType(HXAttrHandlerConstants.MAP_OPERATION);
		operationReturn(operationReturn);
	}

	@Override
	protected String handle0(String result) {
		return handler.handle(result);
	}

	@Override
	public String name() {
		return HXAttrHandlerConstants.MAP_OPERATION;
	}

}
