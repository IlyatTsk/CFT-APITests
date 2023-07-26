package tests;

import clients.DuckCRUDClient;
import com.consol.citrus.TestCaseRunner;
import com.consol.citrus.annotations.CitrusResource;
import com.consol.citrus.annotations.CitrusTest;
import org.springframework.http.HttpStatus;
import org.testng.annotations.Optional;
import org.testng.annotations.Test;

public class DuckDeleteTests extends DuckCRUDClient {

    @CitrusTest
    @Test(description = "Проверка корректного запроса удаления уточки")
    public void successfulDelete(@Optional @CitrusResource TestCaseRunner runner) {
        duckCreate(runner, "getDuckPropertiesTest/createYellowRubberActiveDuck.json");
        extractId(runner);

        duckDelete(runner, "${duckId}");

        validateResponseWithFileFromResources(runner, HttpStatus.OK, "DeleteTests/successfulDeleteTests.json");
    }
}
