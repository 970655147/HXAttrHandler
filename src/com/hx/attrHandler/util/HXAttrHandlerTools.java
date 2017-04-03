/**
 * file name : Tools.java
 * created at : 6:58:34 PM Jul 25, 2015
 * created by 970655147
 */

package com.hx.attrHandler.util;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

// ������
public final class HXAttrHandlerTools {
	
	// disable constructor
	private HXAttrHandlerTools() {
		HXAttrHandlerTools.assert0("can't instantiate !");
	}
	
	// ------------ assert��� ------- 2016.03.22 -------------
	// ���߷���
	// ȷ��booΪtrue, ���� �׳��쳣
	public static void assert0(String msg) {
		assert0(false, msg);
	}
	public static void assert0(boolean boo, String msg) {
		if(msg == null) {
			System.err.println("'msg' can't be null ");
			return ;
		}
		if(! boo) {
			throw new RuntimeException("assert0Exception : " + msg);
		}
	}
	// add at 2016.05.02
	public static void assert0(Exception e) {
		assert0(false, e);
	}
	public static void assert0(boolean boo, Exception e) {
		HXAttrHandlerTools.assert0(e != null, "'e' can't be null ");
		if(! boo) {
			throw new RuntimeException(e);
		}
	}
	// ȷ��val ��expected��ͬ, ���� �׳��쳣
	public static void assert0(int val, int expect, String errorMsg) {
		assert0(val, expect, true, errorMsg);
	}
	public static void assert0(int val, int expect, boolean isEquals, String errorMsg) {
		if(isEquals ^ (val == expect)) {
			String symbol = null;
			if(isEquals) {
				symbol = "!=";
			} else {
				symbol = "==";
			}
			assert0("assert0Exception : " + val + " " + symbol + ", expected : " + expect + ", MSG : " + errorMsg);
		}
	}
	public static <T> void assert0(T val, T expect, String errorMsg) {
		assert0(val, expect, true, errorMsg);
	}
	public static <T> void assert0(T val, T expect, boolean isEquals, String errorMsg) {
		if(val == null) {
			if(expect != null) {
				assert0("assert0Exception : " + val + " == null, expected : " + expect + ", MSG : " + errorMsg);
			}
		}
		if(isEquals ^ (val.equals(expect)) ) {
			String symbol = null;
			if(isEquals) {
				symbol = "!=";
			} else {
				symbol = "==";
			}
			assert0("assert0Exception : " + String.valueOf(val) + " " + symbol + " " + String.valueOf(expect) + ", expected : " + String.valueOf(expect) + ", MSG : " + errorMsg );
		}
	}
	
	// ��ȡstr����start ��end֮����ַ���
	public static String getStrInRange(String str, String start, String end) {
		return getStrInRange(str, start, end, false, false);
	}
	public static String getStrInRangeInclude(String str, String start, String end) {
		return getStrInRange(str, start, end, true, true);
	}
	public static String getStrInRangeWithStart(String str, String start) {
		return getStrInRangeWithStart(str, start, false);
	}
	public static String getStrInRangeWithStartInclude(String str, String start) {
		return getStrInRangeWithStart(str, start, true);
	}
	public static String getStrInRangeWithEnd(String str, String end) {
		return getStrInRangeWithEnd(str, end, false);
	}
	public static String getStrInRangeWithEndInclude(String str, String end) {
		return getStrInRangeWithEnd(str, end, true);
	}
	public static String getStrInRange(String str, String start, String end, boolean includeStart, boolean includeEnd) {
		HXAttrHandlerTools.assert0(str != null, "'str' can't be null ");
		HXAttrHandlerTools.assert0(start != null, "'start' can't be null ");
		HXAttrHandlerTools.assert0(end != null, "'end' can't be null ");
		
		int startIdx = str.indexOf(start);
		if(startIdx == -1) {
			return HXAttrHandlerConstants.EMPTY_STR;
		}
		
		int endIdx = str.indexOf(end, startIdx + start.length());
		if(endIdx == -1) {
			return HXAttrHandlerConstants.EMPTY_STR;
		}
		
		if(! includeStart) {
			startIdx += start.length();
		}
		if(includeEnd) {
			endIdx += end.length();
		}
		
		return str.substring(startIdx, endIdx);
	}
	public static String getStrInRangeWithStart(String str, String start, boolean include) {
		HXAttrHandlerTools.assert0(str != null, "'str' can't be null ");
		HXAttrHandlerTools.assert0(start != null, "'start' can't be null ");
		
		int idx = str.indexOf(start);
		if(idx != -1) {
			if(! include) {
				idx += start.length();
			}
			return str.substring(idx);
		}
		
		return HXAttrHandlerConstants.EMPTY_STR;
	}
	public static String getStrInRangeWithEnd(String str, String end, boolean include) {
		HXAttrHandlerTools.assert0(str != null, "'str' can't be null ");
		HXAttrHandlerTools.assert0(end != null, "'end' can't be null ");
		
		int idx = str.indexOf(end);
		if(idx != -1) {
			if(include) {
				idx += end.length();
			}
			return str.substring(0, idx);
		}
		
		return HXAttrHandlerConstants.EMPTY_STR;
	}
	
