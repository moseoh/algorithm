package src;

/**
 * Temp2
 * 주소
 * Github : https://github.com/azqazq195
 * Created by azqazq195@gmail.com on 2021-04-27
 */
public class Temp2 {
    public static void main(String[] args) {
        String str = "test";
        System.out.println(str == "test");
        System.out.println(str.equals("test"));

        System.out.println();
        String str1 = "test";
        String str2 = "test";
        System.out.println(str1 == str2);
        System.out.println(str1 == "test");
        System.out.println(str1.equals(str2));
        System.out.println(str1.equals("test"));
    }
}
