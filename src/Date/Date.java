package Date;
import java.io.Serializable;

public class Date implements Serializable {
    int year;
    int month;
    int day;

    public Date() {
        this(1,1);
    }

    public Date(int month,int day) {
        this(month,day,1900);
    }

    public Date(int month, int day, int year) {
        this.year=year;
        this.month=month;
        this.day=day;
    }

    public int getYear() {
        return this.year;
    }

    public int getMonth() {
        return this.month;
    }

    public int getDay() {
        return this.day;
    }


    @Override
    public String toString() {
        return this.year + "-" + this.month + "-" + this.day;
    }

    public static void main(String[] args) {
        Date A = new Date();
        System.out.println(A.getYear() + " 年 " + A.getMonth() + " 月 " + A.getDay() + " 日 ");
        System.out.println("标准日期格式: " + A.toString());

        Date B = new Date(7, 1);
        System.out.println(B.getYear() + " 年 " + B.getMonth() + " 月 " + B.getDay() + " 日 ");
        System.out.println("标准日期格式: " + B.toString());

        Date C = new Date(10, 1, 2077);
        System.out.println(C.getYear() + " 年 " + C.getMonth() + " 月 " + C.getDay() + " 日 ");
        System.out.println("标准日期格式: " + C.toString());

    }

}