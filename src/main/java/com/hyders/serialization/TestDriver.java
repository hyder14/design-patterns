package com.hyders.serialization;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TestDriver {


    public static void main (String[] args) {
//"Status":"1","BIC":"SCBLPKKA","RAASTPartnerBanks":"Standard Chartered Bank";
//"Status":"1","BIC":"ASCMPKKA","RAASTPartnerBanks":"Askari Bank"



        FromClass baseClass = new FromClass();

        baseClass.setBIC("SCBLPKKA");
        baseClass.setStatus("1");
        baseClass.setRAASTPartnerBanks("Standard Chartered Bank");

        FromClass baseClass2 = new FromClass();
        baseClass2.setRAASTPartnerBanks("Askari Bank");
        baseClass2.setStatus("1");
        baseClass2.setBIC("ASCMPKKA");


        ObjectMapper mapper = new ObjectMapper();

        ToClass obj = mapper.convertValue(baseClass,ToClass.class);


        System.out.println(obj.toString());


        List<FromClass> fromClassList = new ArrayList<>();


        fromClassList.add(baseClass);
        fromClassList.add(baseClass2);

        List<ToClass> toClassList = fromClassList.stream().map(entry-> mapper.convertValue(entry,ToClass.class)).collect(Collectors.toList());
        toClassList.forEach(x-> System.out.println(x.toString()));

        String jsonString = "[{\"Status\":1,\"BIC\":\"SCBLPKKA\",\"RAASTPartnerBanks\":\"Standard Chartered Bank\"}, {\"Status\":1,\"BIC\":\"ASCMPKKA\",\"RAASTPartnerBanks\":\"Askari Bank\"}]";
        String jsonString2 = "[{\"status\":1,\"bicCode\":\"SCBLPKKA\",\"bankName\":\"Standard Chartered Bank\"}, {\"status\":1,\"bicCode\":\"ASCMPKKA\",\"bankName\":\"Askari Bank\"}]";

        try {
            List<InferredClass> inferredClassList = mapper.readValue(jsonString, new TypeReference<List<InferredClass>>(){});

            List<InferredClass> inferredClassList2 = mapper.readValue(jsonString2, new TypeReference<List<InferredClass>>(){});

            inferredClassList.forEach(listEntry-> System.out.println(listEntry.toString()));

            //For jsonString2, the object will be returned as null, annotation @JsonProperty ensures that json string
            //only provided with the parameter names in annotations are transformed into Java objects
            inferredClassList2.forEach(listEntry-> System.out.println(listEntry.toString()));

        } catch (Exception ex) {
            System.out.println(ex.fillInStackTrace());
        }
    }
}
