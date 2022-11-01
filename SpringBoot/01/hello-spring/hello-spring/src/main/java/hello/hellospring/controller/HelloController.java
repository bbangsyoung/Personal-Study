package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hellhellhell")
    public String hell(Model model) {
        model.addAttribute("data","hello!");
        return "hello";
    }


    @GetMapping("hello-mvc")
    public String hellMvc(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template.html";
    }


    @GetMapping("hello-string")
    @ResponseBody
    public String hellString(@RequestParam("name") String name) {
        return "hello" + name;
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello hellApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }


    static class Hello {
        private String name;

        public String getName() {
            return  name;
        }
        public  void setName(String name) {
            this.name = name;
        }





    }


}
