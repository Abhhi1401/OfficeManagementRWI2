package in.railworld.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import in.railworld.app.Services.Implemetation.CookieService;
import in.railworld.app.model.JobDetails;
import in.railworld.app.service.JobDetailsService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/jobs")
public class PageController {
	
	@Autowired
	private JobDetailsService jobDetailsService;
	
	@Autowired
	private CookieService  cookieService;
	
       
	@GetMapping("/html/{id}")
	public RedirectView jobPageHandler(@PathVariable int id, HttpServletResponse response) {
		JobDetails job = jobDetailsService.getJobById(id);
		 if (job != null) {
	            // Store the selected job ID in a permanent cookie
	            cookieService.setPermanentCookie(response, "selectedJobId", String.valueOf(id));
                
	            RedirectView redirectView = new RedirectView();
	            redirectView.setUrl("/app/application.html");
	            return redirectView;
	            
	        }
		 
		 RedirectView redirectView = new RedirectView();
            redirectView.setUrl("/app/application.html");
            return redirectView;
		
		
	}

     @GetMapping("html/dashboard")
     @PreAuthorize("hasAuthority('ROLE_HR')")
     public RedirectView dashboardHandler(HttpServletRequest req, HttpServletResponse res) {
    	   System.out.println(req.getHeader("Authorization"));
    	   System.out.println(res.getHeader("Authorization"));
    	 RedirectView redirectView = new RedirectView();
         redirectView.setUrl("/app/application.html");
         return redirectView;
     }
}
