package com.deepexi.service.manager;

import com.google.common.collect.Maps;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class PermissionManager {

    private final Map<String,Permission> permissions = Maps.newHashMap();

    public PermissionManager(){
        Arrays.stream(com.deepexi.enums.PermissionCode.values()).forEach(permissionCode ->
                this.permissions.put(
                        permissionCode.getCode(),
                        new Permission()
                        .setCode(permissionCode.getCode())
                        .setName(permissionCode.getName())
                ));
    }

    public List<Permission> list(){
        return new ArrayList<>(this.permissions.values());
    }

    public Optional<Permission> get(String code){
        return Optional.ofNullable(this.permissions.get(code));
    }





    @Data
    @Accessors(chain = true)
    public static class Permission {
        private String code;
        private String name;
    }


}

