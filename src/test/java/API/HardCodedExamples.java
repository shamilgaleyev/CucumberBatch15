package API;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class HardCodedExamples {
   String baseURI = RestAssured.baseURI= "http://hrm.syntaxtechs.net/syntaxapi/api";

   String token = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE2ODQ5Njk5OTQsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTY4NTAxMzE5NCwidXNlcklkIjoiNTI1NiJ9.zjQ5U4mc4SlSkX1OHmNI-_rFGTirnUEzuor_i5MM_pA";
   static String employee_id;
   @Test
   public void acreateAnEmployee(){
       //prepare the requerst
      RequestSpecification preparedRequest = given().
              header("Content-Type","application/json").
              header("Authorization",token).
              body("{\n"
                      + "  \"emp_firstname\": \"Api\",\n"
                      + "  \"emp_lastname\": \"Crud\",\n"
                      + "  \"emp_middle_name\": \"Rest\",\n"
                      + "  \"emp_gender\": \"M\",\n"
                      + "  \"emp_birthday\": \"2000-05-20\",\n"
                      + "  \"emp_status\": \"confirmed\",\n"
                      + "  \"emp_job_title\": \"QA\"\n"
                      + "}");

       //hitting the endpoint/send a request
      Response response = preparedRequest.when().post("/createEmployee.php");
      //it will print the output in the console
      response.prettyPrint();
       //verifying the assertions/ get response
      response.then().assertThat().statusCode(201);

      //we are capturing employee id from the response
      employee_id=response.jsonPath().getString("Employee.employee_id");
      System.out.println(employee_id);

      //verifying the firstname in the response body
      response.then().assertThat().body("Employee.emp_firstname",equalTo("Api"));
      response.then().assertThat().body("Employee.emp_lastname",equalTo("Crud"));
      response.then().assertThat().header("Content-Type","application/json");

      System.out.println("My test case is passed");
   }

   @Test
   public void bgetCreatedEmployee(){
      RequestSpecification preparedRequest = given().
              header("Content-Type","application/json").
              header("Authorization",token).
              queryParam("employee_id", employee_id);
      //hitting the endpoint/send a request
      Response response = preparedRequest.when().get("/getOneEmployee.php");
      //it will print the output in the console
      response.prettyPrint();
      //verifying the assertions/ get response
      response.then().assertThat().statusCode(200);

      String tempEmpId = response.jsonPath().getString("employee.employee_id");

      //we have 2 empl id one is global and second is local
      Assert.assertEquals(employee_id,tempEmpId);

   }
    @Test
    public void cupdateEmployee(){
       RequestSpecification preparedRequest = given().
               header("Content-Type","application/json").
               header("Authorization",token).
               body("{\n"
                       + "        \"employee_id\": \""+employee_id+"\",\n"
                       + "        \"emp_firstname\": \"WebServis\",\n"
                       + "        \"emp_middle_name\": \"Rest\",\n"
                       + "        \"emp_lastname\": \"Crud\",\n"
                       + "        \"emp_birthday\": \"2000-05-20\",\n"
                       + "        \"emp_gender\": \"F\",\n"
                       + "        \"emp_job_title\": \"QA\",\n"
                       + "        \"emp_status\": \"probation\"\n"
                       + "    }");

       Response response = preparedRequest.when().put("/updateEmployee.php");

       response.then().assertThat().statusCode(200);
       //for verification
       response.then().assertThat().body("Message",equalTo("Employee record Updated"));

    }
    @Test
    public void  dgetUpdatedEmployee(){
       RequestSpecification preparedRequest = given().
               header("Content-Type","application/json").
               header("Authorization",token).
               queryParam("employee_id", employee_id);
       Response response = preparedRequest.when().get("/getOneEmployee.php");
       response.prettyPrint();
       response.then().assertThat().statusCode(200);
    }
    @Test
    public void egetAllEmployees(){
       RequestSpecification preparedRequest = given().
               header("Content-Type","application/json").
               header("Authorization",token);
       Response response = preparedRequest.when().get("/getAllEmployees.php");

       response.then().assertThat().statusCode(200);
    }

    @Test
    public void fgetJobTitle(){
        RequestSpecification preparedRequest = given().
                header("Content-Type","application/json").
                header("Authorization",token);
        Response response = preparedRequest.when().get("/JobTitle.php");

        response.then().assertThat().statusCode(200);

    }
}
