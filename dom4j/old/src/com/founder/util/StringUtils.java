package com.founder.util;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class StringUtils extends org.apache.commons.lang.StringUtils {

	private static Log log = LogFactory.getLog(StringUtils.class);

	// XML special character
	private static final String QUOT_ENCODE = "&quot;"; // "
	private static final String AMP_ENCODE = "&amp;"; // &
	private static final String LT_ENCODE = "&lt;"; // <
	private static final String GT_ENCODE = "&gt;"; // >

	// Hex conversion.
	private static char hex[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };

	/**
	 * 去除字符串中的XML标志（如：<>&），使结果可以作为XML中内容
	 * 
	 * @param string
	 *            要操作的字符串
	 * 
	 * @return 去除XML标志的字符串
	 */
	public static final String escapeForXML(String string) {
		if (string == null) {
			return null;
		}
		char ch;
		char[] input = string.toCharArray();
		int len = input.length;
		if (len == 0) {
			return string;
		}
		StringBuffer out = new StringBuffer((int) (len * 1.3));
		for (int i = 0; i < len; i++) {
			ch = input[i];
			switch (ch) {
			case '<':
				out.append(LT_ENCODE);
				break;
			case '>':
				out.append(GT_ENCODE);
				break;
			case '"':
				out.append(QUOT_ENCODE);
				break;
			case '&':
				out.append(AMP_ENCODE);
				break;
			default:
				out.append(ch);
			}
		}
		return out.toString();
	}

	/**
	 * 反转字符串中的XML标志（如：&lt;等），使结果可以作为XML中内容
	 * 
	 * @param string
	 *            要操作的字符串
	 * 
	 * @return 反转XML标志的字符串
	 */
	public static final String unescapeFromXML(String string) {
		string = org.apache.commons.lang.StringUtils.replace(string, LT_ENCODE,"<");
		string = org.apache.commons.lang.StringUtils.replace(string, GT_ENCODE,">");
		string = org.apache.commons.lang.StringUtils.replace(string,QUOT_ENCODE, "\"");
		return org.apache.commons.lang.StringUtils.replace(string, AMP_ENCODE,"&");
	}

	public static String filterForHTMLValue(String _sContent) {
		if (_sContent == null)
			return "";
		char srcBuff[] = _sContent.toCharArray();
		int nLen = srcBuff.length;
		if (nLen == 0)
			return "";
		StringBuffer retBuff = new StringBuffer((int) ((double) nLen * 1.8D));
		for (int i = 0; i < nLen; i++) {
			char cTemp = srcBuff[i];
			switch (cTemp) {
			case 38: // '&'
				if (i + 1 < nLen) {
					cTemp = srcBuff[i + 1];
					if (cTemp == '#')
						retBuff.append("&");
					else
						retBuff.append("&amp;");
				} else {
					retBuff.append("&amp;");
				}
				break;
			case 60: // '<'
				retBuff.append("&lt;");
				break;
			case 62: // '>'
				retBuff.append("&gt;");
				break;
			case 34: // '"'
				retBuff.append("&quot;");
				break;
			default:
				retBuff.append(cTemp);
				break;
			}
		}
		return retBuff.toString();
	}

	public static String filterForUrl(String _sContent) {
		if (_sContent == null)
			return "";
		char srcBuff[] = _sContent.toCharArray();
		int nLen = srcBuff.length;
		if (nLen == 0)
			return "";
		StringBuffer retBuff = new StringBuffer((int) ((double) nLen * 1.8D));
		for (int i = 0; i < nLen; i++) {
			char cTemp = srcBuff[i];
			switch (cTemp) {
			case 37: // '%'
				retBuff.append("%25");
				break;
			case 63: // '?'
				retBuff.append("%3F");
				break;
			case 35: // '#'
				retBuff.append("%23");
				break;
			case 38: // '&'
				retBuff.append("%26");
				break;
			case 32: // ' '
				retBuff.append("%20");
				break;
			default:
				retBuff.append(cTemp);
				break;
			}
		}
		return retBuff.toString();
	}

	public static String filterForJs(String _sContent) {
		if (_sContent == null)
			return "";
		char srcBuff[] = _sContent.toCharArray();
		int nLen = srcBuff.length;
		if (nLen == 0)
			return "";
		StringBuffer retBuff = new StringBuffer((int) ((double) nLen * 1.8D));
		for (int i = 0; i < nLen; i++) {
			char cTemp = srcBuff[i];
			switch (cTemp) {
			case 34: // '"'
				retBuff.append("\\\"");
				break;
			case 92: // '\\'
				retBuff.append("\\\\");
				break;
			case 10: // '\n'
				retBuff.append("\\n");
				break;
			case 13: // '\r'
				retBuff.append("\\r");
				break;
			case 47: // '/'
				retBuff.append("\\/");
				break;
			default:
				retBuff.append(cTemp);
				break;
			}
		}
		return retBuff.toString();
	}

	public static String filterForSQL(String _sContent) {
		if (_sContent == null)
			return "";
		int nLen = _sContent.length();
		if (nLen == 0)
			return "";
		char srcBuff[] = _sContent.toCharArray();
		StringBuffer retBuff = new StringBuffer((int) ((double) nLen * 1.5D));
		for (int i = 0; i < nLen; i++) {
			char cTemp = srcBuff[i];
			switch (cTemp) {
			case 39: // '\''
				retBuff.append("''");
				break;
			case 59: // ';'
				boolean bSkip = false;
				for (int j = i + 1; j < nLen && !bSkip; j++) {
					char cTemp2 = srcBuff[j];
					if (cTemp2 == ' ')
						continue;
					if (cTemp2 == '&')
						retBuff.append(';');
					bSkip = true;
				}
				if (!bSkip)
					retBuff.append(';');
				break;
			default:
				retBuff.append(cTemp);
				break;
			}
		}
		return retBuff.toString();
	}

	public static String filterForXML(String _sContent) {
		if (_sContent == null)
			return "";
		char srcBuff[] = _sContent.toCharArray();
		int nLen = srcBuff.length;
		if (nLen == 0)
			return "";
		StringBuffer retBuff = new StringBuffer((int) ((double) nLen * 1.8D));
		for (int i = 0; i < nLen; i++) {
			char cTemp = srcBuff[i];
			switch (cTemp) {
			case 38: // '&'
				retBuff.append("&amp;");
				break;
			case 60: // '<'
				retBuff.append("&lt;");
				break;
			case 62: // '>'
				retBuff.append("&gt;");
				break;
			case 34: // '"'
				retBuff.append("&quot;");
				break;
			case 39: // '\''
				retBuff.append("&apos;");
				break;
			default:
				retBuff.append(cTemp);
				break;
			}
		}
		return retBuff.toString();
	}

	/**
	 * 测试字符串的实际长度 （中文算两个字符）
	 * 
	 * @param string
	 *            要进行计算的源字符串
	 * 
	 * @return 字符串的实际长度
	 */
	public static final int getChineseStringLenght(String string) {
		int fLen = 0; // 字符串的伪长度
		int tLen = 0; // 字符串的真实长度
		int i = 0;
		if (string == null || string.equals("")) {
			tLen = 0;
		} else {
			fLen = string.length();
			for (i = 0; i < fLen; i++) {
				if ((int) string.charAt(i) > 255) {
					tLen += 2;
				} else {
					tLen++;
				}
			}
		}
		return tLen;
	}

	/**
	 * 取得字符串的前几个字符 （中文算两个字符）
	 * 
	 * @param string
	 *            要操作的源字符串
	 * @param len
	 *            要取出的字符串的长度
	 * 
	 * @return 最终取出的子字符串
	 */
	public static final String getFirstChineseString(String string, int len) {
		int fLen = 0; // 字符串的伪长度
		int tLen = 0; // 字符串的真实长度
		if (getChineseStringLenght(string) < len) {
			return string;
		} else {
			while (tLen < len) {
				if ((int) string.charAt(fLen) > 255)
					tLen += 2;
				else
					tLen++;
				if (tLen <= len)
					fLen++;
			}
			return org.apache.commons.lang.StringUtils.substring(string, fLen);
		}
	}

	/**
	 * 返回字符串的前几个字符
	 * 
	 * @param string
	 *            源字符串
	 * @param len
	 *            取出字符的个数
	 * 
	 * @return 指定的部分字符串
	 */
	public static final String getFirstString(String string, int len) {
		if (string == null) {
			return null;
		}
		if (string.equals("") || len <= 0) {
			return "";
		}
		if (string.length() <= len) {
			return string;
		}else {
			return string.substring(0, len);
		}
	}

	/**
	 * 判断两个字符串是否相等(如果都是null也认为是相等的)
	 * 
	 * @param s1
	 *            第一个字符串
	 * @param s2
	 *            第二个字符串
	 * 
	 * @return 两个字符串相等返回true,否则返回false
	 */
	public static final boolean isEquals(String s1, String s2) {
		if (s1 == null && s2 == null) {
			return true;
		}
		if ((s1 == null && s2 != null) || (s1 != null && s2 == null)) {
			return false;
		}
		if (!s1.equals(s2)) {
			return false;
		}

		return true;
	}

	/**
	 * 判断两个字符串数组是否相等
	 * 
	 * @param s1
	 *            第一个字符串数组
	 * @param s2
	 *            第二个字符串数组
	 * 
	 * @return 是否相等
	 */
	public static boolean isEquals(String[] s1, String[] s2) {
		if (s1 == null && s2 == null) {
			return true;
		}
		if ((s1 == null && s2 != null) || (s1 != null && s2 == null)) {
			return false;
		}
		int len1 = s1.length;
		int len2 = s2.length;
		if (len1 != len2) {
			return false;
		}
		for (int i = 0; i < len1; i++) {
			if (!s1[i].equals(s2[i])) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 字符串替换函数,忽略大小写
	 * 
	 * @param line
	 *            要进行操作的字符串
	 * @param oldString
	 *            要替换掉的字符串
	 * @param newString
	 *            准备替换的字符串
	 * 
	 * @return 完成替换操作的字符串
	 */
	public static final String replaceIgnoreCase(String line, String oldString, String newString) {
		if (line == null) {
			return null;
		}
		if (oldString == null || newString == null) {
			return line;
		}
		if (oldString.equals("")) {
			return line;
		}
		String lcLine = line.toLowerCase();
		String lcOldString = oldString.toLowerCase();
		int i = 0;
		if ((i = lcLine.indexOf(lcOldString, i)) >= 0) {
			char[] line2 = line.toCharArray();
			char[] newString2 = newString.toCharArray();
			int oLength = oldString.length();
			StringBuffer buf = new StringBuffer(line2.length);
			buf.append(line2, 0, i).append(newString2);
			i += oLength;
			int j = i;
			while ((i = lcLine.indexOf(lcOldString, i)) > 0) {
				buf.append(line2, j, i - j).append(newString2);
				i += oLength;
				j = i;
			}
			buf.append(line2, j, line2.length - j);
			return buf.toString();
		}
		return line;
	}

	/**
	 * Replaces all instances of oldString with newString in line with the added
	 * feature that matches of newString in oldString ignore case. The count
	 * paramater is set to the number of replaces performed.
	 * 
	 * @param line
	 *            the String to search to perform replacements on
	 * @param oldString
	 *            the String that should be replaced by newString
	 * @param newString
	 *            the String that will replace all instances of oldString
	 * @param count
	 *            a value that will be updated with the number of replaces
	 *            performed.
	 * 
	 * @return a String will all instances of oldString replaced by newString
	 */
	public static final String replaceIgnoreCase(String line, String oldString,String newString, int[] count) {
		if (line == null) {
			return null;
		}
		String lcLine = line.toLowerCase();
		String lcOldString = oldString.toLowerCase();
		int i = 0;
		if ((i = lcLine.indexOf(lcOldString, i)) >= 0) {
			int counter = 0;
			char[] line2 = line.toCharArray();
			char[] newString2 = newString.toCharArray();
			int oLength = oldString.length();
			StringBuffer buf = new StringBuffer(line2.length);
			buf.append(line2, 0, i).append(newString2);
			i += oLength;
			int j = i;
			while ((i = lcLine.indexOf(lcOldString, i)) > 0) {
				counter++;
				buf.append(line2, j, i - j).append(newString2);
				i += oLength;
				j = i;
			}
			buf.append(line2, j, line2.length - j);
			count[0] = counter;
			return buf.toString();
		}
		return line;
	}

	/**
	 * 分割字符串，将结果放入List集合中，List容器中仍为String对象
	 * 
	 * @param s
	 *            要拆分的字符串
	 * @param delim
	 *            分割符号
	 * @return
	 */
	public static final List<String> split2List(String s, String delim) {
		StringTokenizer st = new StringTokenizer(s, delim);
		int count = st.countTokens();
		List<String> ret = new ArrayList<String>(count);
		for (int i = 0; st.hasMoreTokens(); i++)
			ret.add(st.nextToken());
		return ret;
	}

	/**
	 * 将16进制的字符串转换成byte数组
	 * 
	 * @param hex
	 *            16进制字符串
	 * 
	 * @return byte[] byte数组
	 */
	public static final byte[] toByteArray(String hex) {
		if (hex == null) {
			return null;
		}
		int len = hex.length();
		if (len == 0 || (len % 2) > 0) {
			return null;
		}
		byte[] result = new byte[len / 2];

		String tmp;
		int i = 0, j = 0;
		while (i < len) {
			tmp = hex.substring(i, i + 2);
			result[j] = (byte) Long.parseLong(tmp, 16);
			i += 2;
			j++;
		}
		return result;
	}

	/**
	 * 将byte数组转换成16进制的字符串
	 * 
	 * @param ba
	 *            byte数组
	 * 
	 * @return String 16进制的字符串
	 */
	public static final String toHex(byte[] ba) {
		if (ba == null) {
			return null;
		}
		int length = ba.length;
		if (length <= 0) {
			return "";
		}
		StringBuffer buf = new StringBuffer(length * 2);
		int i;
		for (i = 0; i < length; i++) {
			if (((int) ba[i] & 0XFF) < 0X10) {
				buf.append("0");
			}
			buf.append(Long.toString((int) ba[i] & 0XFF, 16));
		}
		return buf.toString();
	}

	public static int getBytesLength(String _string) {
		if (_string == null)
			return 0;
		char srcBuff[] = _string.toCharArray();
		int nGet = 0;
		for (int i = 0; i < srcBuff.length; i++) {
			char aChar = srcBuff[i];
			nGet += aChar > '\177' ? 2 : 1;
		}
		return nGet;
	}

	public static byte[] getUTF8Bytes(String _string) {
		char c[] = _string.toCharArray();
		int len = c.length;
		int count = 0;
		for (int i = 0; i < len; i++) {
			int ch = c[i];
			if (ch <= 127) {
				count++;
				continue;
			}
			if (ch <= 2047)
				count += 2;
			else
				count += 3;
		}
		byte b[] = new byte[count];
		int off = 0;
		for (int i = 0; i < len; i++) {
			int ch = c[i];
			if (ch <= 127) {
				b[off++] = (byte) ch;
				continue;
			}
			if (ch <= 2047) {
				b[off++] = (byte) (ch >> 6 | 0xc0);
				b[off++] = (byte) (ch & 0x3f | 0x80);
			} else {
				b[off++] = (byte) (ch >> 12 | 0xe0);
				b[off++] = (byte) (ch >> 6 & 0x3f | 0x80);
				b[off++] = (byte) (ch & 0x3f | 0x80);
			}
		}
		return b;
	}

	public static String getUTF8String(byte b[]) {
		return getUTF8String(b, 0, b.length);
	}

	public static String getUTF8String(byte b[], int off, int len) {
		int count = 0;
		int max = off + len;
		int i = off;
		do {
			if (i >= max)
				break;
			int c = b[i++] & 0xff;
			switch (c >> 4) {
			case 0: // '\0'
			case 1: // '\001'
			case 2: // '\002'
			case 3: // '\003'
			case 4: // '\004'
			case 5: // '\005'
			case 6: // '\006'
			case 7: // '\007'
				count++;
				break;
			case 12: // '\f'
			case 13: // '\r'
				if ((b[i++] & 0xc0) != 128)
					throw new IllegalArgumentException();
				count++;
				break;
			case 14: // '\016'
				if ((b[i++] & 0xc0) != 128 || (b[i++] & 0xc0) != 128)
					throw new IllegalArgumentException();
				count++;
				break;
			case 8: // '\b'
			case 9: // '\t'
			case 10: // '\n'
			case 11: // '\013'
			default:
				throw new IllegalArgumentException();
			}
		} while (true);
		if (i != max)
			throw new IllegalArgumentException();
		char cs[] = new char[count];
		i = 0;
		do {
			if (off >= max)
				break;
			int c = b[off++] & 0xff;
			switch (c >> 4) {
			case 0: // '\0'
			case 1: // '\001'
			case 2: // '\002'
			case 3: // '\003'
			case 4: // '\004'
			case 5: // '\005'
			case 6: // '\006'
			case 7: // '\007'
				cs[i++] = (char) c;
				break;

			case 12: // '\f'
			case 13: // '\r'
				cs[i++] = (char) ((c & 0x1f) << 6 | b[off++] & 0x3f);
				break;

			case 14: // '\016'
				int t = (b[off++] & 0x3f) << 6;
				cs[i++] = (char) ((c & 0xf) << 12 | t | b[off++] & 0x3f);
				break;

			case 8: // '\b'
			case 9: // '\t'
			case 10: // '\n'
			case 11: // '\013'
			default:
				throw new IllegalArgumentException();
			}
		} while (true);
		return new String(cs, 0, count);
	}

	public static String toISO_8859(String _strSrc) {
		if (_strSrc == null)
			return null;
		try {
			String s = new String(_strSrc.getBytes(), "ISO-8859-1");
			return s;
		} catch (Exception ex) {
			log.error(ex.getMessage());
			return _strSrc;
		}
	}

	public static String toUnicode(String _strSrc) {
		return toISO_8859(_strSrc);
	}

	/**
	 * Convert a byte buffer to a hex string.
	 * 
	 * @param buf
	 *            Byte array.
	 * @return Hexadecimal representation.
	 */
	public static String toHexString(byte[] buf) {
		StringBuffer sb = new StringBuffer();
		int buflen = buf.length;
		for (int i = 0; i < buflen; i++) {
			sb.append(hex[(buf[i] >>> 4) & 0xf]).append(hex[buf[i] & 0xf]);
		}
		return sb.toString();
	}

	/**
	 * 使用GBK对字符串进行编码
	 * 
	 * @param str
	 *            要操作的字符串
	 * 
	 * @return String 编码后的字符串
	 */
	public static final String unescapeString(String str) {
		return unescapeString(str, "GBK");
	}

	/**
	 * 按指定编码方式对字符串进行编码
	 * 
	 * @param str
	 *            要操作的字符串
	 * @param enc
	 *            编码方式
	 * 
	 * @return String 编码后的字符串
	 */
	public static final String unescapeString(String str, String enc) {
		if (str == null || str.equals("")) {
			return str;
		}
		int length = str.length();
		int bytelen = 0;
		byte[] bytes = new byte[length];
		int tempB1, tempB2;
		char tempChar;

		for (int i = 0; i < length; i++) {
			tempChar = str.charAt(i);
			if (tempChar == '+') {
				// 加号必须变为空格
				bytes[bytelen++] = ' ';
				continue;
			}
			if (tempChar == '%') {
				if (i + 1 == length)
					break;

				tempChar = str.charAt(++i);
				if (tempChar != 'u') {
					// 国标码
					tempB1 = Character.digit(tempChar, 16);
					tempChar = str.charAt(++i);
					tempB2 = Character.digit(tempChar, 16);
					bytes[bytelen++] = (byte) (tempB1 * 16 + tempB2);
				} else {
					// UNICODE码
					tempChar = str.charAt(++i);
					tempB1 = Character.digit(tempChar, 16);
					tempChar = str.charAt(++i);
					tempB1 = tempB1 * 16 + Character.digit(tempChar, 16);
					tempChar = str.charAt(++i);
					tempB1 = tempB1 * 16 + Character.digit(tempChar, 16);
					tempChar = str.charAt(++i);
					tempB1 = tempB1 * 16 + Character.digit(tempChar, 16);
					tempChar = (char) tempB1;
					byte[] tempbytes = null;
					try {
						tempbytes = ("" + tempChar).getBytes(enc);
					} catch (java.io.UnsupportedEncodingException f) {
						tempbytes = ("" + tempChar).getBytes();
					}
					bytes[bytelen++] = tempbytes[0];
					bytes[bytelen++] = tempbytes[1];
				}
			} else {
				bytes[bytelen++] = (byte) tempChar;
			}
		}
		if (bytelen < length) {
			byte[] trimValue = new byte[bytelen];
			System.arraycopy(bytes, 0, trimValue, 0, bytelen);
			bytes = trimValue;
		}
		try {
			return new String(bytes, enc);
		} catch (java.io.UnsupportedEncodingException ex) {
			return new String(bytes);
		}
	}

}
