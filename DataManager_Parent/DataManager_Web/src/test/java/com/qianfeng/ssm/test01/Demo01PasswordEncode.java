package com.qianfeng.ssm.test01;

import java.util.Arrays;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Demo01PasswordEncode {
	
	public static void main(String[] args) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String password = encoder.encode("12345");
		System.out.println(password);
		//$2a$10$uroq/glyF45jMmTLAw9DluKrrKkA2RBRAcQYLhUTZyVN431J8py16
		//$2a$10$vvre5ESB.hDuUH7uG829NOqytpzLkUH6XeUvt1Uf/Qs2yn.mrLABe
		int[] arr = {1,2,3,4,5};
		System.out.println(Arrays.toString(arr));
		consumerArray(arr);
		System.out.println(Arrays.toString(arr));
		String str = "hehe";
		System.out.println(str);
		consumerString(str);
		System.out.println(str);
	}
	//值传递  形参的改变对实参是否有影响 没有  引用传递 形参的改变对实参是否有影响  String特殊一些  
	/*
	 * String  final修饰  代表的就是最终
	 * "hehe" 常量池  jdk1.7 方法区  jdk1.8 堆区 java的内存区域  jvm的内存模型  jvm运行时区域
	 * 指针传递  传递的是数据值
	 */
	public static void consumerArray(int[] arr) {
		arr[0] = 10;
	}
	public static void consumerString(String str) {
		str = "haha";
	}

}
