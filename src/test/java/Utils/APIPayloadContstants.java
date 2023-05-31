package Utils;

import org.json.JSONObject;

public class APIPayloadContstants {
    //we will pass body in multipal format, for this we have created this class
    public static String createEmployeePayload(){
        String createEmployeePayload = "{\n"
                + "  \"emp_firstname\": \"Api\",\n"
                + "  \"emp_lastname\": \"Crud\",\n"
                + "  \"emp_middle_name\": \"Rest\",\n"
                + "  \"emp_gender\": \"M\",\n"
                + "  \"emp_birthday\": \"2000-05-20\",\n"
                + "  \"emp_status\": \"confirmed\",\n"
                + "  \"emp_job_title\": \"QA\"\n"
                + "}";
        return createEmployeePayload;
    }

    public static String createEmployeePayloadJson(){
        JSONObject obj = new JSONObject();
        obj.put("emp_firstname","Api");
        obj.put("emp_lastname","Crud");
        obj.put("emp_middle_name","Rest");
        obj.put("emp_gender","M");
        obj.put("emp_birthday","2000-05-20");
        obj.put("emp_status","confirmed");
        obj.put("emp_job_title","QA");

        return obj.toString();
    }

    public static String createEmployeePayloadDynamic
            (String emp_firstname, String emp_lastname,
             String emp_middle_name, String emp_gender, String emp_birthday,
             String emp_status, String emp_job_title){

        JSONObject obj = new JSONObject();
        obj.put("emp_firstname", emp_firstname);
        obj.put("emp_lastname", emp_lastname);
        obj.put("emp_middle_name", emp_middle_name);
        obj.put("emp_gender", emp_gender);
        obj.put("emp_birthday", emp_birthday);
        obj.put("emp_status", emp_status);
        obj.put("emp_job_title", emp_job_title);

        return obj.toString();
    }
    public static String updateEmployeePayloadJson(){
        JSONObject obj = new JSONObject();
        obj.put("employee_id","54474A");
        obj.put("emp_firstname","WebServis");
        obj.put("emp_lastname","Crud");
        obj.put("emp_middle_name","Rest");
        obj.put("emp_gender","M");
        obj.put("emp_birthday","2001-05-20");
        obj.put("emp_status","confirmed");
        obj.put("emp_job_title","Engeneer");

        return obj.toString();
    }
}
