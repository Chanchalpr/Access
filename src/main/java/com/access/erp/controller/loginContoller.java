package com.access.erp.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.access.erp.model.master.Company;
import com.access.erp.model.master.FinancialActiveYear;
import com.access.erp.model.master.FinancialYear;
import com.access.erp.model.master.MyUser;
import com.access.erp.repo.FinnancialActiveYearRepo;
import com.access.erp.service.CompanyService;
import com.access.erp.service.FinancialActiveYearService;
import com.access.erp.service.FinancialYearService;
import com.access.erp.service.MyUserService;

@Controller
public class loginContoller {

	/*
	 * @GetMapping("/") public String loginPage(Model model) { return "login"; }
	 */

	@Autowired
	FinancialActiveYearService financialActiveyearService;
	@Autowired
	CompanyService companyService;
	@Autowired
	MyUserService myUserService;
	@Autowired
	FinnancialActiveYearRepo finnancialActiveYearRepo;
	@Autowired
	FinancialYearService financialYearService;

	@GetMapping("/verify")
	public String indexPage(Model model) {

		List<Company> listCompany = companyService.getAllCompany();
		model.addAttribute("listCompany", listCompany);

		model.addAttribute("login", new FinancialActiveYear());

		return "layouts/loginPopup";
	}

	@PostMapping("/index")
	public String loginPopupPage(Model model, @ModelAttribute("") FinancialActiveYear financialActiveYear,
			Principal principal) {

		String activeUser = principal.getName();

		System.out.println("company is : " + financialActiveYear.getCompany().getCompCode());

		System.out.println("fy year is : " + financialActiveYear.getFinancialYear().getFinancialYearCode());
		System.out.println("active user  : " + activeUser);

		Company aCompany = companyService.editCompany(financialActiveYear.getCompany().getCompCode());
		
		FinancialYear aFy = financialYearService
				.editFinancialYear(financialActiveYear.getFinancialYear().getFinancialYearCode()).get();
		
		MyUser aUser = myUserService.editMyUser(activeUser).get();

		boolean isExist = finnancialActiveYearRepo.existsByFinancialYearAndMyUserAndCompany(aFy, aUser, aCompany);

		System.out.println("isExist or Not :" + isExist);
		
		if(isExist) {
			return "layouts/index";
		}else {
			return "layouts/login";
		}

		
		
	}

	@ResponseBody
	@GetMapping("/activefy/{id}")
	public List<FinancialActiveYear> getStateCountryById(@PathVariable(value = "id") String compCode) {

		Company company = companyService.editCompany(compCode);

		System.out.println("Company code Is : " + company.getCompCode());
		List<FinancialActiveYear> fy = financialActiveyearService.findByCompany(company);
		System.out.println("fy size : " + fy.size());
		return fy;

		// return null;
	}

}
