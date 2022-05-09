package com.example.tp3.controller;

import com.example.tp3.forms.ClientForm;
import com.example.tp3.forms.EmpruntForm;
import com.example.tp3.forms.LivreForm;
import com.example.tp3.model.Emprunt;
import com.example.tp3.model.document.Livre;
import com.example.tp3.model.personne.Client;
import com.example.tp3.service.EmployeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.validation.Valid;
import java.util.Optional;

@Controller
public class RootController {
    Logger logger = LoggerFactory.getLogger(RootController.class);

    private EmployeService es;

    public RootController(EmployeService es) {
        this.es = es;
    }

    @GetMapping(value = {"/", "/index", "/index.html"})
    public String getRootRequest(Model model) {
        model.addAttribute("pageTitle", "Accueil");
        model.addAttribute("h1Text", "La bibliotheque");
        return "index";
    }

    //CLIENT
    @GetMapping("/clients")
    public String getClient(Model model) {
        model.addAttribute("pageTitle", "Mon demo");
        var clients = es.findAllClient();
        model.addAttribute("clients", clients);
        return "clients";
    }

    @GetMapping(value = {"/clientcreate"})
    public String getClientCreate(Model model) {
        var clientForm = new ClientForm();
        model.addAttribute("clientForm", clientForm);
        return "/clientEdit";
    }

    @PostMapping(value = {"/clientcreate"})
    public String clientPost(@Valid @ModelAttribute ClientForm clientForm,
                             BindingResult errors,
                             RedirectAttributes redirectAttributes) {
        logger.info("client: " + clientForm);
        if (errors.hasErrors()) {
            return "/clientEdit";
        }
        final Client client = es.saveClient(clientForm.toClient());
        clientForm.setId(Long.toString(client.getId()));

        redirectAttributes.addFlashAttribute("clientForm", clientForm);
        redirectAttributes.addAttribute("id", clientForm.getId());

        return "redirect:/clientEdit/{id}";
    }

    @GetMapping(value = {"/clientEdit/{id}"})
    public String getClientRequest(@ModelAttribute ClientForm clientForm,
                                   Model model,
                                   @PathVariable("id") String id) {
        logger.info("Into getProfRequest with id " + id);
        long clientId = getIdFromString(id);
        final Optional<Client> clientById = es.findClientById(clientId);
        clientForm = new ClientForm();
        if (clientById.isPresent()) {
            clientForm = new ClientForm(clientById.get());
        }
        model.addAttribute("clientForm", clientForm);
        return "/clientEdit";
    }

    //LIVRE
    @GetMapping("/livres")
    public String getLivre(Model model) {
        model.addAttribute("pageTitle", "Mon demo");
        var livres = es.findAllLivre();
        model.addAttribute("livres", livres);
        return "livres";
    }

    @GetMapping(value = {"/livrecreate"})
    public String getLivreCreate(Model model) {
        var livreForm = new LivreForm();
        model.addAttribute("livreForm", livreForm);
        return "/livreEdit";
    }

    @PostMapping(value = {"/livrecreate"})
    public String clientPost(@Valid @ModelAttribute LivreForm livreForm,
                             BindingResult errors,
                             RedirectAttributes redirectAttributes) {
        logger.info("livre: " + livreForm);
        if (errors.hasErrors()) {
            return "/livreEdit";
        }
        final Livre livre = es.saveLivre(livreForm.toLivre());
        livreForm.setId(Long.toString(livre.getId()));

        redirectAttributes.addFlashAttribute("livreForm", livreForm);
        redirectAttributes.addAttribute("id", livreForm.getId());

        return "redirect:/livreEdit/{id}";

    }

    @GetMapping(value = {"/livreEdit/{id}"})
    public String getClientRequest(@ModelAttribute LivreForm livreForm,
                                   Model model,
                                   @PathVariable("id") String id) {
        logger.info("Into getProfRequest with id " + id);
        long livreId = getIdFromString(id);
        final Optional<Livre> livreById = es.findLivreById(livreId);
        livreForm = new LivreForm();
        if (livreById.isPresent()) {
            livreForm = new LivreForm(livreById.get());
        }
        model.addAttribute("livreForm", livreForm);
        return "/livreEdit";
    }

    //EMPRUNT
    @GetMapping("/emprunts")
    public String getEmprunts(Model model) {
        model.addAttribute("pageTitle", "Mon demo");
        var emprunts = es.findAllEmprunt();
        model.addAttribute("emprunts", emprunts);
        return "emprunts";
    }

    @GetMapping(value = {"/empruntcreate"})
    public String getEmpruntCreate(Model model) {
        var empruntForm = new EmpruntForm();
        model.addAttribute("empruntForm", empruntForm);
        return "/empruntEdit";
    }

    @PostMapping(value = {"/empruntcreate"})
    public String clientPost(@Valid @ModelAttribute @Validated EmpruntForm empruntForm,
                             BindingResult errors,
                             RedirectAttributes redirectAttributes) throws Exception {
        logger.info("emprunt: " + empruntForm);
        if (errors.hasErrors()) {
            return "/empruntEdit";
        }
        final Emprunt emprunt = es.createEmprunt(es.findClientById(empruntForm.getClientId()).get(),
                es.findLivreById(empruntForm.getLivreId()).get());
        empruntForm.setId(Long.toString(emprunt.getId()));

        redirectAttributes.addFlashAttribute("empruntForm", empruntForm);
        redirectAttributes.addAttribute("id", empruntForm.getId());

        return "redirect:/empruntEdit/{id}";

    }

    @GetMapping(value = {"/empruntEdit/{id}"})
    public String getClientRequest(@ModelAttribute EmpruntForm empruntForm,
                                   Model model,
                                   @PathVariable("id") String id) {
        logger.info("Into getProfRequest with id " + id);
        long empruntId = getIdFromString(id);
        final Optional<Emprunt> empruntById = es.findEmpruntById(empruntId);
        empruntForm = new EmpruntForm();
        if (empruntById.isPresent()) {
            empruntForm = new EmpruntForm(empruntById.get());
        }
        model.addAttribute("empruntForm", empruntForm);
        return "/empruntEdit";
    }


    private long getIdFromString(String id) {
        try {
            return Long.parseLong(id);
        } catch (NumberFormatException e) {
        }
        return 0;
    }
}
