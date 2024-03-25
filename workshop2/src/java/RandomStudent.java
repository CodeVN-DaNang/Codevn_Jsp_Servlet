
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
public class RandomStudent {

    String lowerStr = "qwertyuiopasdfghjklzxcvbnm";
    String upperStr = "QWERTYUIOPASDFGHJKLZXCVBNM";
    String number = "0123456789";
    Random generator = new Random();

    public String generateName(int lengthStr) {
        String result = "";
        String[] str = (lowerStr + upperStr).split("");
        for (int i = 0; i < lengthStr; i++) {
            result += str[generator.nextInt(0, str.length - 1)];
        }
        return result;
    }

    public Date generateDateOfBirth() {
        int day = generator.nextInt(1, 31);
        int month = generator.nextInt(1, 13);
        int year = 2000 + generator.nextInt(19);
        switch (month) {
            case 4:
            case 6:
            case 9:
            case 11:
                if (day == 31) {
                    return generateDateOfBirth();
                }
                break;
            case 2:
                if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
                    if (day > 29) {
                        return generateDateOfBirth();
                    }
                } else {
                    if (day > 28) {
                        return generateDateOfBirth();
                    }
                }
                break;
            default:
                break;
        }
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
            String dayStr = "";
            String monthStr = "";
            if (day < 10) {
                System.out.println(day);
                dayStr = "0" + day;
            }
            if (month < 10) {
                System.out.println(month);
                monthStr = "0" + month;
            }
            String dateInString = dayStr + "-" + monthStr + "-" + year;
            Date date = formatter.parse(dateInString);
            return date;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
    
    public String generateGender(){
        String[] choiceGenders = {"male", "female", "other"};
        return choiceGenders[generator.nextInt(3)];
    }

}