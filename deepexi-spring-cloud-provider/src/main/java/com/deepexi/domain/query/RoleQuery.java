package com.deepexi.domain.query;


import lombok.Data;

@Data
public class RoleQuery extends PaginationRequest {
    private String code;
    private String name;
}
