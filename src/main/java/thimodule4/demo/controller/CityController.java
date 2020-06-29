package thimodule4.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import thimodule4.demo.model.City;
import thimodule4.demo.service.CityService;

@Controller
public class CityController {

    private final CityService cityService;

    @Autowired
    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView loadIndex(Pageable pageable) {
        ModelAndView index = new ModelAndView("index");
        Page<City> cites = cityService.findAll(pageable);
        index.addObject("cities", cites);
        return index;
    }

    @RequestMapping(value = "/city/{id}/detail", method = RequestMethod.GET)
    public ModelAndView loadCity(@PathVariable("id") Integer id) {
        ModelAndView loadCity = null;
        City currentCity = cityService.findById(id);
        if (currentCity != null) {
            loadCity = new ModelAndView("detail");
            loadCity.addObject("city", currentCity);
        } else {
            loadCity = new ModelAndView("404");
        }
        return loadCity;
    }

    @RequestMapping(value = "/city/create", method = RequestMethod.GET)
    public ModelAndView loadCreateForm() {
        ModelAndView createForm = new ModelAndView("createAndEdit");
        City newCity = new City();
        createForm.addObject("currentCity", newCity);
        return createForm;
    }

    @RequestMapping(value = "/city/create-and-edit", method = RequestMethod.POST)
    public RedirectView created(@ModelAttribute("currentCity") City city) {
        cityService.save(city);
        return new RedirectView("/");
    }

    @RequestMapping(value = "/city/{id}/edit", method = RequestMethod.GET)
    public ModelAndView loadEditForm(@PathVariable("id") Integer id) {
        ModelAndView loadEditForm;
        City currentCity = cityService.findById(id);
        if (currentCity != null) {
            loadEditForm = new ModelAndView("createAndEdit");
            loadEditForm.addObject("currentCity", currentCity);
        } else {
            loadEditForm = new ModelAndView("404");
        }
        return loadEditForm;
    }

    @RequestMapping(value = "/city/{id}/delete", method = RequestMethod.GET)
    public RedirectView deleted(@PathVariable("id") Integer id) {
        City currentCity = cityService.findById(id);
        if (currentCity != null) {
            cityService.delete(currentCity);
            return new RedirectView("/");
        } else {
            return new RedirectView("404");
        }
    }
}
