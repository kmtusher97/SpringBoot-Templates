package com.management.EmployeeData.controller;

import com.management.EmployeeData.model.EmployeeInfo;
import com.management.EmployeeData.service.EmployeeInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class EmployeeInfoController {
  /*
    @Autowired stores the resultset(data table)
    @RequestMapping(value = "url_of_action", method = "")
   */
  @Autowired
  EmployeeInfoService employeeInfoService;


  /* url/all link show the data table in index1.html */
  @RequestMapping(value = "/all", method = RequestMethod.GET)
  public ModelAndView getAllEmployeeInfo() {
    ModelAndView modelAndView = new ModelAndView("index1");                 // index1.html page
    List<EmployeeInfo> employeeInfoList = employeeInfoService.getAllEmployeeInfos();  // table data
    modelAndView.addObject("employeeInfoList", employeeInfoList);        // pass the table data in index1.html page
    return modelAndView;                                                              // open the index1.html file on browser
  }


  /* clicking on the add button allows edit_form.html page to be displayed
   * for a new row in the data table data will be received from user through edit_from.html page */
  @RequestMapping(value = "/add", method = RequestMethod.GET)
  public ModelAndView addEmployeeInfo() {                                        // add a row in data table
    ModelAndView modelAndView = new ModelAndView("Edit_Form");         // edit_form.html page
    EmployeeInfo employeeInfo = new EmployeeInfo();                              // this object'll receive the input from edit_form.html page
    modelAndView.addObject("employeeInfoForm", employeeInfo);           // pass the object with the html page
    return modelAndView;                                                         // open the edit from on browser
  }


  /* clicking on the update button in the right side of each row opens the edit_from.html page.
   * after that user can update the attributes of that row
   * /{id} is the primary key value of the row */
  @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)            // update a selected row by the user
  public ModelAndView updateEmployeeInfo( @PathVariable("id") int id ) {         // @Pathvariable annotation for fetching id(Primary key value)
    ModelAndView modelAndView = new ModelAndView("Edit_Form");         // edit_form.html page
    EmployeeInfo employeeInfo = employeeInfoService.getEmployeeInfo( id );       // get the row data having PRI Key = id
    modelAndView.addObject("employeeInfoForm", employeeInfo);           // pass the object with the html page to update
    return modelAndView;                                                         // open the edit from on browser
  }


  /* After clicking the submit button of the edit from the input data stored in data table
   * Then url/all page is displayed on the browser */
  @RequestMapping( value = "/save", method = RequestMethod.POST )                // input date passed through employeeInfoForm
  public ModelAndView saveEmployeeInfo( @ModelAttribute( "employeeInfoForm" ) EmployeeInfo employeeInfo ) {
    employeeInfoService.saveOrUpdate( employeeInfo );                            // save in database
    return new ModelAndView( "redirect:/all" );                        // display the index1.html page
  }


  /* Clicking on the delete button in the right side of each row, deletes the row from the table */
  @RequestMapping( value = "/delete/{id}", method = RequestMethod.GET )
  public ModelAndView deleteEmployeeInfo( @PathVariable("id") int id ) {
    employeeInfoService.deleteEmployeeInfo( id );                        // delete row having PRI key = id
    return new ModelAndView( "redirect:/all" );                // display the index1.html page
  }
}
