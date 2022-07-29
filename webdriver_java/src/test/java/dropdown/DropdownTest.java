package dropdown;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class DropdownTest extends BaseTests {

    @Test
    public void testSelectOption() {
        //Creamos el objeto de la página y entramos
        var dropDownPage = homePage.clickDropdown();

        //Creamos la variable a testear
        String option = "Option 1";
        //Seleccionamos la opción
        dropDownPage.selectFromDropdown(option);
        //Variable que crea una lista con las opciones seleccionadas
        var selectedOptions = dropDownPage.getSelectedOptions();
        //Verificamos que el tamaño de la lista sea 1 o devuelve un mensaje de error
        assertEquals(selectedOptions.size(), 1, "Incorrect number of selections");
        //Verificamos si la opción seleccionada es igual a la variable o devuelve un mensaje de error
        assertTrue(selectedOptions.contains(option), "Option not selected");
    }
}
