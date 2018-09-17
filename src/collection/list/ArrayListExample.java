package collection.list;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 *@author zjl
 *2018年9月11日 下午9:02:30
 */
public class ArrayListExample {
	
	public static void main(String[] args) throws Exception {
		
		StaffManage manage = new StaffManage();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			System.out.println("功能选择：");
			System.out.println("1、添加员工");
			System.out.println("2、查找员工");
			System.out.println("3、修改员工工资");
			System.out.println("4、删除员工");
			System.out.println("5、查所有员工");
			System.out.println("0、退出系统");
			
			String menu = br.readLine();
			switch(menu) {
				case "1":
				{
					System.out.println("请输入新增员工编号：");
					String number = br.readLine();
					System.out.println("请输入新增员工姓名：");
					String name = br.readLine();
					System.out.println("请输入新增员工薪水：");
					float salary = Float.parseFloat(br.readLine());
					Staff staff = new Staff(number,name,salary);
					manage.addStaff(staff);
				}
					break;
				case "2":
				{
					System.out.println("请输入要查找员工编号：");
					String number = br.readLine();
					manage.showStaff(number);
				}
					break;
				case "3":
				{
					System.out.println("请输入员工编号：");
					String number = br.readLine();
					System.out.println("请输入员工薪水："); 
					float salary = Float.parseFloat(br.readLine());
					manage.modifyStaff(number, salary);
				}
					break;
				case "4":
				{
					System.out.println("请输入要删除员工编号：");
					String number=br.readLine();
					manage.deleteStaff(number);
				}
					break;
				case "5":
				{
					manage.showAllStaff();
				}
					break;
				case "0":
				{
					System.exit(0);
				}
					break;
				default:
					System.out.println("请选择正确功能！");
					break;
			}

		}
			
	}
		
}
	
	
	class StaffManage{
		
		private ArrayList<Staff> list = null;
		
		public StaffManage() {
			this.list = new ArrayList<Staff>();
		}
		
		/**
		 * 添加职工
		 * @param staff
		 */
		public void addStaff(Staff staff) {
			list.add(staff);
		}
		
		/**
		 * 根据工号删除职工
		 * @param number
		 */
		public void deleteStaff(String number) {
			for (int i = 0; i < list.size(); i++) {
				Staff staff = list.get(i);
				if(staff.getNumber().equals(number)) {
					list.remove(staff);
					return;
				}else {
					System.out.println("该员工不存在");
				}
			}
		}
		
		/**
		 * 根据工号修改职工薪水
		 * @param number
		 * @param salary
		 */
		public void modifyStaff(String number,float salary) {
			for (int i = 0; i < list.size(); i++) {
				Staff staff = list.get(i);
				if(staff.getNumber().equals(number)) {
					staff.setSalary(salary);
					System.out.println("该员工薪水修改为："+staff.getSalary());
				}else {
					System.out.println("该员工不存在");
				}
			}
		} 
		
		/**
		 * 根据工号查某个员工
		 * @param number
		 */
		public void showStaff(String number) {
			for (int i = 0; i < list.size(); i++) {
				Staff staff = list.get(i);
				if(staff.getNumber().equals(number)) {
					System.out.println("所找员工的工号为："+staff.getNumber()+"，姓名为："
							+staff.getName()+"，薪水为："+staff.getSalary());
				}else {
					System.out.println("该员工不存在");
				}
			}
		}
		
		/**
		 * 查所有员工
		 */
		public void showAllStaff() {
			if(list == null || list.size() == 0) {
				System.out.println("没有员工");
			}
			System.out.println("----------");
			for (Staff staff : list) {
				System.out.print("工号："+staff.getNumber()+",姓名："+staff.getName()+",薪水："+staff.getSalary());
				System.out.println();
			}
		}
		
		
	}
	
	class Staff{
		private String number; //工号
		
		private String name; //姓名
		
		private Float salary; //薪水
		
		public Staff() {
			super();
		}

		public Staff(String number, String name, Float salary) {
			super();
			this.number = number;
			this.name = name;
			this.salary = salary;
		}

		public String getNumber() {
			return number;
		}

		public void setNumber(String number) {
			this.number = number;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Float getSalary() {
			return salary;
		}

		public void setSalary(Float salary) {
			this.salary = salary;
		}
		
	}
