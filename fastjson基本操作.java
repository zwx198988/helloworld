package com.hhz.demo;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class operateJson {

	public class  User{

		private String name;
		private int age;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

		@java.lang.Override
		public java.lang.String toString() {
			return "User{" +
					"name='" + name + '\'' +
					", age=" + age +
					'}';
		}


	}

	List<User> userList = new ArrayList<User>();

	User user = new User();
	user.setName("tomcat");
	user.setAge(20);

	User user1 = new User();
	user.setName("dog");
	user.setAge(10);

	userList.add(user);
	userList.add(user1);

	/**
	 * java 对象转字符串
	 */
	String strUser = JSONObject.toJSONString(user);
	String strUserList = JSONObject.toJSONString(userList);

	/**
	 * 字符串转 JSONObject 对象
	 */
	JSONObject jsonObj= JSONObject.parseObject(strUser);

	/**
	 *  取得 JSONObject 中的一个key 为 "data" 的子字符串
	 */
	String name = jsonObj.getString("name");

	/**
	 *  字符串转java对象
	 */

	User user = JSONObject.parseObject(strUser, User.class);

	/**
	 * 字符串转 JSONArray 数组对象
	 */
	JSONArray jsonArrary = JSONArray.parseArray(strUserList);

	// JSONArray对象的遍历
	if(jsonArrary.size()>0){

		for(int i=0;i<jsonArrary.size();i++){

			JSONObject job = jsonArrary.getJSONObject(i);  // 遍历 jsonarray 数组，把每一个对象转成 json 对象

			User user = (User)JSONObject.toJavaObject(job,User.class); //循环将 json 对象转成 java对象

			System.out.println(user.toString()) ;  //  打印转换后java对象的信息

		}

	}


}
