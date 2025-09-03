package org.csvfile;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class CsvFileCreation {
    public static void main(String[] args) {
        List<Employee> employeeList = List.of(new Employee(12, "muttu", "IT"),
                new Employee(12, "muttu", "IT"),
                new Employee(12, "muttu", "IT")
        );
        String filePath = "src/main/java/org/csvfile/file.csv";
        writeCsv(employeeList, filePath);
        employeeList = readCsv(filePath);
        employeeList.forEach(System.out::println);
    }

    public static void writeCsv(List<Employee> employeeList, String filePath) {
        try (FileWriter writer = new FileWriter(filePath)) {
            StatefulBeanToCsv<Employee> beanToCsv = new StatefulBeanToCsvBuilder<Employee>(writer).build();
            beanToCsv.write(employeeList);
            System.out.println("Csv file is created successfully");
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public static List<Employee> readCsv(String filePath) {
        List<Employee> employeeList = new ArrayList<>();
        try (FileReader reader = new FileReader(filePath)) {

            CsvToBean<Employee> csvToBean = new CsvToBeanBuilder<Employee>(reader)
                    .withType(Employee.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
            employeeList = csvToBean.parse();
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            exception.printStackTrace();
        }
        return employeeList;
    }
}
