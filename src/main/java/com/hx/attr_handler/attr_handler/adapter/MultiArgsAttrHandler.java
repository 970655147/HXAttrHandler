/**
 * file name : MultiArgsAttrHandler.java
 * created at : 6:53:12 PM Mar 24, 2016
 * created by 970655147
 */

package com.hx.attr_handler.attr_handler.adapter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.hx.attr_handler.attr_handler.interf.AttrHandler;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.hx.attr_handler.util.HXAttrHandlerConstants;

// ����˶��Handler��AttrHandler
public abstract class MultiArgsAttrHandler<T extends AttrHandler> extends AttrHandler {
	
	// ������handler����
	protected List<T> handlers;
	
	// ��ʼ��
	public MultiArgsAttrHandler(List<T> handlers) {
		this.handlers = handlers;
	}
	public MultiArgsAttrHandler(int initCap) {
		this.handlers = new ArrayList<>(initCap);
	}
	public MultiArgsAttrHandler() {
		this(HXAttrHandlerConstants.CONCATE_HANDLER_DEFAULT_CAP);
	}
	
	// ���handler
	public void addHandler(T handler) {
		this.handlers.add(handler);
	}
	// ��ȡhandler
	public AttrHandler handler(int idx) {
		if((handlers == null) || (idx < 0) || (idx >= handlers.size()) ) {
			return null;
		}
		
		return handlers.get(idx);
	}
	public List<T> handlers() {
		return Collections.unmodifiableList(handlers);
	}
	public AttrHandler removeHandler(int idx) {
		if((handlers == null) || (idx < 0) || (idx >= handlers.size()) ) {
			return null;
		}
		
		return handlers.remove(idx);
	}
	
	@Override
	public String toString() {
		JSONArray arr = new JSONArray();
		for(AttrHandler handler : handlers) {
			arr.add(handler.toString() );
		}
		return new JSONObject().element("name", name() ).element("operands", arr.toString() ).toString();
	}
	
}
