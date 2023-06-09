/**
 * file name : MapOperationAttrHandler.java
 * created at : 12:28:38 PM Mar 26, 2016
 * created by 970655147
 */

package com.hx.attr_handler.attr_handler.operation;

import com.hx.attr_handler.attr_handler.interf.AttrHandler;
import com.hx.attr_handler.attr_handler.operation.interf.OperationAttrHandler;
import com.hx.attr_handler.util.AttrHandlerConstants;
import com.hx.attr_handler.attr_handler.StandardHandlerParser;

// filterHandler
// 注意 ： 请将结果原样返回
public class FilterOperationAttrHandler extends OperationAttrHandler {
	// 组合的核心业务的handler
	private AttrHandler handler;
	
	// 初始化
	public FilterOperationAttrHandler(AttrHandler handler, StandardHandlerParser.Types operationReturn ) {
		super();
		this.handler = handler;
		operationType(AttrHandlerConstants.FILTER_OPERATION);
		operationReturn(operationReturn);
	}

	// 注意 ： 不能改变结果
	@Override
	protected String handle0(String result) {
		boolean bool = Boolean.parseBoolean(handler.handle(result) );
		beFiltered(bool);
		if(beFiltered() ) {
			returnMsg("beFiltered while handle : '" + result + "', filterHandler : " + handler.toString() );
			return "beFiltered";
		}
		return result;
	}

	@Override
	public String name() {
		return AttrHandlerConstants.FILTER_OPERATION;
	}

}
