package ru.job4j2.lambda;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
/**
 * Checking converting matrix with Integer values to list.
 *
 * @author v.ivanov
 * @version 1
 * @since 12.01.2020
 */
public class MatrixToList {

    /** Field instance of LambdaUtils.*/
    private LambdaUtils<Integer> utils = new LambdaUtils<>();

    /**
     * Method to check converting matrix to list.
     */
    @Test
    public void checkConvertMatrixToList() {
        Integer[][] intArr = new Integer[][] {
                {1, 2, 3, 4, 5},
                {9, 8, 7, 6},
                {10, 11, 12}
        };
        List<Integer> actualList = utils.convertMatrixToList(intArr);
        List<Integer> expectedList = Arrays.asList(1, 2, 3, 4, 5, 9, 8, 7, 6, 10, 11, 12);
        Assert.assertThat(actualList, is(expectedList));
    }
}
