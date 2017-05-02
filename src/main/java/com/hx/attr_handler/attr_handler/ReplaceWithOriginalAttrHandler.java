/**
 * file name : ConcateAttrHandler.java
 * created at : 1:09:46 PM Mar 22, 2016
 * created by 970655147
 */

package com.hx.attr_handler.attr_handler;

import com.hx.attr_handler.attr_handler.adapter.interf.TwoOrThreeStringArgsAttrHandler;
import com.hx.attr_handler.util.AttrHandlerConstants;
import com.hx.common.util.InnerTools;

// ���������ַ����滻ΪĿ���ַ���
// map(replaceO(src, tar) )
public class ReplaceWithOriginalAttrHandler extends TwoOrThreeStringArgsAttrHandler {
	// ��ʼ��
	public ReplaceWithOriginalAttrHandler(String target, String regex, String replacement) {
		super(target, regex, replacement);
	}
	public ReplaceWithOriginalAttrHandler(String regex, String replacement) {
		super(AttrHandlerConstants.HANDLER_UNDEFINED, regex, replacement);
	}
	public ReplaceWithOriginalAttrHandler() {
		this(AttrHandlerConstants.HANDLER_UNDEFINED, AttrHandlerConstants.HANDLER_UNDEFINED, AttrHandlerConstants.HANDLER_UNDEFINED);
	}

	@Override
	public String name() {
		return AttrHandlerConstants.REPLACE_WITH_ORIGINAL;
	}
	
	@Override
	protected String gotResult(String target, String pattern, String replacement, String result) {
		return replaceO(target, pattern, replacement);
	}

	/**
	 * @param str �������ַ���
	 * @param src ��Ҫ�滻��ԭ�ַ���
	 * @param dst �滻����Ŀ���ַ���
	 * @return the replaced result
	 * @Name: replaceO
	 * @Description: �滻�������ַ���ΪĿ���ַ���
	 * Ϊ������HXAttrHandler.replaceO[replaceOriginal]�����
	 * @Create at 2016-09-30 21:51:15 by '970655147'
	 */
	private static String replaceO(String str, String src, String dst) {
		InnerTools.assert0(str != null, "'str' can't be null !");
		InnerTools.assert0(src != null, "'src' can't be null !");
		InnerTools.assert0(dst != null, "'dst' can't be null !");

		StringBuilder sb = new StringBuilder(str.length());
		int idx = 0;
		while (idx >= 0) {
			int nextSrc = str.indexOf(src, idx);
			if (nextSrc >= 0) {
				sb.append(str.substring(idx, nextSrc));
				sb.append(dst);
				idx = nextSrc + src.length();
			} else {
				sb.append(str.substring(idx));
				idx = -1;
			}
		}

		return sb.toString();
	}

}
