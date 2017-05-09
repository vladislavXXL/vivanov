package ru.job4j2.prof;
import ru.job4j2.sub.Patient;

/**
 * Class Doctor.
 * @author vivanov
 * @version 1
 * @since 08.05.2017
 */
public class Doctor extends Profession {

    /**
     * Method to make survey of patient.
     * @param patient - patient
     * @return result of survey
     */
    public String makeSurvey(Patient patient) {
        return "This is the result of survey " + patient.getName() + " " + patient.getLastName();
    }

    /**
     * Method to make a recipe for the patient.
     * @param patient - patient
     * @return recipe
     */
    public String writingRecipe(Patient patient) {
       return "This is the recipe for " + patient.getName() + " " + patient.getLastName();
    }

    /**
     * Method do add medicine to recipe.
     * @param recipe - recipe
     * @param medicine - medicine
     * @return result recipe
     */
    public String addToRecipe(String recipe, String medicine) {
        return recipe + " ," + medicine;
    }
}
