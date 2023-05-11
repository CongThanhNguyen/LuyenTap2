package com.example.demo.b2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Calendar;

@Controller
public class session_2 {
    @RequestMapping("/b2") // cau hinh duong dan
    public String wellcome() {
        return "/index";// tra view
    }

    @RequestMapping("/b2/sv")
    public String listSV(Model model) {
        String[] list = new String[]{"congnt", "linhhihi"};
        model.addAttribute("list", list);
        return "/b2/sinhVien";
    }

    @GetMapping("/b2/tinh-tuoi")
    public String viewTuoi() {
        return "b2/tuoi";
    }

    @PostMapping("/b2/tinh-tuoi")
    public String tinhTuoi(Model model, @RequestParam(name = "year") Integer namSinh) {
        Integer namHienTai = Calendar.getInstance().get(Calendar.YEAR);
        Integer age = namHienTai - namSinh;
        model.addAttribute("age", age);
        return "b2/tuoi";

    }
}
