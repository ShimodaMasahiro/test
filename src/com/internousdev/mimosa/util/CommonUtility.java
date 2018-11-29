package com.internousdev.mimosa.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CommonUtility {
	public String getRamdomValue() {
		String value="";
		double d;
		for(int i=1; i<=16; i++) {
			d=Math.random() * 10;
			value=value+((int)d);
		}
		return value;
	}

	public String[] parseArrayList(String s) {
		return s.split(", ",0);
	}

	public <E> List<List<E>>  devideList(List<E> list, int size){
		if (list == null || list.isEmpty() || size <= 0) {
			return null;
		}
		int block = list.size() / size + (list.size() % size > 0 ? 1 : 0 );
		List<List<E>> devidedList = new ArrayList<List<E>>(block);
		for (int i = 0; i < block; i ++) {
			int start = i * size;
			int end = Math.min(start + size, list.size());
			devidedList.add(new ArrayList<E>(list.subList(start, end)));
		}
		return devidedList;
	}

	/**NOTE:追加メソッド。Homeでのみsession.putされるmCategoryListを元にsessionの期限管理を行う。
	 * sessionが切れているならerror.htmlに飛ばし、Homeにリダイレクトさせる。
	 */
	public boolean checkSession(Map<String, Object> session){
		boolean flg=false;
		if(session.containsKey("mCategoryDtoList")){
			flg = true;
		}

		return flg;
	}
}
