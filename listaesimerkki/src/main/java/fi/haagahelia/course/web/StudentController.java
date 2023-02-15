package fi.haagahelia.course.web;



import java.util.ArrayList;

import java.util.List;



import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;



import fi.haagahelia.course.domain.Message;



@Controller

public class StudentController {

	@RequestMapping("/hello-testi")

	public String greeting(@RequestParam(name = "name") String jukanNimi, Model model) {

		model.addAttribute("name", jukanNimi);

		return "hello-testi";

	}

	// DEMO KOTITEHTAVAN KOHDAN 2 TEKEMISEN AUTTAMISEKSI

	// KOVAKOODATUN LISTAN MUODOSTAMINEN JA VÄLITTÄMINEN THYMELEAF SIVULLE

	@RequestMapping("/naytalista")

	public String naytaLista(Model model) {

		// KOVAKOODATTU MESSAGE OLIOITA SISÄLTÄVÄ LISTA

		List<Message> viestit = new ArrayList<Message>();

		Message message1 = new Message();

		message1.setMsg("Spaghetti");

		viestit.add(message1);

		Message message2 = new Message();		

		message2.setMsg("Kaalikääryle");

		viestit.add(message2);

		Message message3 = new Message();

		message3.setMsg("Mustamakkara");

		viestit.add(message3);

		

		// LISTA ON ASETETTAVA MODEL-OLIOON, JOTTA SE VOIDAAN PURKAA THYMELEAF-SIVULLA

		model.addAttribute("ruokalista", viestit);

		

		return "lista";

	}

	

	

	

}