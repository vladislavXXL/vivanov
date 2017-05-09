package ru.job4j2.prof;
import ru.job4j2.sub.Company;

/**
 * Class Engineer.
 * @author vivanov
 * @version 1
 * @since 09.05.2017
 */
public class Engineer extends Profession {

    /** Field company name.*/
    private String companyName;

    /** Method to get name of the project.
     * @param company - company
     * @return project name
     */
    public String developProject(Company company) {
        return "The project for " + company.getName() + " is " +  " " + company.getProjectName();
    }

    /**
     * Method to analyze the project.
     * @param company - company
     * @return review to the project
     */
    public String analyzeProject(Company company) {
        return "This is a review to a project " + company.getProjectName();
    }

    /**
     * Method to add requirements to the project.
     * @param company - company
     * @param str - string with additional requirements
     * @return result requirements
     */
    public String addRequirements(Company company, String str) {
        return company.getRequirements() + " " + str;
    }
}
