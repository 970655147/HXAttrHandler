/**
 * file name : CompositeOperationAttrHandler.java
 * created at : 12:06:21 PM Mar 26, 2016
 * created by 970655147
 */

package com.hx.attr_handler.attr_handler.operation;

import java.util.List;

import com.hx.attr_handler.attr_handler.operation.interf.MultiArgsOperationAttrHandler;
import com.hx.attr_handler.attr_handler.operation.interf.OperationAttrHandler;
import com.hx.attr_handler.util.AttrHandlerConstants;
import com.hx.attr_handler.attr_handler.StandardHandlerParser;

// ����OperationAttrHandler��AttrHandler
public class CompositeOperationAttrHandler<T extends OperationAttrHandler> extends MultiArgsOperationAttrHandler<T> {
	// ��ʼ��
	public CompositeOperationAttrHandler(List<T> handlerChain) {
		super(handlerChain);
		operationType(AttrHandlerConstants.OPERATION_COMPOSITE);
	}
	public CompositeOperationAttrHandler(int initCap) {
		super(initCap);
		operationType(AttrHandlerConstants.OPERATION_COMPOSITE);
	}
	public CompositeOperationAttrHandler() {
		this(AttrHandlerConstants.COMPOSITE_HANDLER_DEFAULT_CAP);
	}
	
	// ��ȡ���һ��OperationAttrHandler
	public StandardHandlerParser.Types lastReturnType() {
		if((handlers == null) || (handlers.size() == 0) ) {
			return StandardHandlerParser.Types.String;
		}
		
		return handlers.get(handlers.size()-1).operationReturn();
	}
	
	@Override
	public String handle0(String result) {
		String res = result;
		for(OperationAttrHandler handler : handlers) {
			res = handler.handle(res);
			if(handler.immediateReturn() ) {
				updateImmediateReturnFlag(handler);
				returnMsg(handler.returnMsg() );
				return returnMsg;
			}
		}
		
		return res;
	}
	
	@Override
	public String name() {
		return AttrHandlerConstants.OPERATION_COMPOSITE;
	}
}
