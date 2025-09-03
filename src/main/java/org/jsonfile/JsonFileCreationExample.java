package org.jsonfile;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.collections.iterators.EmptyOrderedIterator;
import org.csvfile.Employee;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class JsonFileCreationExample {
    public static void main(String[] args) {
        List<org.csvfile.Employee> employeeList = List.of(new org.csvfile.Employee(12, "muttu", "IT"),
                new org.csvfile.Employee(12, "muttu", "IT"),
                new Employee(12, "muttu", "IT")
        );
        String filePath = "src/main/java/org/jsonfile/file.json";
        writeToJsonFile(employeeList,filePath);
        readFromJson(filePath).forEach(System.out::println);
    }
    public static void writeToJsonFile(List<Employee> employeeList ,String filePath){
        ObjectMapper mapper=new ObjectMapper();
        try(FileWriter writer=new FileWriter(filePath)){
            mapper.writerWithDefaultPrettyPrinter().writeValue(writer,employeeList);
            System.out.println("Written successfully in json file");
        }
        catch (Exception exception){
            exception.printStackTrace();
        }
    }
    public static  List<Employee> readFromJson(String filePath){
        ObjectMapper mapper=new ObjectMapper();
        try(FileReader reader=new FileReader(filePath)){
            return mapper.readValue(reader, new TypeReference<List<Employee>>(){});
        }
        catch (Exception exception){
            exception.printStackTrace();
        }
        return new ArrayList<>();
    }
}
