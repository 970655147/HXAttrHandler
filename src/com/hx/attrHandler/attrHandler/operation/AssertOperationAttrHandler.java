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

// assertHandler
// 注意 ： 请将结果原样返回
public class AssertOperationAttrHandler extends OperationAttrHandler {
	// 组合的核心业务的handler
	private AttrHandler handler;
	
	// 初始化
	public AssertOperationAttrHandler(AttrHandler handler, Types operationReturn ) {
		super();
		this.handler = handler;
		operationType(HXAttrHandlerConstants.ASSERT_OPERATION);
		operationReturn(operationReturn);
	}

	// 注意 ： 不能改变结果
	@Override
	protected String handle0(String result) {
		boolean bool = Boolean.parseBoolean(handler.handle(result) );
		assertFalse(! bool);
		if(assertFalse() ) {
			returnMsg("assertedFalse while handle : '" + result + "', assertHandler : " + handler.toString() );
		}
		return result;
	}

	@Override
	public String name() {
		return HXAttrHandlerConstants.ASSERT_OPERATION;
	}

}
