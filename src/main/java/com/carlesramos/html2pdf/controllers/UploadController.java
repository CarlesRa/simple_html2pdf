package com.carlesramos.html2pdf.controllers;
import com.carlesramos.html2pdf.services.Util;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UploadController {

    @GetMapping({ "/", "/home"})
    public String home() {
        return "index";
    }

    @RequestMapping("/get_pdf")
    public String getPdfFile(
            @RequestParam(value = "filePath", required = false) String filePath,
            @RequestParam(value = "template", required = false) String template,
            RedirectAttributes redirectAttributes
    ) {
        boolean isConverted = Util.convertToPdf(template, filePath);
        redirectAttributes.addFlashAttribute(
                "message", isConverted ? "File converted successfully!" : "Error converting file" )
                .addFlashAttribute("isConverted", isConverted);
        return "redirect:/";
    }
}
