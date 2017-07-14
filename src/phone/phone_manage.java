package phone;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class phone_manage {
	public static void main(String[] args) throws IOException {
		ArrayList<Phone> list = new ArrayList<Phone>();
		Phone ph = new Phone();
		System.out.println("*****************************************");
		System.out.println("*\t         전화번호 관리 프로그램\t        *");
		System.out.println("*****************************************");
		Scanner sc = new Scanner(System.in);
		while(true){
			String str;
			String[] data;
			System.out.println("1.리스트	2.등록	3.삭제	4.검색	5.종료	 ");
			System.out.println("-----------------------------------------");
			System.out.print(">메뉴번호 : ");
			int num = sc.nextInt();
			if(num == 1) {
				System.out.println("<1. 리스트>");
				int i =1;
				InputStream fis = new FileInputStream
						("D:\\javaStudy\\file\\PhoneDB.txt");
				InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
				BufferedReader br = new BufferedReader(isr);
				while(true) {
					String index = String.valueOf(i);
					str = br.readLine();
					if(str == null) break;
					data = str.split(",");
					
					ph.setPhone(index ,data[0], data[1], data[2]);
					list.add(ph);
					list.get(i-1).showInfo();
					i++;
				}
				System.out.println("");
				br.close();
			} else if(num == 2) {
				InputStream fis = new FileInputStream
						("D:\\javaStudy\\file\\PhoneDB.txt");
				InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
				BufferedReader br = new BufferedReader(isr);
				System.out.println("<2. 등록>");
				System.out.print(">이름 : ");
				String name = scNextLine();
				System.out.print(">집 : ");
				String hp = scNextLine();
				System.out.print(">직장 : ");
				String company = scNextLine();
				String add_line = name+","+hp+","+company+"\n";
				String save_str = "";
				while(true) {
					str = br.readLine();
			        if(str==null)
						break;
			        save_str=save_str+str+"\n";
				}
				br.close();
				OutputStream fos = new FileOutputStream
						("D:\\javaStudy\\file\\PhoneDB.txt");
				OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
				BufferedWriter bw = new BufferedWriter(osw);
				bw.append(save_str+add_line);
				bw.close();
				System.out.println("");
				System.out.println("[등록되었습니다.]");
			} else if(num == 3) {
				System.out.println("<3. 삭제>");
				System.out.print(">번호: ");
				int index_num = sc.nextInt();
				int i =1;
				InputStream fis = new FileInputStream
						("D:\\javaStudy\\file\\PhoneDB.txt");
				InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
				BufferedReader br = new BufferedReader(isr);
				String save_str = "";
				while(true) {
					str = br.readLine();
			        if(str==null)
						break;
					if(i == index_num) {
						i++;
						continue;
					}
			        save_str=save_str+str+"\n";
					i++;
				}
				br.close();
				OutputStream fos = new FileOutputStream
						("D:\\javaStudy\\file\\PhoneDB.txt");
				OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
				BufferedWriter bw = new BufferedWriter(osw);
				bw.append(save_str);
				bw.close();
				System.out.println("");
				System.out.println("[삭제되었습니다.]");
			} else if(num == 4) {
				System.out.println("<4. 검색>");
				System.out.print(">이름: ");
				String index_name = scNextLine();
				int i =1;
				InputStream fis = new FileInputStream
						("D:\\javaStudy\\file\\PhoneDB.txt");
				InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
				BufferedReader br = new BufferedReader(isr);
				while(true) {
					String index = String.valueOf(i);
					str = br.readLine();
					if(str == null) break;
					data = str.split(",");
					ph.setPhone(index ,data[0], data[1], data[2]);
					list.add(ph);
					if(data[0].contains(index_name)) {
						System.out.print(i);
						list.get(i-1).showInfo2();
						i++;
						continue;
					}
					i++;
				}
				System.out.println("");
				br.close();
			} else if(num == 5) {
				System.out.println("*****************************************");
				System.out.println("*\t\t감사합니다.\t\t*");
				System.out.println("*****************************************");
				break;	
			} else {
				System.out.println("다시 입력해주세요");
			}
		}
	}
	public static String scNextLine() {
		Scanner sc = new Scanner(System.in);
		String string = sc.nextLine();
		return string;
	}
}
