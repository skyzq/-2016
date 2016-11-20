import java.util.*;
import java.text.*;

class Demo2
{
	public static void main(String[] args) 
	{
		Calendar c = new Calendar();
		c.data();
	}

}

class Calendar
{
	long begin;
	String month;
	String year;
	public void data() {
		Scanner str = new Scanner(System.in);
		System.out.println("请输入您要找的年月份，格式如1990-01");
		String time = str.next();

		//获取输入的月份
		month = time.substring(5);
		//获取输入的年份
		year = time.substring(0,4);
		
		//System.out.println(this.charge("1990-01",time)%7);
		begin = this.charge("1990-01",time)%7;
		this.frame();
	}

	//比较日期的方法
	public long charge(String dstr1, String dstr2){
			long charge = 0;
			SimpleDateFormat sd=new SimpleDateFormat("yyyy-MM");
		 try {
   			 Date d1 = sd.parse(dstr1);
			 Date d2 = sd.parse(dstr2);
			 charge = (d2.getTime() - d1.getTime()) / (24 * 60 * 60 * 1000);
			} catch (ParseException e) {
				e.printStackTrace();
			}
				 return charge; 
		}

	//日期模板
	int[] date = new int[50];//定义数组
	int dayNum;
	public void frame() {

		//判断一个月的天数
		//把字符串转为int类型
			int m = Integer.parseInt(month);
			int y = Integer.parseInt(year);
			switch (m)
			{
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:dayNum = 31; break;
				
			case 2:
				if ((y % 4 == 0) && (y % 100 != 0) || (y %400 == 0))
				{
					dayNum = 29;
				} else {
					dayNum = 28;
				}
				break;

			case 4:
			case 6:
			case 9:
			case 11:dayNum = 30; break;
			}

		
		System.out.print("星期一\t星期二\t星期三\t星期四\t星期五\t星期六\t星期日\n");

		//打印日期
		int count = 1;
		for (int j = 0; j < dayNum + (int)begin; j++)
		{
			if (j % 7 == 0) //换行
			{
				System.out.println();
			}
			
			if (j >= begin)  //开始这个月的第一天
			{
				date[j] = count++;
				System.out.print(date[j]);
			}
			System.out.print("\t");

			
			
		}
	}


}
