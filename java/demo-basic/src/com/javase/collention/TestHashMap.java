package com.javase.collention;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class TestHashMap {

	public static void main(String[] args) {
		HashMap hm = new HashMap();
		hm.put("a", "AAA");
		hm.put("b", "BBB");
		hm.put("ab", "aaaa");
		hm.put("c", "BBB");
		System.out.println(hm);
		System.out.println(hm.get("a"));
		System.out.println(hm.get("ab"));
		Set keys = hm.keySet();// 返回set<K>
		Iterator it = keys.iterator();
		while (it.hasNext()) {
			Object key = it.next();
			System.out.println(key + ":" + hm.get(key));// get(Object
			// key),返回<V>.
		}
		Collection vals = hm.values();// 返回Collection<V>.
		Iterator it2 = vals.iterator();// 只有键，没有值。
		while (it2.hasNext()) {
			System.out.println(it2.next());
		}
		Set entries = hm.entrySet();// 返回Set<Map,Entry<K,V>>.
		Iterator it3 = entries.iterator();
		while (it3.hasNext()) {
			Map.Entry entry = (Map.Entry) it3.next();
			System.out.println(entry.getKey() + ":" + entry.getValue());
		}
		System.out.println(hm.containsKey("a"));// 键→返回true/false。
		System.out.println(hm.containsKey("ab"));// 键→返回true/false。
	}
}
