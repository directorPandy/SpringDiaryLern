package ru.director.SpringDiaryLern.spec;

import lombok.Data;

@Data

public class SearchCriteria {

        String key;
        Object value;
    SearchOperation operation;

    public SearchCriteria(String key,Object value, SearchOperation operation) {
        this.key = key;
        this.value = value;
        this.operation = operation;
    }
}

