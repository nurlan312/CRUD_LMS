package peaksoft.controllers.company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.models.Company;
import peaksoft.services.company.CompanyService;

@Controller
@RequestMapping("/company/companies")
public class CompanyController {

    private final CompanyService companyService;

    @Autowired
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping
    public String getCompanies(Model model) {
        model.addAttribute("companies", companyService.getAllCompanies());
        return "/company/companies";
    }

    @GetMapping("/add-company")
    public String addCompany(Model model) {
        model.addAttribute("company", new Company());
        return "/company/add-company";
    }

    @PostMapping("/save-company")
    public String saveCompany(@ModelAttribute("company") Company company) {
        companyService.saveCompany(company);
        return "redirect:/company/companies";
    }

    @GetMapping("/update-company/{id}")
    public String updateCompany(@PathVariable("id") Long id, Model model) {
        model.addAttribute("company", companyService.getByIdCompany(id));
        return "/company/update-company";
    }

    @PostMapping("/edit-company/{id}")
    public String editCompany(@PathVariable("id") Long id, @ModelAttribute("company") Company company) {
        companyService.updateCompany(company, id);
        return "redirect:/company/companies";
    }

    @GetMapping("/delete-company/{id}")
    public String deleteCompany(@PathVariable("id") Long id) {
        companyService.deleteCompany(id);
        return "redirect:/company/companies";
    }
}