	// �ո����ַ�
	static Set<Character> spaces = new HashSet<>();
	static {
		spaces.add(HXAttrHandlerConstants.SPACE);
		spaces.add(HXAttrHandlerConstants.TAB);
		spaces.add(HXAttrHandlerConstants.CR);
		spaces.add(HXAttrHandlerConstants.LF);
	}
	
	// ���ַ����Ķ�������Ŀո�ת��Ϊһ���ո�
	// ˼· : ���strΪnull  ֱ�ӷ���null
	// ��str�ж�����ڵĿո��滻Ϊһ���ո�[SPACE]
	// ���������ַ�������Ϊ1 ���Ҹ��ַ�Ϊ�ո�, ��ֱ�ӷ��ؿ��ַ���
	// ����  ȥ��ǰ��Ŀո�, ����֮������ַ���
	// ����ֱ��ʹ��������д���		// str.replaceAll("\\s+", " ");
	public static String trimSpacesAsOne(String str) {
		if(isEmpty(str) ) {
			return HXAttrHandlerConstants.EMPTY_STR;
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<str.length(); i++) {
			if(spaces.contains(str.charAt(i)) ) {
				sb.append(HXAttrHandlerConstants.SPACE);
				int nextI = i+1;
				while((nextI < str.length() ) && spaces.contains(str.charAt(nextI)) ) nextI++ ;
				i = nextI - 1;
				continue ;
			}
			sb.append(str.charAt(i) );
		}
		
		if((sb.length() == 0) || ((sb.length() == 1) && spaces.contains(sb.charAt(0))) ) {
			return HXAttrHandlerConstants.EMPTY_STR;
		} else {
			int start = 0, end = sb.length();
			if(spaces.contains(sb.charAt(start)) ) {
				start ++;
			}
			if(spaces.contains(sb.charAt(end-1)) ) {
				end --;
			}
			
			return sb.substring(start, end);
		}
	}
	public static String[] trimSpacesAsOne(String[] arr) {
		HXAttrHandlerTools.assert0(arr != null, "'arr' can't be null ");
		for(int i=0; i<arr.length; i++) {
			arr[i] = trimSpacesAsOne(arr[i]);
		}
		
		return arr;
	}
	public static List<String> trimSpacesAsOne(List<String> arr) {
		HXAttrHandlerTools.assert0(arr != null, "'arr' can't be null ");
		for(int i=0; i<arr.size(); i++) {
			arr.set(i, trimSpacesAsOne(arr.get(i)) );
		}
		
		return arr;
	}

	public static String trimAllSpaces(String str, Map<Character, Character> escapeMap) {
		if(isEmpty(str) ) {
			return HXAttrHandlerConstants.EMPTY_STR;
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<str.length(); i++) {
			Character ch = str.charAt(i);
			if((escapeMap != null ) && escapeMap.containsKey(ch) ) {
				int prevI = i;
				i = str.indexOf(escapeMap.get(ch), i+1);
				if(i >= 0) {
					sb.append(str.substring(prevI, i+1) );
				} else {
					sb.append(str.substring(prevI) );
					break ;
				}
				continue ;
			}
			if(spaces.contains(str.charAt(i)) ) {
				int nextI = i+1;
				while((nextI < str.length() ) && spaces.contains(str.charAt(nextI)) ) nextI++ ;
				i = nextI - 1;
				continue ;
			}
			sb.append(str.charAt(i) );
		}
		return sb.toString();
	}
	public static String trimAllSpaces(String str) {
		return trimAllSpaces(str, null);
	}
	public static String[] trimAllSpaces(String[] arr, Map<Character, Character> escapeMap) {
		HXAttrHandlerTools.assert0(arr != null, "'arr' can't be null ");
		for(int i=0; i<arr.length; i++) {
			arr[i] = trimAllSpaces(arr[i], escapeMap);
		}
		
		return arr;
	}
	public static String[] trimAllSpaces(String[] arr) {
		return trimAllSpaces(arr, null);
	}
	public static List<String> trimAllSpaces(List<String> arr, Map<Character, Character> escapeMap) {
		HXAttrHandlerTools.assert0(arr != null, "'arr' can't be null ");
		for(int i=0; i<arr.size(); i++) {
			arr.set(i, trimAllSpaces(arr.get(i), escapeMap) );
		}
		
		return arr;
	}
	public static List<String> trimAllSpaces(List<String> arr) {
		return trimAllSpaces(arr, null);
	}
	
	// ����ַ���Ϊһ���ַ���, ������Ϊ���ַ���
	static Set<String> emptyStrCondition = HXAttrHandlerConstants.emptyStrCondition;
	
	
	// �ж��ַ����Ƿ�Ϊ��[null, "", "null"]
	public static boolean isEmpty(String str) {
		return (str == null) || emptyStrCondition.contains(str.trim());
	}
	public static <T> boolean isEmpty(Collection<T> arr) {
		return (arr == null) || (arr.size() == 0);
	}
	public static <K, V> boolean isEmpty(Map<K, V> map) {
		return (map == null) || (map.size() == 0);
	}
	
   // ------------ ���� --------------------

	
}
