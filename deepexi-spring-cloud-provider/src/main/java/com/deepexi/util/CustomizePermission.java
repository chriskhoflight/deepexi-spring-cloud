package com.deepexi.util;


import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 模仿 shiro中 WildcardPermission 权限处理逻辑
 *
 * 解析传入的权限码
 */
public class CustomizePermission {

    private static final String WILDCARD_TOKEN = "*";
    private static final String PART_DIVIDER_TOKEN = ":";
    private static final String SUBPART_DIVIDER_TOKEN = ",";
    private static final boolean DEFAULT_CASE_SENSITIVE = false;

    private List<Set<String>> parts;

    public CustomizePermission(String permissions){
        this(permissions,DEFAULT_CASE_SENSITIVE);
    }

    public CustomizePermission(String permissions, boolean caseSensitive){
        this.setParts(permissions,caseSensitive);
    }

    private void setParts(String permissions, boolean caseSensitive) {
        permissions = StringUtils.trimToEmpty(permissions);

        if (StringUtils.isBlank(permissions)){
            throw new IllegalArgumentException("Permissions string cannot be null or empty. Make sure permission strings are properly formatted.");
        }

        if (!caseSensitive){
            permissions = permissions.toLowerCase();
        }

        List<String> parts = Stream.of(permissions.split(PART_DIVIDER_TOKEN)).collect(Collectors.toList());
        this.parts = new ArrayList<>();
        for (String part : parts){
            Set<String> sbuParts = Stream.of(part.split(SUBPART_DIVIDER_TOKEN)).collect(Collectors.toSet());

            if (sbuParts.isEmpty()){
                throw new IllegalArgumentException("Permissions string cannot contain parts with only dividers. Make sure permission strings are properly formatted.");
            }

            this.parts.add(sbuParts);
        }
        if (this.parts.isEmpty()){
            throw new IllegalArgumentException("Permissions string cannot contain only dividers. Make sure permission strings are properly formatted.");
        }
    }

    public boolean implies(CustomizePermission pending) {
        List<Set<String>> otherParts = pending.getParts();

        int i = 0;
        for (Set<String> otherPart : otherParts) {
            if (getParts().size() - 1 < i) {
                return true;
            } else {
                Set<String> part = getParts().get(i);
                if (!part.contains(WILDCARD_TOKEN) && !part.containsAll(otherPart)) {
                    return false;
                }

                i++;
            }
        }

        for (; i < getParts().size(); i++) {
            Set<String> part = getParts().get(i);
            if (!part.contains(WILDCARD_TOKEN)) {
                return false;
            }
        }

        return true;
    }

    private List<Set<String>> getParts(){
        return this.parts;
    }
}
