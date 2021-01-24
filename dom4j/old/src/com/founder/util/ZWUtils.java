package com.founder.util;

import java.util.ArrayList;

public class ZWUtils {
	public ZWUtils() {
		super();
	}

	/**
	 * 樊敏浩加，用于藏文标题的分词处理 for 青海日报
	 * 
	 * @param title
	 *            未分词的文章标题
	 * @return 已经加上藏文分词标志的标题
	 */
	public static String parseZWWord(String title) {
		char szFD[] = { 0xA0, 0x0F0D, 0 }; // &nbsp;藏文分割符
		char t[] = { 0x0F0D }; // 藏文分割符
		ArrayList<String> arrayWord = new ArrayList<String>(); // 标题分词后存放地点
		StringBuffer resultBuffer = new StringBuffer(); // 结果存放
		try {
			// 将所有的"&nbsp;藏文分割符"替换为"藏文分割符"这种形式
			while (title.indexOf(String.valueOf(szFD)) > -1)
				title = title.replaceAll(String.valueOf(szFD), String
						.valueOf(t));

			int length = title.length(); // 得到标题长度

			if (length > 0) {
				if (!isZWTitle(title))
					return title;

				char[] titleChar = title.toCharArray();// string转换成char数组
				boolean isZWContent = isZWChar(titleChar[0]); // 判断第一个字符是否为藏文
				int loop = 0;
				while (titleChar != null)
				// aa循环判断
				{

					StringBuffer word = new StringBuffer(); // 单个词的存放缓冲区
					// 一直向前找,只到藏文分隔字母,中文或结束

					char c = titleChar[loop]; // 得到这个字符
					word.append(c); // 加入词缓冲区
					String moveStr = String.copyValueOf(titleChar, loop + 1,
							titleChar.length - loop - 1); // 将剩余字符拷入新字符串

					char[] lpszMove = moveStr.toCharArray(); // 构造新字符串的char数组
					int curPos = 0;
					if (isZWContent) // bb如果是藏文
					{
						for (curPos = 0; curPos < lpszMove.length; curPos++) //
						{
							char ch = lpszMove[curPos];
							if (isZWChar(ch)) // 如果字符是藏文
							{
								if ((ch == 0x0F0B) || (ch == 0x0F0D)) // 如果是藏文分割符
								{
									// 此处还要找是否存在连续的藏文分隔字母
									for (; curPos < lpszMove.length; curPos++) {

										char ch2 = lpszMove[curPos];
										if ((ch2 == 0x0F0B) || (ch2 == 0x0F0D)) { // 连续分隔符处理
											word.append(ch2);
											continue;
										} else {
											// 此处表示根据藏文分隔字母判断一个藏文单词已经结束了
											arrayWord.add(word.toString()); // 加入词列表缓冲
											word = word
													.delete(0, word.length()); // 清空词组
											break;
										}
									}
									break;
								} else // 不是分割符,是藏文的下一个字母
								{
									// 同一个藏文单词中的字母处理（非分隔字母）
									word.append(ch); // 加入词
								}
								continue;
							} else // 如果不是藏文
							{
								arrayWord.add(word.toString());// 将加好的藏文加入词表
								word = word.delete(0, word.length()); // 清空词组
								// 藏文单词处理完毕，现在转为中文环境
								break;
							}
						}
						if (curPos == lpszMove.length) // ????有问题
						{
							arrayWord.add(word.toString());
							word = word.delete(0, word.length()); // 清空词组
						}
					}// bb
					else // a不是藏文
					{ // 中文环境，直到藏文字母或0x00;
						for (curPos = 0; curPos < lpszMove.length; curPos++) {
							char ch = lpszMove[curPos]; // 取下一个
							if (isZWChar(ch)) { // 下一个是藏文字母,现在中文到此为止
								arrayWord.add(word.toString());
								word = word.delete(0, word.length()); // 清空词组
								break;
							} else {
								word.append(ch); // 还是非藏文，继续加入缓冲
								continue;
							}
						}
						// if( lpszMove[lpszMove.length-1] == 0x00) //？？？？有问题
						arrayWord.add(word.toString());
					}
					if (curPos < lpszMove.length) {
						isZWContent = isZWChar(lpszMove[curPos]);
						String tmp = String.copyValueOf(lpszMove, curPos,
								lpszMove.length - curPos); // 将剩余字符拷入新字符串
						titleChar = tmp.toCharArray(); // 构造新字符串的char数组
						loop = 0;
						continue;
					} else
						titleChar = null;
					loop++;
				}// aa
				// 分词完毕

				int iWordCount = arrayWord.size(); // 计算词的总数
				int nWordLen = 0;

				for (int i = 0; i < iWordCount; i++) {
					String word = (String) arrayWord.get(i);
					nWordLen += word.toCharArray().length; // 判断所有词的总字符数
				}
				if (nWordLen != length) // 如果和标题字符数不等，出现错误
				{
					throw new Exception("出现错误");
				}

				// 现在删除strText,将arrayWord中的各元素添加到文档中

				for (int i = 0; i < iWordCount; i++) {
					String word = (String) arrayWord.get(i);
					word = word.trim(); // 去掉空格

					if (word.length() > 0) {
						StringBuffer tmpBuffer = new StringBuffer();
						// 开始构造span标签
						tmpBuffer.append("<span ");

						// 如果不是藏文，则这个词用普通样式就可以了
						if (!isZWChar(word.toCharArray()[word.length() - 1])) {
							tmpBuffer
									.append(
											"style ='WORD-BREAK:normal;WORD-WRAP:normal'")
									.append(">").append(word);
						} else // 是藏文，要用藏文样式
						{
							tmpBuffer
									.append(
											"style ='WORD-BREAK:keep-all;WHITE-SPACE:nowrap'")
									.append(">").append(word);
							// 如果是藏文，还在后面添加一个特别小的空格来优化折行处理。
							tmpBuffer
									.append("<span style=\"font-size:0pt;\"> </span>");

						}
						// 加词内容，并添加结束标签
						tmpBuffer.append("</span>");
						// 放入标题缓冲中
						resultBuffer.append(tmpBuffer.toString());
					}

				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			resultBuffer = new StringBuffer(title); // 出错,换回原始标题
		}
		return resultBuffer.toString();
	}

	/**
	 * fanmh加，用于判断字符是否为藏文
	 * 
	 * @param ch
	 *            输入字符
	 * @return
	 */
	public static boolean isZWChar(char ch) {
		if ((ch >= 0x0F00) && (ch <= 0x0FCF))
			return true;

		if ((ch >= 0xF300) && (ch <= 0xF8FF))
			return true;

		if ((ch >= 0xD800) && (ch <= 0xDBFF))
			return true;

		if ((ch >= 0xDC00) && (ch <= 0xDFFF))
			return true;

		return false;

	}

	/**
	 * 判断传入字符串是否含有藏文
	 * 
	 * @param stitle
	 * @return
	 */
	public static boolean isZWTitle(String stitle) {
		char[] titleChar = stitle.toCharArray();
		boolean isZWTitle = false;
		for (int j = 0; j < titleChar.length; j++)
			if (isZWChar(titleChar[j])) {
				isZWTitle = true;
				break;
			}
		return isZWTitle;

	}

}
