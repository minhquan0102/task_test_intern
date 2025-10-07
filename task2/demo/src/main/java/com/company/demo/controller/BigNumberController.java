package com.company.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.mycompany.bignumber.MyBigNumber;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

@Controller
@RequestMapping("/bignumber")
public class BigNumberController {

    @GetMapping
    public String showForm(Model model) {
        model.addAttribute("num1", "");
        model.addAttribute("num2", "");
        model.addAttribute("result", "");
        model.addAttribute("log", "");
        return "bignumber";
    }

    @PostMapping("/sum")
    public String sumNumbers(
            @RequestParam("num1") String num1,
            @RequestParam("num2") String num2,
            Model model) {

        // Bắt log ra chuỗi thay vì console
        ByteArrayOutputStream logStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(logStream);
        MyBigNumber bigNumber = new MyBigNumber(printStream::println);

        String result;
        try {
            result = bigNumber.sum(num1.trim(), num2.trim());
        } catch (Exception e) {
            e.printStackTrace();
            result = "Lỗi: Vui lòng nhập hai số hợp lệ!";
        }

        // Gửi dữ liệu về view
        model.addAttribute("num1", num1);
        model.addAttribute("num2", num2);
        model.addAttribute("result", result);
        model.addAttribute("log", logStream.toString().replaceAll("\n", "<br>"));

        return "bignumber";
    }
}
