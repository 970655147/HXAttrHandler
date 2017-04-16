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

// assertHandler
// ע�� �� �뽫���ԭ������
public class AssertOperationAttrHandler extends OperationAttrHandler {
	// ��ϵĺ���ҵ���handler
	private AttrHandler handler;
	
	// ��ʼ��
	public AssertOperationAttrHandler(AttrHandler handler, StandardHandlerParser.Types operationReturn ) {
		super();
		this.handler = handler;
		operationType(AttrHandlerConstants.ASSERT_OPERATION);
		operationReturn(operationReturn);
	}

	// ע�� �� ���ܸı���
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
		return AttrHandlerConstants.ASSERT_OPERATION;
	}

}
