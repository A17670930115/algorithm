package L71;

import java.util.Scanner;
import java.util.Stack;

public class l71 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sr=new Scanner(System.in);
		String s;
		s=sr.nextLine();
		System.out.println(simplifyPath(s));
		sr.close();
	}
        public static String simplifyPath(String path) {
	    	String[] s=path.split("/");
	        Stack<String> stack=new Stack<>();
	        for(int i=0;i<s.length;i++) {
	        	if(!stack.empty()&&s[i].equals("..")) {//������ϼ����ͰѲ�������Ĵ�ջ��ȥ����
	        		stack.pop();
	        	}
	        	else if(!s[i].equals("")&&!s[i].equals(".")&&!s[i].equals("..")) {//��Ȼ�Ϳ��ǲ��Ǿ���·��
	        		stack.push(s[i]);
	        	}
	        }
			if(stack.isEmpty())return "/";
			String result="";//���ַ�������
			for(int i=0;i<stack.size();i++) 
				result+="/"+stack.get(i);//��Ϊջ��Ҳ��������һ���Ľṹ
			return result;
}
}
