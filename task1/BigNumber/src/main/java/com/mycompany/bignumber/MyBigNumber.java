package com.mycompany.bignumber;

public class MyBigNumber {

    private final IMyBigNumber iMyBigNumber;

    public MyBigNumber(IMyBigNumber iMyBigNumber) {
        this.iMyBigNumber = iMyBigNumber;
    }

    public String sum(String stn1, String stn2) {
        StringBuilder result = new StringBuilder();
        int carry = 0;
        int i = stn1.length() - 1;
        int j = stn2.length() - 1;
        int step = 1;

        while (i >= 0 || j >= 0 || carry > 0) {
            int digit1 = (i >= 0) ? stn1.charAt(i--) - '0' : 0;
            int digit2 = (j >= 0) ? stn2.charAt(j--) - '0' : 0;
            int totalWithoutCarry = digit1 + digit2;
            int total = totalWithoutCarry + carry;
            int remainder = total % 10;
            int oldCarry = carry;
            carry = total / 10;

            result.append(remainder);

            String msg = (oldCarry > 0)
                    ? "Bước " + step++ + ": " + digit1 + " + " + digit2 + " + " + oldCarry +
                      " = " + total + " | ghi " + remainder + ", nhớ " + carry
                    : "Bước " + step++ + ": " + digit1 + " + " + digit2 +
                      " = " + total + " | ghi " + remainder + ", nhớ " + carry;
            iMyBigNumber.log(msg);
        }

        return result.reverse().toString();
    }
}
