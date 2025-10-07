package com.mycompany.bignumber;

public class MainTest {
    public static void main(String[] args) {
        // Tạo đối tượng logger để in từng bước cộng
        IMyBigNumber logger = new IMyBigNumber() {
            @Override
            public void log(String message) {
                System.out.println(message);
            }
        };

        // Truyền logger vào MyBigNumber
        MyBigNumber myBigNumber = new MyBigNumber(logger);

        String num1 = "1234";
        String num2 = "897";

        System.out.println("Cộng " + num1 + " + " + num2);
        String result = myBigNumber.sum(num1, num2);
        System.out.println("Kết quả: " + result);
    }
}
