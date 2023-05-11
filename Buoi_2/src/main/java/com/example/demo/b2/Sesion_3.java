package com.example.demo.b2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Sesion_3 {

    @GetMapping("/b2/view-diem")
    public String viewTuoi() {
        return "b2/diem";
    }

    @PostMapping("/b2/view-diem")
    public String tinhDiem(Model model, @RequestParam(name = "lab") Float lab
            , @RequestParam(name = "quizz") Float quizz
            , @RequestParam(name = "ass") Float ass
            , @RequestParam(name = "finall") Float finall
    ) {
        float diemTB = lab * 0.28f + quizz * 0.12f + ass * 0.2f + finall * 0.4f;
        String ketQua = "";
        if (finall >= 5.0 && diemTB >= 5.0) {
            ketQua = "Pass";
        } else {
            ketQua = "Fail";
        }
        model.addAttribute("ketQua", ketQua);
        return "b2/diem";
    }

}
