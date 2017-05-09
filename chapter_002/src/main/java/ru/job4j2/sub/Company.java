package ru.job4j2.sub;

/**
 * Class company that describes company.
 * @author vivanov
 * @version 1
 * @since 09.05.2017
 */
public class Company {

    /** Field name of the company.*/
    private String name;

    /** Field company address.*/
    private String address;

    /** Field project name.*/
    private String projectName;

    /** Field requirements.*/
    private String requirements;

    /** Company name getter.
     * @return name of company
     */
    public String getName() {
        return this.name;
    }

    /**
     * Company address getter.
     * @return address
     */
    public String getAdderss() {
        return this.address;
    }
    /**
     * Get project name.
     * @return project name
     */
    public String getProjectName() {
        return this.projectName;
    }

    /**
     * Requirements getter.
     * @return requirements
     */
    public String getRequirements() {
        return this.requirements;
    }
}
