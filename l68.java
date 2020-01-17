package L68;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class l68 {
	static String[] s; 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sr=new Scanner(System.in);
		
		int n=sr.nextInt();
		sr.nextLine();
		s=new String[n];
		for(int i=0;i<n;i++){
			s[i]=sr.nextLine();
		}
		int m=sr.nextInt();
	
		List<String> ans = new ArrayList<>();
		ans=fullJustify(s,m);
		for(String i:ans){
			System.out.println(i);
		}
		sr.close();
	}
	public static List<String> fullJustify(String[] words, int maxWidth) {
	    List<String> ans = new ArrayList<>();
	    //������ˢ���ˣ�һֱ���ַ���ȥŪ�������˼ҵķ���ֵ��List<String>
	    int Len = 0;//������¼һ�е��ʵĳ����Լ�����֮���һ���ո�
	    int s = 0;//������ÿһ�еĿ�ʼ����
	    int e = 0;//��ʱ���ʵĸ�����δ������󳤶�ʱ
	    for (int i = 0; i < words.length;) {
	        //�жϼ���õ����Ƿ񳬹������
	        //�������������һ������Ǽ����һ�����ʣ�����Ҫ��� 1
	        //�Ѿ��е��ʵĻ����ټ��뵥�ʣ���Ҫ��Ӹ��ո����Զ���� 1
	        if (Len == 0 && Len + words[i].length() <= maxWidth//��һ�����ߺ���ĵ��ʳ���û�����ܳ���
	            || Len > 0 && Len + 1 + words[i].length() <= maxWidth) {
	            e++;//����
	            if (Len == 0) {//�����һ��������û�����ܳ��ȣ����ۼӳ���
	                Len = Len + words[i].length();
	            } else {
	                Len = Len + 1 + words[i].length();
	                //���ǵ�һ���������ܳ��ȣ��ۼӳ��ȵ����üӿո���Ϊ����֮��ո����
	            }
	            i++;//��ʱ���ż�
	        } else {
	            int sub = maxWidth - Len + (e- s) - 1;//��¼ʣ���������ո��λ�õĸ���
	            if (e - s == 1) {//���һ��ֻ��һ�����ʣ���������ʵ�λ��
	                String blank = getStringBlank(sub);//
	                ans.add(words[s] + blank);//ֻ��һ�У�ֱ���������룬����ӿո�
	            } else {
	                StringBuilder temp = new StringBuilder();
	                temp.append(words[s]);//����һ�еĵ�һ����
	                int averageBlank = sub / ((e - s) - 1);//��ʣ�µ�λ���Ƿ����װ�´��е��ʸ����Ŀո�
	                //��ΪҪ���˶���or�����
	                 //���������������ʣ��ո���
	                int missing = sub - averageBlank * ((e - s) - 1);//ʣ�µĿո񣨷ֳɣ�what a pig�����������������ո񣬣���Ϊ��ĿҪ������ո��ܷ֣��ͼ���ߣ�
	                //e-s���е��ʸ�����-1�ǵ���֮��ո����
	                String blank = getStringBlank(averageBlank + 1);
	                //��˼�Ǵ���߿�ʼ��ո���Ϊ��һ����ͳ��ˣ����Դ����
	                //ֻ����what    is����֮��Ŀո�
	                int k = 1;//
	                for (int j = 0; j < missing; j++) {
	                	//��ʱ����õĿո���Ϻ���ĵ���
	                    temp.append(blank + words[s+k]);
	                    k++;
	                }
	                blank = getStringBlank(averageBlank);
	                for (; k <(e - s); k++) {
	                    temp.append(blank + words[s+k]);
	                }
	                ans.add(temp.toString());

	            }
	            s = e;//ǰһ�е����һ����λ�ã�������һ�е�һ����λ��
	            Len = 0;//���г�������

	        }
	    }
	    //ѭ�����������һ�У�����Ҫ������룬
	    StringBuilder temp = new StringBuilder();
	    temp.append(words[s]);
	    //�Ȳ��ܣ�������һ������д
	    for (int i = 1; i < (e - s); i++) {
	        temp.append(" " + words[s+i]);
	        //����ÿһ���ո���һ������
	    }
	    temp.append(getStringBlank(maxWidth -Len));//�����ʣ�µ�û�������ÿո���
	    ans.add(temp.toString());//��������ʱ�����洢�����յ��б���ȥ
	    return ans;
	}
	private static  String getStringBlank(int n) {
		//�˷������������ÿո����ʣ�µ�λ��
	    StringBuilder str = new StringBuilder();
	    for (int i = 0; i < n; i++) {
	        str.append(" ");
	    }
	    return str.toString();
	}
}